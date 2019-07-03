package com.testapp.drawtest;

import android.graphics.Canvas;
import android.view.SurfaceHolder;

public class MainThread extends Thread {
    public  static final int MAX_FPS = 30;
    private  double averageFPS;
    private SurfaceHolder surfaceHolder;
    private DrawView  DrawView;
    private  boolean running;
    public static Canvas canvas;

    public  void setRunning (boolean Running)
    {
        this.running = Running;
    }

    public MainThread (SurfaceHolder surfaceHolder, DrawView DrawView) {
        super();
        this.surfaceHolder = surfaceHolder;
        this.DrawView = DrawView;

    }

    @Override
    public void run() {
        long startTime;
        long timeMillis = 1000/MAX_FPS;
        long waitTime;
        int frameCount = 0;
        int totalTime = 0;
        int targetTime = 1000/MAX_FPS;

        while (running)
        {
            startTime = System.nanoTime();
            canvas = null;

            try
            {
                canvas = this.surfaceHolder.lockCanvas();
                synchronized (surfaceHolder)
                {
                    this.DrawView.update();;
                    this.DrawView.draw(canvas);
                }
            }catch(Exception e)
                {
                e.printStackTrace();
                }finally
                {
                if (canvas != null)
                    {
                    try
                        {
                          surfaceHolder.unlockCanvasAndPost(canvas);
                        } catch (Exception e) {e.printStackTrace();}
                    }
                 }
            timeMillis = (System.nanoTime() - startTime)/1000000;
            waitTime =  targetTime - timeMillis;
            try{
                if (waitTime >0 ) this.sleep(waitTime);
            } catch (Exception e) {e.printStackTrace();}

            totalTime += System.nanoTime() - startTime;
            frameCount ++;
            if(frameCount == MAX_FPS) {
                averageFPS = 1000/((totalTime/frameCount)/100000);
                frameCount = 0;
                totalTime = 0;
                System.out.println(averageFPS);

            }


        }
    }
}
