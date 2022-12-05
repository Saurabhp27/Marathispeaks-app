package com.example.android.miwok;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class NumbersActivity extends AppCompatActivity {
    MediaPlayer player;
    AudioManager audiomanager;


    private AudioManager.OnAudioFocusChangeListener monaudiiofocuschangelistener = new AudioManager.OnAudioFocusChangeListener() {
        @Override
        public void onAudioFocusChange(int i) {
            if (i == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT ||
                    i == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK) {
                // The AUDIOFOCUS_LOSS_TRANSIENT case means that we've lost audio focus for a
                // short amount of time. The AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK case means that
                // our app is allowed to continue playing sound but at a lower volume. We'll treat
                // both cases the same way because our app is playing short sound files.

                // Pause playback and reset player to the start of the file. That way, we can
                // play the word from the beginning when we resume playback.
                player.pause();
                player.seekTo(0);
            } else if (i == AudioManager.AUDIOFOCUS_GAIN) {
                // The AUDIOFOCUS_GAIN case means we have regained focus and can resume playback.
                player.start();
            } else if (i == AudioManager.AUDIOFOCUS_LOSS) {
                // The AUDIOFOCUS_LOSS case means we've lost audio focus and
                // Stop playback and clean up resources
                releaseMediaPlayer();
            }
        }
    };







    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numbers);

         audiomanager = (AudioManager) getSystemService(AUDIO_SERVICE);
//        AudioManager audioManager = (AudioManager) NumbersActivity.this.getSystemService(AUDIO_SERVICE);
        ArrayList <Words> word = new ArrayList< Words >();

        word.add(new Words("One ", "एक", R.drawable.number_one,R.raw.one));
        word.add(new Words("two", "दोन",R.drawable.number_two,R.raw.two));
        word.add(new Words("Three","तीन",R.drawable.number_three,R.raw.three));
        word.add(new Words("Four","चार",R.drawable.number_four,R.raw.four));
        word.add(new Words("Five ", "पाच",R.drawable.number_five,R.raw.five));
        word.add(new Words("Six", "सहा",R.drawable.number_six,R.raw.six));
        word.add(new Words("Seven", "सात",R.drawable.number_seven,R.raw.seven));
        word.add(new Words("Eight", "आठ",R.drawable.number_eight,R.raw.eight));
        word.add(new Words("Nine ", "नऊ",R.drawable.number_nine,R.raw.nine));
        word.add(new Words("Ten ", "दहा",R.drawable.number_ten,R.raw.ten));


     /*   LinearLayout rootview = (LinearLayout) findViewById(R.id.rootView);

        int index = 0;
        while (index< words.size()){
            TextView wordview = new TextView(this);
            wordview.setText(words.get(index));
            rootview.addView(wordview);
            index++;
        }
     */
        // using listview + adapter instead of above linearlayot

//        ArrayAdapter <String> itemsAdapter = new ArrayAdapter<String>(this,R.layout.list_item, words);

        wordadapter adapter = new wordadapter(this, word,R.color.category_numbers);
        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(adapter);






        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                releaseMediaPlayer();
                Words pos = word.get(i);
                int result = audiomanager.requestAudioFocus(monaudiiofocuschangelistener,AudioManager.STREAM_MUSIC,AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);
if (result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {
    player = MediaPlayer.create(NumbersActivity.this, pos.getaudio());

    player.start();


    player.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mediaPlayer) {
            releaseMediaPlayer();
        }
    });
}
            }
        });



    }

    @Override
    protected void onStop() {
        super.onStop();
        releaseMediaPlayer();
    }

    private void releaseMediaPlayer() {
        // If the media player is not null, then it may be currently playing a sound.
        if (player != null) {

            // Regardless of the current state of the media player, release its resources
            // because we no longer need it.
            player.release();

            // Set the media player back to null. For our code, we've decided that
            // setting the media player to null is an easy way to tell that the media player
            // is not configured to play an audio file at the moment.
            player = null;

            audiomanager.abandonAudioFocus(monaudiiofocuschangelistener);


        }
    }



}