package com.example.tmasc.hangmanthegame_1.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.tmasc.hangmanthegame_1.R;
import com.example.tmasc.hangmanthegame_1.data.DTO.HighscoreDTO;
import com.example.tmasc.hangmanthegame_1.gameLogic.GameLogic;

import java.util.List;

public class ListAdapter extends ArrayAdapter<HighscoreDTO> {

    private final GameLogic logic = GameLogic.getInstance();

    List<HighscoreDTO> items;

    public ListAdapter(Context context, int resource, List<HighscoreDTO> items) {
        super(context, resource, items);
        this.items = items;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View v = convertView;

        if (v == null) {
            LayoutInflater vi;
            vi = LayoutInflater.from(getContext());
            v = vi.inflate(R.layout.highscorelistitem, null);
        }

        HighscoreDTO p = items.get(position);

        if (p != null) {
            TextView score = (TextView) v.findViewById(R.id.score);
            TextView name = (TextView) v.findViewById(R.id.name);

            if (score != null) {
                score.setText(String.valueOf(p.getScore()));
            }

            if (name != null) {
                name.setText(p.getName());
            }
        }

        return v;
    }

}
