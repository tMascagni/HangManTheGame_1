package com.example.tmasc.hangmanthegame_1.data.DTO;

public class HighscoreDTO {

    private static int id;
    private int score;
    private String name;

    public int getScore() {
        return score;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public HighscoreDTO(int score, String name) {
        this.id = id++;
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

    public int compare(HighscoreDTO dto_1, HighscoreDTO dto_2) {
        return Integer.compare(dto_1.getScore(), dto_2.getScore());
    }

}
