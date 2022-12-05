package com.example.android.miwok;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class FamilyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numbers);

        ArrayList<Words> word = new ArrayList< Words >();

        word.add(new Words("Father", "बाबा",R.drawable.family_father));
        word.add(new Words("Mother", "आई",R.drawable.family_mother));
        word.add(new Words("Brother","भाऊ",R.drawable.family_older_brother));
        word.add(new Words("Sister","बहिण",R.drawable.family_older_sister));
        word.add(new Words("Grandfather", "आजोबा",R.drawable.family_grandfather));
        word.add(new Words("Grandmother", "आजी",R.drawable.family_grandmother));
        word.add(new Words("Uncle", "काका",R.drawable.family_father));
        word.add(new Words("Aunt", "काकू",R.drawable.family_mother));


        wordadapter adapter = new wordadapter(this, word, R.color.category_family);
        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(adapter);


    }
}