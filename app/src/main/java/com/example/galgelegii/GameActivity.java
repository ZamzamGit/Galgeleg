package com.example.galgelegii;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.galgelegii.logik.Galgelogik;
import com.example.galgelegii.logik.OrdFactory;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class GameActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView imageView;
    private Galgelogik galgelogik;;
    private TextView ord;
    private Button[] buttons;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        galgelogik = Galgelogik.getInstans();
        ord = findViewById(R.id.valgtOrd);
        imageView = findViewById(R.id.imageView);
        buttons = new Button[29];

        for (int i = 0; i < buttons.length ; i++) {
            String buttonId = "button" + (i+1);
            int resId = getResources().getIdentifier(buttonId, "id", getPackageName());
            buttons[i] = findViewById(resId);
            buttons[i].setOnClickListener(this);
        }


        String kategori;
        Intent intent = getIntent();

        kategori = intent.getStringExtra("kategori").toLowerCase();

        Executor bgThread = Executors.newSingleThreadExecutor(); // en baggrundstråd
        Handler uiThread = new Handler(Looper.getMainLooper());  // forgrundstråden

        bgThread.execute(() -> {
            try {
                OrdFactory.getInstance().getOrd(kategori).hentOrd(galgelogik.muligeOrd);
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

        for (int i = 0; i < buttons.length ; i++) {
            if(view.getId() == buttons[i].getId()) {
                galgelogik.gætBogstav(buttons[i].getText().toString());
                buttons[i].setVisibility(View.INVISIBLE);

            }
        }
        ord.setText(galgelogik.getSynligtOrd());

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

    @Override
    public void onBackPressed() {
        GameDialog dialog = new GameDialog();
        dialog.show(getSupportFragmentManager(), "game dialog");
        super.onBackPressed();
    }
}