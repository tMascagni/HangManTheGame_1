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

public class WonGameActivity extends AppCompatActivity implements View.OnClickListener {


    private ImageView hangManTheGame, gallow;
    private TextView wonTheGame, amountOfGuesses, guesses, continueTxt, lifes, lifesPoints, points, pointsPoints;
    private Button continueGameBtn, storeScoreBtn;


    private final GameLogic logic = GameLogic.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_won_game);

        // Initiate.
        hangManTheGame = (ImageView) findViewById(R.id.hangManTheGame);
        gallow = (ImageView) findViewById(R.id.gallow);
        wonTheGame = (TextView) findViewById(R.id.wonTheGame);
        amountOfGuesses = (TextView) findViewById(R.id.amountOfGuesses);
        guesses = (TextView) findViewById(R.id.points);
        continueTxt = (TextView) findViewById(R.id.continueTxt);
        lifes = (TextView) findViewById(R.id.lifes);
        lifesPoints = (TextView) findViewById(R.id.lifesPoints);
        points = (TextView) findViewById(R.id.points);
        pointsPoints = (TextView) findViewById(R.id.pointsPoints);
        continueGameBtn = (Button) findViewById(R.id.continueGameBtn);
        storeScoreBtn = (Button) findViewById(R.id.storeScoreBtn);

        // I/O listeners.
        continueGameBtn.setOnClickListener(this);
        storeScoreBtn.setOnClickListener(this);

        //Update display.
        updateDisplay();
    }

    public void updateDisplay() {
        // Update guesses counter.
        guesses.setText(Integer.toString(logic.getTotalGuesses()));

        // Update lifes left
        lifesPoints.setText((Integer.toString((logic.getLife()))));

        // Update points
        pointsPoints.setText((Integer.toString(logic.getScore())));

        // Update image according to lives left.
        switch (logic.getLife()) {
            case 7:
                gallow.setImageResource(R.drawable.galge_1);
                break;
            case 6:
                gallow.setImageResource(R.drawable.forkert1_1);
                break;
            case 5:
                gallow.setImageResource(R.drawable.forkert2_1);
                break;
            case 4:
                gallow.setImageResource(R.drawable.forkert3_1);
                break;
            case 3:
                gallow.setImageResource(R.drawable.forkert4_1);
                break;
            case 2:
                gallow.setImageResource(R.drawable.forkert5_1);
                break;
            case 1:
                gallow.setImageResource(R.drawable.forkert6_1);
                break;
            case 0:
                gallow.setImageResource(R.drawable.forkert7_1);
            default:
                break;
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.continueGameBtn:
                if (view instanceof Button) {
                    ((Button) view).setBackgroundColor(Color.DKGRAY);
                    ((Button) view).setTextColor(Color.BLACK);
                }
                Intent initGame = new Intent(this, GameActivity.class);
                startActivity(initGame);
                System.out.println("Trying to start GameActivity_1.");
                break;
            case R.id.storeScoreBtn:
                if (view instanceof Button) {
                    ((Button) view).setBackgroundColor(Color.DKGRAY);
                    ((Button) view).setTextColor(Color.BLACK);
                }
                Intent initHighscore = new Intent(this, HighscoreCreateScoreActivity.class);
                startActivity(initHighscore);
                System.out.println("Trying to start HighscoreActivity.");
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
