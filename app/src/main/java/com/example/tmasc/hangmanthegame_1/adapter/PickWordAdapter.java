package com.example.tmasc.hangmanthegame_1.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.tmasc.hangmanthegame_1.R;
import com.example.tmasc.hangmanthegame_1.data.DTO.HighscoreDTO;
import com.example.tmasc.hangmanthegame_1.gameLogic.GameLogic;

import org.w3c.dom.Text;

import java.util.List;

import static android.media.CamcorderProfile.get;

public class PickWordAdapter extends ArrayAdapter<String> {

    private final GameLogic logic = GameLogic.getInstance();

    List<String> list;

    public PickWordAdapter(Context context, int resource, List<String> list) {
        super(context, resource, list);
        this.list = list;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View v = convertView;

        if (v == null) {
            LayoutInflater vi;
            vi = LayoutInflater.from(getContext());
            v = vi.inflate(R.layout.choosewordlistitem, null);
        }

        List<String> p = logic.getPossibleWords();

        if (p != null) {
            TextView word = (TextView) v.findViewById(R.id.word);

          //  if (word != null) {
          //      word.setText(String.valueOf(p));
          //  }
        }

        return v;
    }

}
