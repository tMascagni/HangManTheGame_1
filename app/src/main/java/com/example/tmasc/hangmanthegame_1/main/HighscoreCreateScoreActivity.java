package com.example.tmasc.hangmanthegame_1.main;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tmasc.hangmanthegame_1.R;
import com.example.tmasc.hangmanthegame_1.data.DAO.HighscoreDAO;
import com.example.tmasc.hangmanthegame_1.data.DTO.HighscoreDTO;
import com.example.tmasc.hangmanthegame_1.data.exception.DataException;
import com.example.tmasc.hangmanthegame_1.gameLogic.GameLogic;

public class HighscoreCreateScoreActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView hangManTheGame, gallow;
    private TextView typeName;
    private EditText name;

    private final GameLogic logic = GameLogic.getInstance();
    private final HighscoreDAO daoInstans = HighscoreDAO.getInstance();

    private final int btnAmount = 27;

    private final Button[] btnArray = new Button[btnAmount];
    private final Integer[] btnIdArray = {
            R.id.a_btn, R.id.b_btn, R.id.c_btn, R.id.d_btn,
            R.id.e_btn, R.id.f_btn, R.id.g_btn, R.id.h_btn,
            R.id.i_btn, R.id.j_btn, R.id.k_btn, R.id.l_btn,
            R.id.m_btn, R.id.n_btn, R.id.o_btn, R.id.p_btn,
            R.id.q_btn, R.id.r_btn, R.id.s_btn, R.id.t_btn,
            R.id.u_btn, R.id.v_btn, R.id.w_btn, R.id.x_btn,
            R.id.y_btn, R.id.z_btn, R.id.okBtn
    };


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

        // Disable keyboard.
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.okBtn:
                Toast.makeText(getBaseContext(), "Ok pressed", Toast.LENGTH_SHORT).show();
                logic.setName(name.getText().toString());
                HighscoreDTO dto = new HighscoreDTO(logic.getScore(), logic.getName());
                try {
                    daoInstans.add(dto);
                    daoInstans.save(getBaseContext(), dto);
                } catch (DataException e) {
                    e.printStackTrace();
                }
                break;

            default:
                String guess = ((Button) view).getText().toString();
                ((Button) view).setTextColor(Color.BLACK);
                ((Button) view).setBackgroundColor(Color.DKGRAY);
                name.append(guess);
                view.setEnabled(false);
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
