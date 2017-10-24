package com.example.tmasc.hangmanthegame_1.main;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.tmasc.hangmanthegame_1.R;

public class WonGameActivity extends AppCompatActivity {


    private ImageView hangManTheGame;
    private TextView wonTheGame;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_won_game);

        hangManTheGame = (ImageView) findViewById(R.id.hangManTheGame);
        wonTheGame = (TextView) findViewById(R.id.wonTheGame);

    }
}
