package com.example.galgelegii.logik;
import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class HighScoreData {

   private ArrayList<HighScore> highScores = null;
   private static HighScoreData instance = new HighScoreData();

    private HighScoreData() {
    }

    /* https://stackoverflow.com/questions/14981233/android-arraylist-of-custom-objects-save-to-sharedpreferences-serializable
       brugt til at finde på denne løsning */

    // læser alle high scores i listen
    public ArrayList<HighScore> readData(Context context) {
        SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(context);
        Gson gson = new Gson();
        String json = sharedPref.getString("highscore",null); // henter json objekter
        Type type = new TypeToken<ArrayList<HighScore>>(){}.getType();
        ArrayList<HighScore> scores = gson.fromJson(json, type); // objekterne indsættes i arraylisten
       //sharedPref.edit().clear().commit();
        return scores;
    }

    public static HighScoreData getInstance() {
        return instance;
    }

    // gemmer highscore, enten opdaterer den en gammel highscore eller indsætter en ny i listen
    public void saveData(HighScore score, Context context) {
        SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(context);
        String json = sharedPref.getString("highscore", null);
        Gson gson = new Gson();

        if(json == null) { // tjekker om json indeholder objekter
            highScores = new ArrayList<>();
        } else {
            highScores = readData(context); // hvis json indeholder objekter bliver json objekterne indsat i arraylisten
        }

        HighScore s = findScore(score.getWord()); // tjekkes efter om ordet allerede befinder sig i highscore listen
        if(s != null) {
            if(score.getScore() > s.getScore()) { // ordets score opdateres kun, hvis den nye score er større end den gamle
                s.setScore(score.getScore());
                s.setTime(score.getTime());
            }
        } else {
            highScores.add(score); // hvis ordet ikke findes i highscore listen, tilføjes den til listen
        }

        json = gson.toJson(highScores); // objekterne laves til json
        sharedPref.edit().putString("highscore", json).apply(); // sætter json objekterne i preference manager, så de derefter kan blive læst
    }

    private HighScore findScore(String word) {
        for (HighScore score : highScores) {
            if(score.getWord().equals(word)) {
                return score;
            }
        }
        return null;
    }
}
