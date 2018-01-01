package com.example.tmasc.hangmanthegame_1.main;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.example.tmasc.hangmanthegame_1.R;
import com.example.tmasc.hangmanthegame_1.asyncTask.wordFromURL;
import com.example.tmasc.hangmanthegame_1.gameLogic.GameLogic;

import org.w3c.dom.Text;

public class SettingsActivity extends AppCompatActivity implements View.OnClickListener {

    private ToggleButton onlineConnection_btn;
    private ImageView welcomeView, hangManTheGame;
    private TextView online_txt;

    private final GameLogic logic = GameLogic.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        //Instantiate.
        onlineConnection_btn = (ToggleButton) findViewById(R.id.onlineConnection_Btn);
        welcomeView = (ImageView) findViewById(R.id.welcomeView);
        hangManTheGame = (ImageView) findViewById(R.id.hangManTheGame);
        online_txt = (TextView) findViewById(R.id.online_txt);

        //I/O listeners.
        onlineConnection_btn.setOnClickListener(this);
        welcomeView.setOnClickListener(this);
        hangManTheGame.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        onlineConnection_btn.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    logic.setOnline(true);
                    Toast.makeText(getBaseContext(), "Logic - setOnline = TRUE", Toast.LENGTH_SHORT).show();
                }
                else {
                    logic.setOnline(false);
                    Toast.makeText(getBaseContext(), "Logic - setOnline = FALSE", Toast.LENGTH_SHORT).show();
                } // Offline - sæt gamelogic til at bruge offline spil.
            }
        });
    }
}