package com.example.tmasc.hangmanthegame_1.data.DAO;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.Preference;

import com.example.tmasc.hangmanthegame_1.data.DTO.HighscoreDTO;
import com.example.tmasc.hangmanthegame_1.data.exception.DataException;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class HighscoreDAO implements IHighscoreDAO{

    private static HighscoreDAO DAOsingleton = new HighscoreDAO();

    private final String mem_key = "highscore";

    private List<HighscoreDTO> highScoreList;

    private HighscoreDAO() {
    }

    @Override
    public HighscoreDTO getByID(int id) throws DataException {
        return null;
    }

    @Override
    public List<HighscoreDTO> getList() throws DataException {
        return null;
    }

    @Override
    public List<HighscoreDTO> load(Context context) throws DataException {
        SharedPreferences preferences = context.getSharedPreferences("Preferences", Context.MODE_PRIVATE);

        String json = preferences.getString(mem_key, null);

        Gson gson = new Gson();
        Type type = new TypeToken<ArrayList<HighscoreDTO>>() {
        }.getType();


        return gson.fromJson(json, type);
    }

    @Override
    public void add(HighscoreDTO dto) throws DataException {
        highScoreList.add(dto);
    }

    @Override
    public void save(Context context, HighscoreDTO dto) throws DataException {

        Gson gson = new Gson();
        List<HighscoreDTO> list = load(context);

        if (list == null) {
            list = new ArrayList<HighscoreDTO>();
        }

        SharedPreferences preferences = context.getSharedPreferences("Preferences", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();

        String json = gson.toJson(list);

        SharedPreferences.Editor editor1 = editor.putString(mem_key, json);

        editor.commit();
    }

    @Override
    public void addList(List<HighscoreDTO> dtoList) throws DataException {

    }

    @Override
    public void setHighscore(HighscoreDTO dto) throws DataException {

    }

    public static HighscoreDAO getInstance() {
        return DAOsingleton;
    }
}

