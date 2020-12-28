package com.example.galgelegii;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
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

        MediaPlayer mp = MediaPlayer.create(TabtAktivitet.this, R.raw.lost);

        TextView ordDisplay = findViewById(R.id.ordDisplay);
        Intent i = getIntent();

        String ord = i.getStringExtra("ord");
        ordDisplay.setText("Ordet var " + ord);

        mp.setVolume(1,1);
        mp.start();
        Button spilIgen = findViewById(R.id.spilIgen);
        spilIgen.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent i = new Intent(this, GameActivity.class);
        startActivity(i);
    }


    @Override
    public void onBackPressed() {
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
        super.onBackPressed();
    }
}