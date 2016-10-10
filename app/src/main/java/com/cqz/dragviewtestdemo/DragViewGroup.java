package com.cqz.dragviewtestdemo;

import android.content.Context;
import android.support.v4.view.ViewCompat;
import android.support.v4.widget.ViewDragHelper;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

/**
 * Created by chenqz on 2016/10/9.
 */
public class DragViewGroup extends FrameLayout {
    private ViewDragHelper mViewDragHelper;
    private View mMenuView;
    private View mMainView;
    private int mWidth;

    public DragViewGroup(Context context) {
        this(context,null);
    }

    public DragViewGroup(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView();
    }

    private void initView() {
        mViewDragHelper=ViewDragHelper.create(this,mCallBack);
    }

    private ViewDragHelper.Callback mCallBack=new ViewDragHelper.Callback() {
        @Override
        public boolean tryCaptureView(View child, int pointerId) {
            return child==mMainView;
        }

        @Override
        public int clampViewPositionVertical(View child, int top, int dy) {
            return 0;
        }

        @Override
        public int clampViewPositionHorizontal(View child, int left, int dx) {
            return left;
        }

        @Override
        public void onViewReleased(View releasedChild, float xvel, float yvel) {
            super.onViewReleased(releasedChild, xvel, yvel);
            if(mMainView.getLeft()<500){
                mViewDragHelper.smoothSlideViewTo(mMainView,0,0);
                ViewCompat.postInvalidateOnAnimation(DragViewGroup.this);
            }else {
                mViewDragHelper.smoothSlideViewTo(mMainView,300,0);
                ViewCompat.postInvalidateOnAnimation(DragViewGroup.this);
            }
        }
    };

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        mMenuView= getChildAt(0);
        mMainView=getChildAt(1);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        mWidth=mMenuView.getMeasuredWidth();
    }



    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        return mViewDragHelper.shouldInterceptTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
         mViewDragHelper.processTouchEvent(event);
        return true;
    }

    @Override
    public void computeScroll() {
        super.computeScroll();
        if(mViewDragHelper.continueSettling(true)){
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }
}
