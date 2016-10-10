package com.cqz.dragviewtestdemo;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by chenqz on 2016/10/9.
 */
public class DragView3 extends View {
    private int mLastX;
    private int mLastY;
    public DragView3(Context context) {
        this(context,null);
    }

    public DragView3(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView();
    }

    private void initView() {
        setBackgroundColor(Color.BLUE);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int x= (int) event.getX();
        int y= (int) event.getY();
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                mLastX=x;
                mLastY=y;
                break;
            case MotionEvent.ACTION_MOVE:
                int offsetX=x-mLastX;
                int offsetY=y-mLastY;
                ((ViewGroup)getParent()).scrollBy(-offsetX,-offsetY);
                break;
            case MotionEvent.ACTION_UP:
                break;
        }
        return true;
    }
}
