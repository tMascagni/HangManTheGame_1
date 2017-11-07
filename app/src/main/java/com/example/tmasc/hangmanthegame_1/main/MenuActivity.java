package com.example.tmasc.hangmanthegame_1.main;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.tmasc.hangmanthegame_1.R;

public class MenuActivity extends AppCompatActivity implements View.OnClickListener{


    private Button Start_btn, High_btn, Help_btn;
    private ImageView welcomeView, hangManTheGame;

    private static boolean isPlaying = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        //Instantiate.
        Start_btn = (Button) findViewById(R.id.Start_btn);
        High_btn = (Button) findViewById(R.id.High_btn);
        Help_btn = (Button) findViewById(R.id.Help_btn);
        welcomeView = (ImageView) findViewById(R.id.welcomeView);
        hangManTheGame = (ImageView) findViewById(R.id.hangManTheGame);

        //I/O listeners.
        Start_btn.setOnClickListener(this);
        High_btn.setOnClickListener(this);
        Help_btn.setOnClickListener(this);
        welcomeView.setOnClickListener(this);
        hangManTheGame.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.Start_btn:
                if (view instanceof Button) {
                    ((Button) view).setBackgroundColor(Color.DKGRAY);
                    ((Button) view).setTextColor(Color.BLACK);
                }
                Intent initGame = new Intent(this, GameActivity.class);
                startActivity(initGame);
                System.out.println("Trying to start GameActivity_1.");
                break;
            case R.id.High_btn:
                if (view instanceof Button) {
                    ((Button) view).setBackgroundColor(Color.DKGRAY);
                    ((Button) view).setTextColor(Color.BLACK);
                }
                Intent initHighscore = new Intent(this, HighscoreActivity.class);
                startActivity(initHighscore);
                System.out.println("Trying to start HighscoreActivity.");
                break;
            case R.id.Help_btn:
                if (view instanceof Button) {
                    ((Button) view).setBackgroundColor(Color.DKGRAY);
                    ((Button) view).setTextColor(Color.BLACK);
                }
                Intent initHelp = new Intent(this, HelpActivity.class);
                startActivity(initHelp);
                System.out.println("Trying to start HelpActivity.");
                break;
            default:
                break;
        }
    }

}
