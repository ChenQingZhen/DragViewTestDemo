package com.cqz.dragviewtestdemo;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Scroller;

/**
 * Created by chenqz on 2016/10/9.
 */
public class DragView5 extends View {
    private int mLastX;
    private int mLastY;
    private Scroller mScroller;
    public DragView5(Context context) {
        this(context,null);
    }

    public DragView5(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    private void initView(Context context) {
        setBackgroundColor(Color.MAGENTA);
        mScroller=new Scroller(context);
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
                ((View)getParent()).scrollBy(-offsetX,-offsetY);
                break;
            case MotionEvent.ACTION_UP:
                View viewGroup= (View) getParent();
                mScroller.startScroll(viewGroup.getScrollX(),viewGroup.getScrollY(),-viewGroup.getScrollX(),-viewGroup.getScrollY());
                invalidate();
                break;
        }
        return true;

    }

    @Override
    public void computeScroll() {
        super.computeScroll();
        //判断Scroll是否执行完毕
        if(mScroller.computeScrollOffset()){
            ((ViewGroup)getParent()).scrollTo(mScroller.getCurrX(),mScroller.getCurrY());
            //通过重绘来不断调用computeScroll
            invalidate();
        }
    }
}
