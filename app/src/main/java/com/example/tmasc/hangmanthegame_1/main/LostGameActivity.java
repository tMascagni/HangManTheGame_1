package com.example.tmasc.hangmanthegame_1.main;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.tmasc.hangmanthegame_1.R;
import com.example.tmasc.hangmanthegame_1.gameLogic.GameLogic;

import org.w3c.dom.Text;

public class LostGameActivity extends AppCompatActivity {

    private ImageView hangManTheGame;
    private ImageView hangMan;
    private TextView lostTheGame;
    private TextView theWordWas;
    private TextView theWord;
    private TextView goBack;

    private final GameLogic logic = GameLogic.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lost_game);

        hangManTheGame = (ImageView) findViewById(R.id.hangManTheGame);
        hangMan = (ImageView) findViewById(R.id.hangMan);
        lostTheGame = (TextView) findViewById(R.id.lostTheGame);
        theWordWas = (TextView) findViewById(R.id.theWordWas);
        theWord = (TextView) findViewById(R.id.theWord);
        goBack = (TextView) findViewById(R.id.goBack);

        //Update function
        updateDisplay();
    }

    public void updateDisplay() {
        //Update theWord.
        theWord.setText(logic.getTheWord()  );
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent initGame = new Intent(this, MenuActivity.class);
        startActivity(initGame);
        System.out.println("Trying to start MenuActivity.");
    }
}
