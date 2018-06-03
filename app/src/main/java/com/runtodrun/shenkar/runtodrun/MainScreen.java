package com.runtodrun.shenkar.runtodrun;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class MainScreen extends AppCompatActivity {
    public static final String ACTION_PLAY = "PLAY";

    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);
        mediaPlayer = MediaPlayer.create(this, R.raw.scarymusic);
        mediaPlayer.setLooping(true);
        mediaPlayer.start();
    }

    public void clickSetting(android.view.View view){
        mediaPlayer.pause();
        Intent intent = new Intent(this, Settings.class);
        startActivity(intent);
    }

    public void clickPlay(android.view.View view){
        mediaPlayer.pause();
        Intent intent = new Intent(this, StartGameActivity.class);
        startActivity(intent);
    }

}
