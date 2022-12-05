package com.example.android.miwok;

import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.widget.ImageView;

public class Words {
    String englishtranslation;
    String marathitranslation;
    int image=noimg;
    int audios;

    public static final int noimg = -1;

    public Words(String menglishtranslation, String mmarathitranslation){
        englishtranslation = menglishtranslation ;
        marathitranslation = mmarathitranslation ;
    }
    public Words (String menglishtranslation, String mmarathitranslation, int im){
         englishtranslation = menglishtranslation ;
         marathitranslation = mmarathitranslation ;
         image = im;
    }
    public Words (String menglishtranslation, String mmarathitranslation, int im,int audio){
        englishtranslation = menglishtranslation ;
        marathitranslation = mmarathitranslation ;
        image = im;
        audios = audio;
    }

public boolean hasimage(){
    return image != noimg;
}

    public String getengtranslation (){
        return englishtranslation;

    }

    public int getImage(){
        return  image;
    }

    public String getMarathitranslation (){
        return marathitranslation;

    }


    public int getaudio(){
        return audios;
    }

}
