package com.zhaojian.maple.test;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import java.util.Random;

/**
 * Created by zhaojian26 on 16/1/12.
 */
public class customView extends View {
    String count;

    public customView(Context context) {
        super(context);
    }

    public customView(Context context, AttributeSet attrs){
        super(context,attrs);
        count = getRadom();
    }

    public customView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        count = getRadom();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                count = getRadom();
                invalidate();
        }
        return super.onTouchEvent(event);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint paint = new Paint();
        paint.setColor(Color.RED);
        paint.setTextSize(50);
        canvas.drawText(count,10,100,paint);
    }

    private String getRadom() {
        String temp = "";
        Random random = new Random();
        for(int i = 0; i<4; i++){
            temp =temp + random.nextInt(10)+"";
        }
        return temp;
    }
}
