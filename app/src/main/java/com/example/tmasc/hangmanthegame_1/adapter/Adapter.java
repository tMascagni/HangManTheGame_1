package com.example.tmasc.hangmanthegame_1.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.tmasc.hangmanthegame_1.R;
import com.example.tmasc.hangmanthegame_1.data.DTO.HighscoreDTO;

import java.util.List;

public class Adapter extends ArrayAdapter<HighscoreDTO> {

    private String name;
    private int score;
    private Context mContext;

    private class ViewHolder {
        public TextView score = null;
        public TextView name = null;
    }

    private List<HighscoreDTO> dtoList;

    public Adapter(@NonNull Context context, int resource, List<HighscoreDTO> dtoList) {
        super(context, resource);
        this.dtoList = dtoList;
    }

    private int lastPos = -1;

    @NonNull
    @Override
    public View getView(int position, @NonNull View convertView, @NonNull ViewGroup parrent) {
        View mConvertView = convertView;

        View view;
        ViewHolder viewHolder = null;

        HighscoreDTO dto = dtoList.get(position);

        if (mConvertView == null) {
            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(mContext);
            mConvertView = inflater.inflate(R.layout.highscorelistitem, parrent, false);
            viewHolder.name = mConvertView.findViewById(R.id.name);
            viewHolder.score = mConvertView.findViewById(R.id.score);

            view = mConvertView;
            mConvertView.setTag(viewHolder);
        }

        else {
            viewHolder = (ViewHolder) mConvertView.getTag();
            view = mConvertView;
        }

        lastPos = position;

        viewHolder.score.setText(dto.getScore());
        viewHolder.name.setText(dto.getName());

        return super.getView(position,convertView, parrent);

    }
}
