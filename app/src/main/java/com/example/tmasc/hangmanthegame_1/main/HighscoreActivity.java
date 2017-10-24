package com.example.tmasc.hangmanthegame_1.main;

import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.tmasc.hangmanthegame_1.R;

public class HighscoreActivity extends AppCompatActivity {

    private ImageView hangManTheGame;
    private TextView highScore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_highscore);

        hangManTheGame = (ImageView) findViewById(R.id.hangManTheGame);
        highScore = (TextView) findViewById(R.id.highScore);

    }
}
