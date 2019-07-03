package com.testapp.drawtest;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;


public class DrawView extends View {

    private TextPaint mTextPaint;
    private float mTextWidth;
    private float mTextHeight;

    public DrawView(Context context) {
        super(context);
        init(null,0);
    }

    @Override
    public void invalidate() {
        super.invalidate();
    }



    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawColor(Color.CYAN);
        float startX;
        float stopX;
        float startY;
        float stopY;

        int width = canvas.getWidth();
        int height = canvas.getHeight();

        int gridSize = 7;
        int gridSpacing = Math.min(width, height) / gridSize;
        int boardSize = gridSize * gridSpacing;

        int xOffset = (width - boardSize)/2;
        int yOffset = (height - boardSize)/2;

        //Vertical Grid-lines
        for (int i = 0; i < gridSize; i++) {

            startX = xOffset + i*gridSpacing;
            startY = yOffset;

            stopX = startX;
            stopY = startY + boardSize;

            canvas.drawLine(startX, startY, stopX, stopY, new Paint());

        }

        //Horizontal Grid-lines
        for (int i = 0; i < gridSize; i++) {

            startX = xOffset;
            startY = yOffset + i*gridSpacing;

            stopX = startX + boardSize;
            stopY = startY;

            canvas.drawLine(startX, startY, stopX, stopY, new Paint());
        }
    }

    public DrawView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs,0);
    }

    public DrawView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs, defStyleAttr);
    }

    private void init(AttributeSet attrs, int defStyle){

    }

}
