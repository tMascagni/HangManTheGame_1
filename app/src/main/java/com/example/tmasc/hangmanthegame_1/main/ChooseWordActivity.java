package com.example.tmasc.hangmanthegame_1.main;

import android.content.Intent;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.tmasc.hangmanthegame_1.R;
import com.example.tmasc.hangmanthegame_1.data.DAO.HighscoreDAO;
import com.example.tmasc.hangmanthegame_1.data.DAO.IHighscoreDAO;
import com.example.tmasc.hangmanthegame_1.adapter.ListAdapter;
import com.example.tmasc.hangmanthegame_1.data.exception.DataException;
import com.example.tmasc.hangmanthegame_1.gameLogic.GameLogic;

import java.util.List;


public class ChooseWordActivity extends AppCompatActivity implements View.OnClickListener{

    private ImageView hangManTheGame;
    public ListView wordList;

    private final GameLogic logic = GameLogic.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_word);

        ArrayAdapter<String> a = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, logic.getPossibleWords());

        hangManTheGame = (ImageView) findViewById(R.id.hangManTheGame);
        wordList = (ListView) findViewById(R.id.wordList);

        wordList.setAdapter(a);
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
