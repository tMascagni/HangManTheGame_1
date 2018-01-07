package com.example.tmasc.hangmanthegame_1.activities;

import android.content.Intent;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;

import com.example.tmasc.hangmanthegame_1.R;
import com.example.tmasc.hangmanthegame_1.adapter.PickWordAdapter;
import com.example.tmasc.hangmanthegame_1.gameLogic.GameLogic;




public class ChooseWordActivity extends AppCompatActivity implements View.OnClickListener{

    private ImageView hangManTheGame;
    public ListView wordList;


    private final GameLogic logic = GameLogic.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_word);

        /* Using costum array adapter to take in the list of words. */
        ArrayAdapter<String> s = new PickWordAdapter(this, R.layout.choosewordlistitem, logic.getPossibleWords());

        /* Init views. */
        hangManTheGame = (ImageView) findViewById(R.id.hangManTheGame);
        wordList = (ListView) findViewById(R.id.wordList);

        /* Put on adapter on wordList. */
        wordList.setAdapter(s);

        /* On click listener. */
        wordList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                String word = (String) adapterView.getItemAtPosition(position);

                Intent initGame = new Intent(ChooseWordActivity.this, GameActivity.class);
                logic.reset(); // Resets the logic layer.
                initGame.putExtra("new_secret_word", word); //Saves the word, so we can look it up in GameActivity
                startActivity(initGame);
                System.out.println("Trying to start GameActivity.");}
        });

    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent initGame = new Intent(this, MenuActivity.class);
        startActivity(initGame);
        System.out.println("Trying to start MenuActivity.");
    }

    @Override
    public void onClick(View view) {


    }
}
