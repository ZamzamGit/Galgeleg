package com.example.galgelegii.logik;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;


import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class HighScoreData {

    private ArrayList<HighScore> highScores;
    private static HighScoreData instance = new HighScoreData();

    private HighScoreData() {
        highScores = new ArrayList<>();
    }

    public void readData(Context context) {
        SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(context);
        Gson gson = new Gson();
        String json = sharedPref.getString("highscore","");
        Type type = new TypeToken<ArrayList<HighScore>>(){}.getType();
        highScores = gson.fromJson(json, type);

        if(highScores == null) {
            highScores = new ArrayList<>();
        }
    }

    public static HighScoreData getInstance() {
        return instance;
    }

    public void saveData(HighScore score, Context context) {

        HighScore s = findScore(score.getWord());
        SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(context);

        if(s != null) {
            s.setScore(score.getScore());
            s.setTime(score.getTime());
        } else {
            Gson gson = new Gson();
            highScores.add(score);
            String json = gson.toJson(highScores);
            sharedPref.edit().putString("highscore", json).apply();
        }
    }

    public ArrayList<HighScore> getHighScores() {
        return highScores;
    }

    public HighScore findScore(String word) {
        for (HighScore score : highScores) {
            if(score.getWord().equals(word)) {
                return score;
            }
        }
        return null;
    }
}
