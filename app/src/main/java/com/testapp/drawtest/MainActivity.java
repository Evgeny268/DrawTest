package com.testapp.drawtest;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    DrawView drawView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        drawView = findViewById(R.id.drawView);
        setContentView(R.layout.activity_main);
        //drawView.invalidate();
        //setContentView(new DrawView(this));
    }

//    class DrawView extends View {
//
//        public DrawView(Context context) {
//            super(context);
//        }
//
//        @Override
//        protected void onDraw(Canvas canvas) {
//            canvas.drawColor(Color.GREEN);
//        }
//    }
}
