package com.runtodrun.shenkar.runtodrun;
import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;


public class Settings extends AppCompatActivity {
    public MediaPlayer mediaPlayer;
    public Button start;
    public Button pause;
    public Button back;
    public SeekBar volume;
    public ImageView muteIcon;
    public ImageView playIcon;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        start= findViewById(R.id.button_start);
        pause = findViewById(R.id.button_pause);
        start.setVisibility(View.INVISIBLE);
        back = findViewById(R.id.button_back);
        muteIcon = findViewById(R.id.muteIcon);
        playIcon = findViewById(R.id.playIcon);
        volume = findViewById(R.id.sound);
        mediaPlayer = mediaPlayer.create(this, R.raw.scarymusic);
        mediaPlayer.setLooping(true);
        mediaPlayer.setVolume(0.5f, 0.5f);
        mediaPlayer.seekTo(0);
        mediaPlayer.start();
        final AudioManager audioManager = (AudioManager)getSystemService(Context.AUDIO_SERVICE);
        volume.setMax(audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC));
        volume.setProgress(audioManager.getStreamVolume(AudioManager.STREAM_MUSIC));

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        try {
            volume.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener()
            {
                @Override
                public void onStopTrackingTouch(SeekBar arg0)
                {
                }

                @Override
                public void onStartTrackingTouch(SeekBar arg0)
                {
                    //   mediaPlayer.setVolume(1,1);
                }

                @Override
                public void onProgressChanged(SeekBar arg0, int progress, boolean arg2)
                {
                    audioManager.setStreamVolume(AudioManager.STREAM_MUSIC, progress, 0);
                    if (progress == 0){

                            muteIcon.setVisibility(View.VISIBLE);
                            playIcon.setVisibility(View.INVISIBLE);

                    }else{
                        playIcon.setVisibility(View.VISIBLE);
                        muteIcon.setVisibility(View.INVISIBLE);
                    }

                }
            });
        }
        catch (Exception e) {e.printStackTrace();}


    }


    public void PlayMusic(View view){
        if(!mediaPlayer.isPlaying()) {
            mediaPlayer.start();
            start.setVisibility(View.INVISIBLE);
            pause.setVisibility(View.VISIBLE);
            playIcon.setVisibility(View.VISIBLE);
            muteIcon.setVisibility(View.INVISIBLE);
        }
    }


    public void PauseMusic(View view){
        if(mediaPlayer.isPlaying()) {
            mediaPlayer.pause();
            pause.setVisibility(View.INVISIBLE);
            start.setVisibility(View.VISIBLE);
            muteIcon.setVisibility(View.VISIBLE);
            playIcon.setVisibility(View.INVISIBLE);
        }
    }

}





