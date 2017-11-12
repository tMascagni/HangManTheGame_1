package com.example.tmasc.hangmanthegame_1.data.DAO;

import android.content.Context;
import android.provider.ContactsContract;

import com.example.tmasc.hangmanthegame_1.data.DTO.HighscoreDTO;
import com.example.tmasc.hangmanthegame_1.data.exception.DataException;

import java.util.List;

public interface IHighscoreDAO {

    public HighscoreDTO getByID(int id) throws DataException;

    public List<HighscoreDTO> getList() throws DataException;

    public void save (Context context) throws DataException;

    public void load(Context context) throws DataException;

    public void add(HighscoreDTO dto) throws DataException;


}
