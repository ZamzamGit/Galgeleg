package com.example.galgelegii.logik;

import java.util.Date;

public class HighScore {
    private String word;
    private int score;
    private String time;

    public HighScore(String word, int score, String time) {
        this.word = word;
        this.score = score;
        this.time = time;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
