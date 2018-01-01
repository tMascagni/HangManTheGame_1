package com.example.tmasc.hangmanthegame_1.gameLogic;

import android.text.Editable;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import com.example.tmasc.hangmanthegame_1.asyncTask.wordFromURL;

public class GameLogic {

        private List<String> possibleWords = new ArrayList<String>();
        private List<String> possibleOfflineWords = new ArrayList<String>();
        private String theWord;
        private ArrayList<String> UsedLetters = new ArrayList<String>();
        private String visibleWord;
        private int wrongLetterAmount;
        private int totalGuesses;
        private boolean lastLetterWasCorrect;
        private boolean theGameIsWon;
        private boolean theGameIsLost;
        private static GameLogic instance;
        private int life = 0;
        private int letterScore = 10;
        private final Random random = new Random();
        private int score = 0;
        private String name = "Name";
        private boolean isOnline = false;

        public boolean getisOnline() {
            return isOnline;
        }

        public void setOnline(boolean online) {
        isOnline = online;
        }


        public ArrayList<String> getUsedLetters() {

            return UsedLetters;
        }
        public void setPossibleWords(List<String> list) {
            this.possibleWords = list;
        }
        public String getVisibleWord() {

            return visibleWord;
        }
        public String getTheWord() {

            return theWord;
        }
        public int getWrongLetterAmount() {

            return wrongLetterAmount;
        }
        public boolean isTheLastLetterCorrect() {

            return lastLetterWasCorrect;
        }
        public boolean isTheGameWon() {

            return theGameIsWon;
        }
        public boolean isTheGameLost() {

            return theGameIsLost;
        }
        public boolean isTheGameOver() {

            return theGameIsLost || theGameIsWon;
        }

        public int getTotalGuesses() {
            return totalGuesses;
        }
        public int getLife() {
            return life;
        }
        public int getScore() {
            return score; }
        public String getName() {return name; }
        public void setName(String navn) {
            this.name = navn; }

        private GameLogic() {
        }

        static {
            try {
                instance = new GameLogic();
            }
            catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

        public static synchronized GameLogic getInstance() {
            return instance;
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

        private String getRandomPossibleWord() {
            return possibleWords.get(random.nextInt(possibleWords.size()));
        }

        public void reset() {
            getUsedLetters().clear();
            wrongLetterAmount = 0;
            life = 7;
            score = 0;
            totalGuesses = 0;
            theGameIsWon = false;
            theGameIsLost = false;
        }

        public void updateWord(){
            getUsedLetters().clear();
            theWord = possibleWords.get(new Random().nextInt(possibleWords.size()));
            updateVisibleWord();
        }

        // Her opdaterer den ordet. Denne skal laves om til at den skal gøre det ud fra om isOnline er True eller False.
        private void updateVisibleWord() {
                visibleWord = "";
                theGameIsWon = true;
                for (int n = 0; n < theWord.length(); n++) {
                    String letter = theWord.substring(n, n + 1);
                    if (getUsedLetters().contains(letter)) {
                        visibleWord = visibleWord + letter;
                    } else {
                        visibleWord = visibleWord + "▢";
                        theGameIsWon = false;
                    }
                }
            }


        public List addOfflineWord() {
            possibleOfflineWords.add("car");
            possibleOfflineWords.add("android");
            possibleOfflineWords.add("programming");
            possibleOfflineWords.add("line");
            possibleOfflineWords.add("snap");
            return possibleOfflineWords;
        }

        public void guessLetter(String letter) {
            totalGuesses++;
            if (letter.length() != 1) return;
            System.out.println("Der gættes på bogstavet: " + letter);
            if (getUsedLetters().contains(letter)) return;
            if (theGameIsWon || theGameIsLost) return;

            getUsedLetters().add(letter);

            if (theWord.contains(letter)) {
                score += letterScore;
                lastLetterWasCorrect = true;
                System.out.println("Bogstavet var korrekt: " + letter);
            } else {
                // Vi gættede på et bogstav der ikke var i ordet.
                lastLetterWasCorrect = false;
                System.out.println("Bogstavet var IKKE korrekt: " + letter);
                wrongLetterAmount = wrongLetterAmount + 1;
                life--;
                if (wrongLetterAmount > 6) {
                    theGameIsLost = true;
                }
            }
            updateVisibleWord();
        }

        public void logStatus() {
            System.out.println("---------- ");
            System.out.println("- ordet (skult) = " + theWord);
            System.out.println("- synligtOrd = " + visibleWord);
            System.out.println("- forkerteBogstaver = " + getWrongLetterAmount());
            System.out.println("- brugeBogstaver = " + getUsedLetters());
            if (theGameIsLost) System.out.println("- THE GAME IS LOST");
            if (theGameIsWon) System.out.println("- THE GAME IS WON");
            System.out.println("---------- ");
        }
}


