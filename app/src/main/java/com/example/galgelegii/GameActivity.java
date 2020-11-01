package com.example.galgelegii;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class GameActivity extends AppCompatActivity implements View.OnClickListener {

    ImageView imageView;
    Galgelogik galgelogik;
    Button button;
    TextView ord;
    TextView brugteBogstaver;
    EditText bogstavGæt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        galgelogik = new Galgelogik();

        ord = findViewById(R.id.valgtOrd);

        ord.setText(galgelogik.getSynligtOrd());


        button = findViewById(R.id.button);

        button.setOnClickListener(this);

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

/*
        for (int i = 0; i < galgelogik.getBrugteBogstaver().size(); i++) {
            brugteBogstaver.setText(galgelogik.getBrugteBogstaver().get(i));
        }

 */

      //  imageView.setImageResource(R.drawable.forkert1);
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