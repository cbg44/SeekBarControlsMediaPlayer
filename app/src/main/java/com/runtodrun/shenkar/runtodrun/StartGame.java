package com.runtodrun.shenkar.runtodrun;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class StartGame extends SurfaceView implements Runnable{
    public boolean menuScreen = true;
    private boolean canPlay = false;
    private Thread mPlayThread = null;
    private Canvas canvas;
    private SurfaceHolder surfaceHolder;
    private Bitmap background;

    public StartGame(Context context) {
        super(context);
        surfaceHolder = getHolder();
        background = BitmapFactory.decodeResource(getResources(), R.drawable.strip_background);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void run() {
        while(canPlay) {
            if(!surfaceHolder.getSurface().isValid()){
                continue;
            }
            canvas = surfaceHolder.lockCanvas();
            canvas.drawBitmap(background,0,0,null);
            if(menuScreen){
            }
            else {
            }
            surfaceHolder.unlockCanvasAndPost(canvas);
        }
    }

    public void pause(){
        canPlay = false;
        while (true) {
            try {
                mPlayThread.join();
                break;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        mPlayThread = null;
    }

    public void resume() {
        canPlay = true;
        mPlayThread = new Thread(this);
        mPlayThread.start();

    }
}
