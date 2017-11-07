package com.example.tmasc.hangmanthegame_1.main;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.tmasc.hangmanthegame_1.R;
import com.example.tmasc.hangmanthegame_1.gameLogic.GameLogic;

public class WonGameActivity extends AppCompatActivity {


    private ImageView hangManTheGame, gallow;
    private TextView wonTheGame, amountOfGuesses, guesses, goBack;

    private final GameLogic logic = GameLogic.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_won_game);

        hangManTheGame = (ImageView) findViewById(R.id.hangManTheGame);
        gallow = (ImageView) findViewById(R.id.gallow);
        wonTheGame = (TextView) findViewById(R.id.wonTheGame);
        amountOfGuesses = (TextView) findViewById(R.id.amountOfGuesses);
        guesses = (TextView) findViewById(R.id.guesses);
        goBack = (TextView) findViewById(R.id.goBack);

        //Update display.
        updateDisplay();
    }

    public void updateDisplay() {
        //Update guesses counter.
        guesses.setText(Integer.toString(logic.getTotalGuesses()));

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


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent initGame = new Intent(this, MenuActivity.class);
        startActivity(initGame);
        System.out.println("Trying to start MenuActivity.");
    }
}
