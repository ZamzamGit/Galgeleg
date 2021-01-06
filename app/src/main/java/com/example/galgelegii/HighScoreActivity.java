package com.example.galgelegii;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.example.galgelegii.logik.HighScore;
import com.example.galgelegii.logik.HighScoreData;

import java.util.ArrayList;

public class HighScoreActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ArrayList<HighScore> scores;
    private HighScoreAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_highscore);

        // Opretter og indsætter alle highscores i RecyclerView
        HighScoreData data = HighScoreData.getInstance();
        recyclerView = findViewById(R.id.highScoreRecView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        scores = data.readData(this);
        adapter = new HighScoreAdapter(scores);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onBackPressed() {
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
        super.onBackPressed();
    }
}