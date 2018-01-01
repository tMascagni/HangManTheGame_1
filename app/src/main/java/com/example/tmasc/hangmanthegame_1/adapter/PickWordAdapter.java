package com.example.tmasc.hangmanthegame_1.adapter;

import android.content.Context;
import android.widget.ArrayAdapter;

import com.example.tmasc.hangmanthegame_1.data.DTO.HighscoreDTO;
import com.example.tmasc.hangmanthegame_1.gameLogic.GameLogic;

import java.util.List;

/**
 * Created by tmasc on 01-01-2018.
 */

public class PickWordAdapter extends ArrayAdapter<PickWordAdapter>{

    private final GameLogic logic = GameLogic.getInstance();

    List<HighscoreDTO> items;

    public PickWordAdapter(Context context, int resource, List<PickWordAdapter> items) {
        super(context, resource, items);
       // this.items = items;
    }




}
