package com.example.tmasc.hangmanthegame_1.main;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.tmasc.hangmanthegame_1.R;
import com.example.tmasc.hangmanthegame_1.gameLogic.GameLogic;


public class GameActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView hangManTheGame, gallow;
    private TextView showWord, lives, livesLeft, points, pointsPoints;

    private final int btnAmount = 26;

    private final Button[] btnArray = new Button[btnAmount];
    private final Integer[] btnIdArray = {
            R.id.a_btn, R.id.b_btn, R.id.c_btn, R.id.d_btn,
            R.id.e_btn, R.id.f_btn, R.id.g_btn, R.id.h_btn,
            R.id.i_btn, R.id.j_btn, R.id.k_btn, R.id.l_btn,
            R.id.m_btn, R.id.n_btn, R.id.o_btn, R.id.p_btn,
            R.id.q_btn, R.id.r_btn, R.id.s_btn, R.id.t_btn,
            R.id.u_btn, R.id.v_btn, R.id.w_btn, R.id.x_btn,
            R.id.y_btn, R.id.z_btn
    };

    private final GameLogic logic = GameLogic.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        // Updates the word you have to guess.
        logic.updateWord();

        // Instantiate.
        hangManTheGame = (ImageView) findViewById(R.id.hangManTheGame);
        gallow = (ImageView) findViewById(R.id.gallow);
        showWord = (TextView) findViewById(R.id.showWord);
        lives = (TextView) findViewById(R.id.lives);
        livesLeft = (TextView) findViewById(R.id.livesLeft);
        points = (TextView) findViewById(R.id.score);
        pointsPoints = (TextView) findViewById(R.id.pointsPoint);

        // for-loop to create all the buttons.
        for (int i = 0; i < btnArray.length; i++) {
            btnArray[i] = (Button) findViewById(btnIdArray[i]);
            btnArray[i].setOnClickListener(this);
        }

        // Update the display with the logic layer values.
        updateDisplay();

        // Disable keyboard.
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);
    }

    public void updateDisplay() {
        //Update theWord.
        showWord.setText(logic.getVisibleWord());

        //Update lives left.
        livesLeft.setText(Integer.toString(logic.getLife()));

        //Update guesses counter.
        pointsPoints.setText(Integer.toString(logic.getScore()));

        //Update image according to lives left.
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

    private void guess(String guess) {
        // Make the logic controller take a guess!
        logic.guessLetter(guess.toLowerCase());

        // Update the display, to see the next status after the guess-
        updateDisplay();

        // Check whether the game is lost or not.
        if (logic.isTheGameLost()) {
            Intent initLostGameActivity = new Intent(this, LostGameActivity.class);
            startActivity(initLostGameActivity);
            System.out.println("Trying to start LostGameActivity.");
        }

        // Check whether the game is won or not.
        if (logic.isTheGameWon()) {
            Intent initWonGameActivity = new Intent(this, WonGameActivity.class);
            startActivity(initWonGameActivity);
            System.out.println("Trying to start WonGameActivity.");
        }
    }


    @Override
    public void onClick(View view) {

        if (view instanceof Button) {
            String guess = ((Button) view).getText().toString();
            guess (guess);
            ((Button) view).setTextColor(Color.BLACK);
            ((Button) view).setBackgroundColor(Color.DKGRAY);
            view.setEnabled(false);
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
