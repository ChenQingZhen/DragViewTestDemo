package com.cqz.dragviewtestdemo;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by chenqz on 2016/10/9.
 */
public class DragView0 extends View {
    private int mLastX;
    private int mLastY;

    public DragView0(Context context) {
        this(context,null);
    }

    public DragView0(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView();
    }

    private void initView() {
        setBackgroundColor(Color.BLUE);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int rawX= (int) event.getRawX();
        int rawY= (int) event.getRawY();
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                mLastX=rawX;
                mLastY=rawY;
                break;
            case MotionEvent.ACTION_MOVE:
                int dX=rawX-mLastX;
                int dY=rawY-mLastY;
                layout(getLeft()+dX,getTop()+dY,getRight()+dX,getBottom()+dY);
                mLastX=rawX;
                mLastY=rawY;
                break;
            case MotionEvent.ACTION_UP:
                break;
        }
        return true;
    }
}
