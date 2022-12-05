package com.example.android.miwok;

import android.content.Context;
import android.media.MediaPlayer;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;

import java.util.List;

public class wordadapter extends ArrayAdapter <Words> {

    private int colorresid;
    public wordadapter(@NonNull Context context, @NonNull List<Words> objects, int inputcolorresid) {
        super(context, 0, objects);
        colorresid = inputcolorresid;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
//        return super.getView(position, convertView, parent);
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        Words currentword = getItem(position);

        TextView name1TextView = (TextView) listItemView.findViewById(R.id.english);
        name1TextView.setText(currentword.getengtranslation());

        TextView name2TextView = (TextView) listItemView.findViewById(R.id.marathi);
        name2TextView.setText(currentword.getMarathitranslation());
        ImageView imview = (ImageView) listItemView.findViewById(R.id.listiconimages);

        if(currentword.hasimage()) {
            imview.setImageResource(currentword.getImage());
        }
        else{
            imview.setVisibility(View.GONE);
        }


        View Textcontainor = listItemView.findViewById(R.id.text_container);
        int color = ContextCompat.getColor(getContext(),colorresid);
        Textcontainor.setBackgroundColor(color);

        return listItemView;
    }
}
