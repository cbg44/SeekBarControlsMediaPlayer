package com.runtodrun.shenkar.runtodrun;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;


public class start_game extends AppCompatActivity{
    private StartGame startGame;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        startGame = new StartGame(this);
        setContentView(startGame);
    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {

        switch (event.getAction()){
            case MotionEvent.ACTION_UP:
                handleClickEvent(event);
                break;
            default:
                break;
        }
        return super.onTouchEvent(event);
    }

    private void handleClickEvent(MotionEvent event) {
        if(startGame.menuScreen){
            startGame.menuScreen = false;
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        startGame.pause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        startGame.resume();
    }
}
