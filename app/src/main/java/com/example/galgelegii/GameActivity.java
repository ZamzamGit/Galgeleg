package com.example.galgelegii;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class GameActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView imageView;
    private Galgelogik galgelogik;
    private Button button;
    private TextView ord;
    private TextView brugteBogstaver;
    private EditText bogstavGæt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        galgelogik = Galgelogik.getInstans();
        ord = findViewById(R.id.valgtOrd);
        button = findViewById(R.id.button);
        button.setOnClickListener(this);

        Executor bgThread = Executors.newSingleThreadExecutor(); // en baggrundstråd
        Handler uiThread = new Handler(Looper.getMainLooper());  // forgrundstråden

        bgThread.execute(() -> {
            try {
                galgelogik.getOrd("regneark").hentOrd(galgelogik.muligeOrd);
                galgelogik.startNytSpil();

                uiThread.post(() -> {
                    ord.setText(galgelogik.getSynligtOrd());
                });
            } catch (Exception e) {
                e.printStackTrace();
                uiThread.post(() -> {
                    ord.setText("Fejl ved hentningen af ord");
                });
            }
        });
    }

    @Override
    public void onClick(View view) {

        imageView = findViewById(R.id.imageView);
        bogstavGæt = findViewById(R.id.bogstav);

        galgelogik.gætBogstav(bogstavGæt.getText().toString().toLowerCase());

        if(bogstavGæt.getText().toString().equalsIgnoreCase(galgelogik.getOrdet())) {
            ord.setText(galgelogik.getOrdet());
            gameOver(true);
        }

        ord.setText(galgelogik.getSynligtOrd());
        brugteBogstaver = findViewById(R.id.brugteBogstaver);
        brugteBogstaver.setText(galgelogik.getBrugteBogstaver().toString());

        bogstavGæt.getText().clear();

        switch (galgelogik.getAntalForkerteBogstaver()) {
            case 1:
                imageView.setImageResource(R.drawable.forkert1);
                break;
            case 2:
                imageView.setImageResource(R.drawable.forkert2);
                break;
            case 3:
                imageView.setImageResource(R.drawable.forkert3);
                break;
            case 4:
                imageView.setImageResource(R.drawable.forkert4);
                break;
            case 5:
                imageView.setImageResource(R.drawable.forkert5);
                break;
            case 6: imageView.setImageResource(R.drawable.forkert6);
            break;
        }

        if(galgelogik.erSpilletVundet()) gameOver(true);
        if(galgelogik.erSpilletTabt()) gameOver(false);
    }

    public void gameOver(boolean gameStatus) {

        if(gameStatus) {
            Intent winActivity = new Intent(this, VundetAktivitet.class);
            winActivity.putExtra("forsøg", Integer.toString(galgelogik.getAntalForkerteBogstaver()));
            startActivity(winActivity);
        } else {
            Intent looseActivity = new Intent(this, TabtAktivitet.class);
            looseActivity.putExtra("ord", galgelogik.getOrdet());
            startActivity(looseActivity);
        }
    }
}