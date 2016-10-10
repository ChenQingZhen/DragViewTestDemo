package com.cqz.dragviewtestdemo;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

/**
 * 待完善 Created by chenqz on 2016/10/9.
 */
public class DragView4 extends View {
    private int mLastX;
    private int mLastY;
    public DragView4(Context context) {
        this(context,null);
    }

    public DragView4(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView();
    }

    private void initView() {
        setBackgroundColor(Color.GREEN);
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
                int x= (int) event.getX();
                int y= (int) event.getY();
                ((ViewGroup)getParent()).scrollTo(-rawX+getLeft()+x,-rawY+getTop()+y);

                break;
            case MotionEvent.ACTION_UP:
                break;
        }
        return true;
    }
}
