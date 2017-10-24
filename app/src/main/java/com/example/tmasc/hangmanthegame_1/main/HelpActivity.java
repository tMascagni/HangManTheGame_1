package com.example.tmasc.hangmanthegame_1.main;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.tmasc.hangmanthegame_1.R;

public class HelpActivity extends AppCompatActivity {

    private ImageView hangManTheGame;
    private TextView helpText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);

        hangManTheGame = (ImageView) findViewById(R.id.hangManTheGame);
        helpText = (TextView) findViewById(R.id.helpText);
    }
}
