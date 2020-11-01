package com.example.galgelegii;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button startBtn = findViewById(R.id.startBtn);
        Button testBtn = findViewById(R.id.testBtn);

        startBtn.setOnClickListener(this);
        testBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        Intent i = new Intent(this, GameActivity.class);
        startActivity(i);

        if (view == findViewById(R.id.testBtn)) {
            Intent test = new Intent(this, VundetAktivitet.class);
            startActivity(test);
        }


    }
}