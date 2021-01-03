package com.example.galgelegii;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class VundetAktivitet extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vundet_aktivitet);

        MediaPlayer mp = MediaPlayer.create(VundetAktivitet.this, R.raw.win);
        TextView forsøgDisplay = findViewById(R.id.forsoegDisplay);
        Intent i = getIntent();

        String antal = i.getStringExtra("forsøg");
        forsøgDisplay.setText("Antal forsøg: " + antal);

        mp.setVolume(1,1);
        mp.start();
        Button spilIgen = findViewById(R.id.spilIgen2);
        spilIgen.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent i = new Intent(this, KategoriAktivitet.class);
        startActivity(i);
    }

    @Override
    public void onBackPressed() {
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
        super.onBackPressed();
    }
}