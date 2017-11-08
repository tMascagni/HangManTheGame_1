package com.example.tmasc.hangmanthegame_1.main;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.tmasc.hangmanthegame_1.R;

public class HighscoreCreateScoreActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView hangManTheGame, gallow;
    private TextView typeName;
    private EditText name;

    private final int btnAmount = 26;

    private final Button[] btnArray = new Button[btnAmount];
    private final Integer[] btnIdArray = {
            R.id.a_btn, R.id.b_btn, R.id.c_btn, R.id.d_btn,
            R.id.e_btn, R.id.f_btn, R.id.g_btn, R.id.h_btn,
            R.id.i_btn, R.id.j_btn, R.id.k_btn, R.id.l_btn,
            R.id.m_btn, R.id.n_btn, R.id.o_btn, R.id.p_btn,
            R.id.q_btn, R.id.r_btn, R.id.s_btn, R.id.t_btn,
            R.id.u_btn, R.id.v_btn, R.id.w_btn, R.id.x_btn,
            R.id.y_btn, R.id.z_btn, R.id.okBtn, R.id.backSpace};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_highscore_create_score);

        // Instantiate.
        hangManTheGame = (ImageView) findViewById(R.id.hangManTheGame);
        gallow = (ImageView) findViewById(R.id.gallow);
        typeName = (TextView) findViewById(R.id.typeName);
        name = (EditText) findViewById(R.id.name);

        // for-loop to create all the buttons.
        for (int i = 0; i < btnArray.length; i++) {
            btnArray[i] = (Button) findViewById(btnIdArray[i]);
            btnArray[i].setOnClickListener(this);
        }
    }

    @Override
    public void onClick(View view) {
        if (view instanceof Button) {
            String guess = ((Button) view).getText().toString();
            name.append(guess);
            ((Button) view).setTextColor(Color.BLACK);
            ((Button) view).setBackgroundColor(Color.DKGRAY);
            view.setEnabled(false);
        }

    }
}
