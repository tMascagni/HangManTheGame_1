package com.example.tmasc.hangmanthegame_1.activities;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.media.MediaPlayer;

import com.example.tmasc.hangmanthegame_1.R;
import com.example.tmasc.hangmanthegame_1.gameLogic.GameLogic;

import nl.dionsegijn.konfetti.KonfettiView;
import nl.dionsegijn.konfetti.models.Shape;
import nl.dionsegijn.konfetti.models.Size;

public class WonGameActivity extends AppCompatActivity implements View.OnClickListener {


    private ImageView hangManTheGame, gallow;
    private TextView wonTheGame, amountOfGuesses, guesses, continueTxt, lifes, lifesPoints, points, pointsPoints;
    private Button continueGameBtn, storeScoreBtn;


    private final GameLogic logic = GameLogic.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_won_game);

        // Play sound.
        MediaPlayer win_sound = MediaPlayer.create(this, R.raw.win);
        win_sound.start();

        // Initiate.
        hangManTheGame = (ImageView) findViewById(R.id.hangManTheGame);
        gallow = (ImageView) findViewById(R.id.gallow);
        wonTheGame = (TextView) findViewById(R.id.wonTheGame);
        amountOfGuesses = (TextView) findViewById(R.id.amountOfGuesses);
        guesses = (TextView) findViewById(R.id.score);
        continueTxt = (TextView) findViewById(R.id.continueTxt);
        lifes = (TextView) findViewById(R.id.lifes);
        lifesPoints = (TextView) findViewById(R.id.lifesPoints);
        points = (TextView) findViewById(R.id.score);
        pointsPoints = (TextView) findViewById(R.id.pointsPoints);
        continueGameBtn = (Button) findViewById(R.id.continueGameBtn);
        storeScoreBtn = (Button) findViewById(R.id.storeScoreBtn);
        KonfettiView viewKonfetti = (KonfettiView) findViewById(R.id.viewKonfetti);

        /* Confetti */
        /* This is taken from GitHub DanielMartinus - Konfetti */
        viewKonfetti.build()
                .addColors(Color.RED, Color.YELLOW, Color.MAGENTA)
                .setDirection(0.0, 359.0)
                .setSpeed(1f, 5f)
                .setFadeOutEnabled(true)
                .setTimeToLive(2000L)
                .addShapes(Shape.RECT, Shape.CIRCLE)
                .addSizes(new Size(15, 5f))
                .setPosition(100f, viewKonfetti.getWidth() + 10f, 0f, 0f)
                .stream(300, 5000L)
        ;


        /* I/O listeners. */
        continueGameBtn.setOnClickListener(this);
        storeScoreBtn.setOnClickListener(this);

        /* Update display. */
        updateDisplay();
    }

    public void updateDisplay() {
        /* Update guesses counter. */
        guesses.setText(Integer.toString(logic.getTotalGuesses()));

        /* Update lifes left */
        lifesPoints.setText((Integer.toString((logic.getLife()))));

        /* Update points */
        pointsPoints.setText((Integer.toString(logic.getScore())));

        /* Update image according to lives left. */
        switch (logic.getLife()) {
            case 7:
                gallow.setImageResource(R.drawable.galge_2);
                break;
            case 6:
                gallow.setImageResource(R.drawable.forkert1_2);
                break;
            case 5:
                gallow.setImageResource(R.drawable.forkert2_2);
                break;
            case 4:
                gallow.setImageResource(R.drawable.forkert3_2);
                break;
            case 3:
                gallow.setImageResource(R.drawable.forkert4_2);
                break;
            case 2:
                gallow.setImageResource(R.drawable.forkert5_2);
                break;
            case 1:
                gallow.setImageResource(R.drawable.forkert6_2);
                break;
            case 0:
                gallow.setImageResource(R.drawable.forkert7_2);
            default:
                break;
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.continueGameBtn:
                if (view instanceof Button) {
                    ((Button) view).setBackgroundColor(R.drawable.btn_color_shp_pressed);
                }
                Intent initGame = new Intent(this, GameActivity.class);
                startActivity(initGame);
                System.out.println("Trying to start GameActivity_1.");
                break;
            case R.id.storeScoreBtn:
                if (view instanceof Button) {
                    ((Button) view).setBackgroundColor(R.drawable.btn_color_shp_pressed);
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
