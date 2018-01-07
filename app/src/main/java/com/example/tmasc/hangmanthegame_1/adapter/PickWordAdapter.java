package com.example.tmasc.hangmanthegame_1.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import com.example.tmasc.hangmanthegame_1.R;
import com.example.tmasc.hangmanthegame_1.gameLogic.GameLogic;
import java.util.List;


public class PickWordAdapter extends ArrayAdapter<String> {

    private final GameLogic logic = GameLogic.getInstance();

    List<String> list;

    public PickWordAdapter(Context context, int resource, List<String> list) {
        super(context, resource, list);
        this.list = list;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        String theWord = list.get(position);

        View v = convertView;

        if (v == null) {
            LayoutInflater vi;
            vi = LayoutInflater.from(getContext());
            v = vi.inflate(R.layout.choosewordlistitem, null);
        }

        TextView word = (TextView) v.findViewById(R.id.word);
        word.setText(theWord);

        return v;
    }

}
