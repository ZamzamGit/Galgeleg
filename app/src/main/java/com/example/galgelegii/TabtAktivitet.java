package com.example.galgelegii;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

public class TabtAktivitet extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tabt_aktivitet);

        TextView ordDisplay = findViewById(R.id.ordDisplay);
        Intent i = getIntent();

        String ord = i.getStringExtra("ord");
        ordDisplay.setText("Ordet var " + ord);

        Button spilIgen = findViewById(R.id.spilIgen);
        spilIgen.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent i = new Intent(this, GameActivity.class);
        startActivity(i);
    }
}