package com.testapp.drawtest;

import android.graphics.Color;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.SurfaceView;
import android.view.View;
import android.widget.TextView;

public class TestActivity extends AppCompatActivity implements View.OnTouchListener {

    private TextView textView;
    private int fieldSize = 9;
    private GameSurfaceView gameSurfaceView = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        textView = findViewById(R.id.textView);
        gameSurfaceView = findViewById(R.id.gameView);
        gameSurfaceView.setOnTouchListener(this);
        gameSurfaceView.setFieldSize(fieldSize);
        gameSurfaceView.setFieldColor(Color.argb(255,100,100,200));
        gameSurfaceView.setGridStroke(5);

    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        if(v instanceof SurfaceView){
            float x = event.getX();
            float y = event.getY();
            int []coord = gameSurfaceView.getCellXY(x,y);
            textView.setText(String.valueOf(coord[1])+":"+String.valueOf(coord[0]));
            gameSurfaceView.drawOrigin();
            gameSurfaceView.setCell(coord[0],coord[1], GameSurfaceView.CellType.CIRCLE,Color.GREEN,80);
        }
        return false;
    }
}
