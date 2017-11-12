package com.example.tmasc.hangmanthegame_1.data.DAO;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.tmasc.hangmanthegame_1.data.DTO.HighscoreDTO;
import com.example.tmasc.hangmanthegame_1.data.exception.DataException;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class HighscoreDAO implements IHighscoreDAO{

    private static HighscoreDAO DAOinstance = new HighscoreDAO();

    private final String mem_key = "highscore";

    private List<HighscoreDTO> highScoreList = new ArrayList<>();

    private HighscoreDAO() {
    }

    @Override
    public HighscoreDTO getByID(int id) throws DataException {
        return null;
    }

    @Override
    public List<HighscoreDTO> getList() throws DataException {
        return highScoreList;
    }

    @Override
    public void load(Context context) throws DataException {
        SharedPreferences preferences = context.getSharedPreferences("Preferences", Context.MODE_PRIVATE);

        String json = preferences.getString(mem_key, null);

        Gson gson = new Gson();
        Type type = new TypeToken<ArrayList<HighscoreDTO>>() {
        }.getType();

        highScoreList =  (ArrayList<HighscoreDTO>) gson.fromJson(json, type);

        if (highScoreList == null) {
            highScoreList = new ArrayList<>();
            save(context);
        }
    }


    @Override
    public void add(HighscoreDTO dto) throws DataException {
        highScoreList.add(dto);
        Collections.sort(highScoreList);
    }

    @Override
    public void save(Context context) throws DataException {

        Gson gson = new Gson();

        SharedPreferences preferences = context.getSharedPreferences("Preferences", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();

        String json = gson.toJson(highScoreList);

        editor.putString(mem_key, json);

        editor.apply();
    }

    public static HighscoreDAO getInstance() {
        return DAOinstance;
    }
}

