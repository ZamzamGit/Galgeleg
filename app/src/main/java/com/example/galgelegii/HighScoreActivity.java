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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_highscore);



        HighScoreData data = HighScoreData.getInstance();
        scores = data.getHighScores();
        data.readData(this);

        recyclerView = findViewById(R.id.highScoreRecView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new HighScoreAdapter(scores));
    }

    @Override
    public void onBackPressed() {
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
        super.onBackPressed();
    }
}