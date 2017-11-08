package com.example.tmasc.hangmanthegame_1.main;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.tmasc.hangmanthegame_1.R;
import com.example.tmasc.hangmanthegame_1.gameLogic.GameLogic;
import com.example.tmasc.hangmanthegame_1.main.HighscoreCreateScoreActivity;

public class LostGameActivity extends AppCompatActivity implements View.OnClickListener{

    private ImageView hangManTheGame;
    private ImageView hangMan;
    private TextView lostTheGame;
    private TextView theWordWas;
    private TextView theWord;
    private TextView yourScore;
    private TextView points;
    private TextView goBack;
    private Button storeScore;


    private final GameLogic logic = GameLogic.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lost_game);

        // Initiate
        hangManTheGame = (ImageView) findViewById(R.id.hangManTheGame);
        hangMan = (ImageView) findViewById(R.id.hangMan);
        lostTheGame = (TextView) findViewById(R.id.lostTheGame);
        theWordWas = (TextView) findViewById(R.id.theWordWas);
        theWord = (TextView) findViewById(R.id.theWord);
        yourScore = (TextView) findViewById(R.id.yourScore);
        points = (TextView) findViewById(R.id.points);
        goBack = (TextView) findViewById(R.id.goBack);
        storeScore = (Button) findViewById(R.id.storeScore);

        // I/O listeners.
        storeScore.setOnClickListener(this);

        //Update function
        updateDisplay();
    }

    public void updateDisplay() {
        // Update theWord.
        theWord.setText(logic.getTheWord());

        // Update Points.
        points.setText(String.valueOf(logic.getScore()));
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.storeScore:
                if (view instanceof Button) {
                    ((Button) view).setBackgroundColor(Color.DKGRAY);
                    ((Button) view).setTextColor(Color.BLACK);
                }
                Intent initGame = new Intent(this, HighscoreCreateScoreActivity.class);
                startActivity(initGame);
                System.out.println("Trying to start HighscoreCreateScoreActivity.");
                break;
            default:
                break;
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent initGame = new Intent(this, MenuActivity.class);
        startActivity(initGame);
        System.out.println("Trying to start MenuActivity.");
    }
}
