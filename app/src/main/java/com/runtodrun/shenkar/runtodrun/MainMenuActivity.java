package com.runtodrun.shenkar.runtodrun;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class MainMenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        //Hide Navigation Bar
        View overlay = findViewById(R.id.main_menu_layout);
        overlay.setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                | View.SYSTEM_UI_FLAG_FULLSCREEN);

        ImageView spaceshipImage = (ImageView) findViewById(R.id.imageView);
        Animation hyperspaceJumpAnimation = AnimationUtils.loadAnimation(this, R.anim.background_motion);
        spaceshipImage.startAnimation(hyperspaceJumpAnimation);

    }
}
