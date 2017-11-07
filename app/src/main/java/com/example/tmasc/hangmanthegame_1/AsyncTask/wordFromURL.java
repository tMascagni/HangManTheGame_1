package com.example.tmasc.hangmanthegame_1.AsyncTask;

import android.os.AsyncTask;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
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
           getWordFromURL();
        } catch (Exception e) {
            e.printStackTrace();
        }
    return words;
    }

    public void getWordFromURL() throws Exception {
        String data = fetchURL("https://en.wikipedia.org/wiki/RuneScape");
        //System.out.println("data = " + data);

        data = data.substring(data.indexOf("<body")). // fjern headere
                replaceAll("<.+?>", " ").toLowerCase(). // fjern tags
                replaceAll("&#198;", "æ"). // erstat HTML-tegn
                replaceAll("&#230;", "æ"). // erstat HTML-tegn
                replaceAll("&#216;", "ø"). // erstat HTML-tegn
                replaceAll("&#248;", "ø"). // erstat HTML-tegn
                replaceAll("&oslash;", "ø"). // erstat HTML-tegn
                replaceAll("&#229;", "å"). // erstat HTML-tegn
                replaceAll("[^a-zæøå]", " "). // fjern tegn der ikke er bogstaver
                replaceAll(" [a-zæøå] ", " "). // fjern 1-bogstavsord
                replaceAll(" [a-zæøå][a-zæøå] ", " "); // fjern 2-bogstavsord

        System.out.println("data = " + data);
        System.out.println("data = " + Arrays.asList(data.split("\\s+")));
        words.clear();
        words.addAll(new HashSet<String>(Arrays.asList(data.split(" "))));

        System.out.println("possibleWord = " + words);
        //reset();
    }

    public static String fetchURL(String url) throws IOException {
        System.out.println("Fetching data from " + url);
        BufferedReader br = new BufferedReader(new InputStreamReader(new URL(url).openStream()));
        StringBuilder sb = new StringBuilder();
        String linje = br.readLine();
        while (linje != null) {
            sb.append(linje + "\n");
            linje = br.readLine();
        }
        return sb.toString();
    }

    @Override
    protected void onPostExecute(List<String> strings) {
        super.onPostExecute(strings);
        gameLogic.setPossibleWords(strings);

        for (int i = 0; i < strings.size(); i++)
            System.out.println("Word [" + i + "]: " + strings.get(i));

    }
}
