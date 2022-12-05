package com.example.android.miwok;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;

public class ColorsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numbers);

        ArrayList <Words> word = new ArrayList<>();

        word.add(new Words("Red", "लाल",R.drawable.color_red));
        word.add(new Words("Yellow", "पिवळा",R.drawable.color_mustard_yellow));
        word.add(new Words("Green","हिरवा",R.drawable.color_green));
        word.add(new Words("Brown", "तपकिरी",R.drawable.color_brown));
        word.add(new Words("Gray", "राखाडी",R.drawable.color_gray));
        word.add(new Words("Black", "काळा",R.drawable.color_black));
        word.add(new Words("White", "पांढरा",R.drawable.color_white));

        wordadapter adapter = new wordadapter(this, word, R.color.category_colors);
        ListView listview = (ListView) findViewById(R.id.list);
        listview.setAdapter(adapter);


    }
}