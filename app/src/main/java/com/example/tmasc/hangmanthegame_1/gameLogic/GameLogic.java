package com.example.tmasc.hangmanthegame_1.gameLogic;

import java.util.ArrayList;
import java.util.Random;


public class GameLogic {

        private ArrayList<String> possibleWords = new ArrayList<String>();
        private String theWord;
        private ArrayList<String> UsedLetters = new ArrayList<String>();
        private String visibleWord;
        private int wrongLetterAmount;
        private int totalGuesses;
        private boolean lastLetterWasCorrect;
        private boolean theGameIsWon;
        private boolean theGameIsLost;
        private static GameLogic instance = new GameLogic();
        private int life = 0;
        private int letterScore = 1;
        private final Random random = new Random();
        private int roundScore = 0;
        private int round = 0;
        private int score = 0;

        public ArrayList<String> getUsedLetters() {

            return UsedLetters;
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

        public static GameLogic getInstance() {
            return instance;
        }


        public int getTotalGuesses() {
            return totalGuesses;
        }


    public int getLife() {
            return life;
        }

        public GameLogic() {
            possibleWords.add("bil");
            possibleWords.add("computer");
            possibleWords.add("programmering");
            possibleWords.add("android");
            possibleWords.add("busrute");
            possibleWords.add("gangsti");
            possibleWords.add("skovsnegl");
            possibleWords.add("solsort");
            possibleWords.add("runescape");
            reset();
        }

        private String getRandomPossibleWord() {
            return possibleWords.get(random.nextInt(possibleWords.size()));
        }

        public void reset() {
            getUsedLetters().clear();
            wrongLetterAmount = 0;
            life = 7;
            totalGuesses = 0;
            theGameIsWon = false;
            theGameIsLost = false;
            theWord = possibleWords.get(new Random().nextInt(possibleWords.size()));
            opdaterSynligtOrd();
        }

        private void opdaterSynligtOrd() {
            visibleWord = "";
            theGameIsWon = true;
            for (int n = 0; n < theWord.length(); n++) {
                String letter = theWord.substring(n, n + 1);
                if (getUsedLetters().contains(letter)) {
                    visibleWord = visibleWord + letter;
                } else {
                    visibleWord = visibleWord + "*";
                    theGameIsWon = false;
                }
            }
        }

        public void guessLetter(String letter) {
            totalGuesses++;
            if (letter.length() != 1) return;
            System.out.println("Der gættes på bogstavet: " + letter);
            if (getUsedLetters().contains(letter)) return;
            if (theGameIsWon || theGameIsLost) return;

            getUsedLetters().add(letter);

            if (theWord.contains(letter)) {
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
            opdaterSynligtOrd();
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


