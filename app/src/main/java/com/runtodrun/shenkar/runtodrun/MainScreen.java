package com.runtodrun.shenkar.runtodrun;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class MainScreen extends AppCompatActivity {

    private MediaPlayer backgroundSound;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);
        backgroundSound = MediaPlayer.create(this, R.raw.scarymusic);
        backgroundSound.setLooping(true);
        backgroundSound.start();

    }

    public void clickSetting(android.view.View view){
        backgroundSound.pause();
        startActivity(new Intent(this, Settings.class));
    }

    public void clickPlay(android.view.View view){
        backgroundSound.pause();
        startActivity(new Intent(this,start_game.class));
    }

}
