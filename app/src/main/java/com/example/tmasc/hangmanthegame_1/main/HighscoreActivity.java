package com.example.tmasc.hangmanthegame_1.main;

import android.content.Intent;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.tmasc.hangmanthegame_1.R;
import com.example.tmasc.hangmanthegame_1.data.DAO.HighscoreDAO;
import com.example.tmasc.hangmanthegame_1.data.DAO.IHighscoreDAO;
import com.example.tmasc.hangmanthegame_1.adapter.ListAdapter;
import com.example.tmasc.hangmanthegame_1.data.exception.DataException;


public class HighscoreActivity extends AppCompatActivity {

    private ImageView hangManTheGame;
    private TextView highScore;
    public ListView HighScoreList;
    public ListAdapter adapter;

    HighscoreDAO dao = HighscoreDAO.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_highscore);

        IHighscoreDAO dao = HighscoreDAO.getInstance();

        try {
            dao.load(getBaseContext());

            dao.save(getBaseContext());
            System.out.println("Size: " + dao.getList().size());
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            adapter = new ListAdapter(getBaseContext(), R.layout.highscorelistitem, dao.getList());
        } catch (DataException e) {
            e.printStackTrace();
        }

        HighScoreList = (ListView) findViewById(R.id.highScoreList);

        HighScoreList.setAdapter(adapter);

        hangManTheGame = (ImageView) findViewById(R.id.hangManTheGame);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent initGame = new Intent(this, MenuActivity.class);
        startActivity(initGame);
        System.out.println("Trying to start MenuActivity.");
    }
}
