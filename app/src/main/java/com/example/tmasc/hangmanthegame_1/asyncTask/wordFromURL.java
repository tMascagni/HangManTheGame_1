package com.example.tmasc.hangmanthegame_1.asyncTask;

import android.os.AsyncTask;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import com.example.tmasc.hangmanthegame_1.gameLogic.GameLogic;

public class wordFromURL extends AsyncTask<String, String, List<String>>{

    private final GameLogic gameLogic = GameLogic.getInstance();
    ArrayList<String> words;

    @Override
    protected List<String> doInBackground(String... strings) {
        words = new ArrayList<>();
        System.out.println("Starting AsyncTask");

        try {
            String data = gameLogic.fetchURL("https://en.wikipedia.org/wiki/Wikipedia:Random");
            data = data.replaceAll("<.+?>", " ").toLowerCase().replaceAll("[^a-z]", " ");
            words.addAll(new HashSet<>(Arrays.asList(data.split(" "))));
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    return words;
    }

    @Override
    protected void onPostExecute(List<String> strings) {
        super.onPostExecute(strings);
        gameLogic.setPossibleWords(strings);
        gameLogic.updateWord();

        for (int i = 0; i < strings.size(); i++)
            System.out.println("Word [" + i + "]: " + strings.get(i));
    }
}
