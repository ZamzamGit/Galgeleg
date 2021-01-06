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

        // opretter MediaPlayer med taberlyd
        MediaPlayer mp = MediaPlayer.create(TabtAktivitet.this, R.raw.lost);

        TextView ordDisplay = findViewById(R.id.ordDisplay);
        Intent i = getIntent();

        // henter det korrekte ord
        String ord = i.getStringExtra("ord");
        ordDisplay.setText("Ordet var " + ord);

        mp.setVolume(2,2);
        mp.start(); // spiller taberlyd
        Button spilIgen = findViewById(R.id.spilIgen);
        Button menu = findViewById(R.id.menuBtn);
        spilIgen.setOnClickListener(this);
        menu.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        Intent i;

        if(view == findViewById(R.id.spilIgen)) {
             i = new Intent(this, KategoriAktivitet.class);
        } else {
             i = new Intent(this, MainActivity.class);
        }
        startActivity(i);
    }


    @Override
    public void onBackPressed() {
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
        super.onBackPressed();
    }
}