package com.cqz.dragviewtestdemo;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by chenqz on 2016/10/9.
 */
public class DragView extends View {
    private int mLastX;
    private int mLastY;
    public DragView(Context context) {
        this(context,null);
    }

    public DragView(Context context, AttributeSet attrs) {
        super(context, attrs);
       initView();
    }

    private void initView() {
        setBackgroundColor(Color.CYAN);
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
                int dX=x-mLastX;
                int dY=y-mLastY;
                layout(getLeft()+dX,getTop()+dY,getRight()+dX,getBottom()+dY);
                break;
            case MotionEvent.ACTION_UP:
                break;
        }
        return true;
    }
}
