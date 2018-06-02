package com.runtodrun.shenkar.runtodrun;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;

public class Settings extends AppCompatActivity {

    private SeekBar volumeBar;
    public MediaPlayer backgroundSound;
    Button playBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        backgroundSound = MediaPlayer.create(this, R.raw.scarymusic);
        backgroundSound.setLooping(true);
        backgroundSound.setVolume(0.5f, 0.5f);
        backgroundSound.seekTo(0);
        backgroundSound.start();

        playBtn = findViewById(R.id.playmusic);
        volumeBar = findViewById(R.id.volumeBar);

        volumeBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                float volumeNum = progress / 100f;
                backgroundSound.setVolume(volumeNum, volumeNum);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    public void clickPlayMusic(View view){
        if(!backgroundSound.isPlaying()){
            //stop
            backgroundSound.start();
            playBtn.setBackgroundResource(R.drawable.pause);
        } else{
            //play
            backgroundSound.pause();
            playBtn.setBackgroundResource(R.drawable.playmusic);
        }
    }
}
