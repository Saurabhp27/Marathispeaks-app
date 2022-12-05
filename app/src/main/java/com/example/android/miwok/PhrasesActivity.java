package com.example.android.miwok;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class PhrasesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numbers);

        ArrayList<Words> word = new ArrayList< Words >();

        word.add(new Words("Where are you going?", "तू कुठे जात आहेस"));
        word.add(new Words("What is your name?", "तुमचे नाव काय ?"));
        word.add(new Words("My name is...", "माझे नाव आहे..."));
        word.add(new Words("How are you feeling?", "तुला कसे वाटत आहे?"));
        word.add(new Words("I’m feeling good.", "मला बरं वाटतेय."));
        word.add(new Words("Are you coming?", "तू येत आहेस का?"));
        word.add(new Words("Yes, I’m coming.", "होय, मी येत आहे."));
        word.add(new Words("I’m coming.", "मी येत आहे."));
        word.add(new Words("Let’s go.", "चल जाऊया."));
        word.add(new Words("Come here.", "इकडे ये."));


        wordadapter adapter = new wordadapter(this, word, R.color.category_phrases);
        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(adapter);





    }
}