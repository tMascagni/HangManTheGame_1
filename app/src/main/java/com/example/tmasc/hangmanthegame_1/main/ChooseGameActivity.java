package com.example.tmasc.hangmanthegame_1.main;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.tmasc.hangmanthegame_1.R;
import com.example.tmasc.hangmanthegame_1.asyncTask.wordFromURL;
import com.example.tmasc.hangmanthegame_1.gameLogic.GameLogic;

public class ChooseGameActivity extends AppCompatActivity implements View.OnClickListener{


    private Button One_player_btn, Two_player_btn;
    private ImageView welcomeView, hangManTheGame;
    
    private final GameLogic logic = GameLogic.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_game);

        //Instantiate.
        One_player_btn = (Button) findViewById(R.id.One_player_btn);
        Two_player_btn = (Button) findViewById(R.id.Two_player_btn);
        welcomeView = (ImageView) findViewById(R.id.welcomeView);
        hangManTheGame = (ImageView) findViewById(R.id.hangManTheGame);

        //I/O listeners.
        One_player_btn.setOnClickListener(this);
        Two_player_btn.setOnClickListener(this);
        welcomeView.setOnClickListener(this);
        hangManTheGame.setOnClickListener(this);

        // Downloads list of words from internet.
        new wordFromURL().execute();
        }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.One_player_btn:
                if (view instanceof Button) {
                    ((Button) view).setBackgroundColor(R.drawable.btn_color_shp_pressed);
                }
                Intent initGame = new Intent(this, GameActivity.class);
                startActivity(initGame);
                System.out.println("Trying to start GameActivity.");
                // Resets the logic layer.
                logic.reset();
                break;
            case R.id.Two_player_btn: // Denne skal gå til en liste over ord
                if (view instanceof Button) {
                    ((Button) view).setBackgroundColor(R.drawable.btn_color_shp_pressed);
                }
                Intent initChooseWordActivity = new Intent(this, ChooseWordActivity.class);
                startActivity(initChooseWordActivity);
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
