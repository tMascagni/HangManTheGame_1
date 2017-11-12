package com.example.tmasc.hangmanthegame_1.data.DTO;

import android.support.annotation.NonNull;

import java.io.Serializable;

public class HighscoreDTO implements Comparable<HighscoreDTO>, Serializable{

    private static int id;
    private int score;
    private String name;

    public int getScore() {
        return score;
    }

    public String getName() {
        return name;
    }


    public HighscoreDTO(int score, String name) {
        this.score = score;
        this.name = name;
    }

    @Override
    public String toString() {
        return "HighscoreDTO [" +
                "id = " + id +
                ", score = " + score +
                ", name = " + name +
                "]";
    }

    @Override
    public int compareTo(@NonNull HighscoreDTO other) {
        if (this.score == other.score)
            return 0;
        else if (this.score < other.score)
            return 1;
        else
            return -1;
    }
}
