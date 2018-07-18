package com.teaanddogdog.floattagviewlib;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;

import com.teaanddogdog.floattagviewlib.indicator.base.IndicatorBaseView;


/**
 * @author banbury
 * @version v1.0
 * @created 2018/7/11_17:09.
 * @description
 */

public class FloatTagRecyclerView extends RecyclerView {
    /**
     * 横向摆放模式
     */
    public static final String Mode_H = "1";
    /**
     * 竖向摆放模式
     */
    public static final String Mode_V = "2";
    private String mode;

    public FloatTagRecyclerView(Context context) {
        this(context, null);
    }

    public FloatTagRecyclerView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public FloatTagRecyclerView(Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        if (attrs != null) {
            TypedArray a = getContext().obtainStyledAttributes(attrs, R.styleable.FloatTagRecyclerView);
            mode = a.getString(R.styleable.FloatTagRecyclerView_arrange_mode);
            a.recycle();
        }
    }

    public String getMode() {
        return mode;
    }

    public FloatTagRecyclerView setMode(String mode) {
        this.mode = mode;
        return this;
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent e) {
        IndicatorBaseView itemView;
        int[] location;
        int x;
        int y;

        boolean isCurrentView;

        for (int i = 0; i < getChildCount(); i++) {
            itemView = (IndicatorBaseView) getChildAt(i);
            location = new int[2];
            itemView.getLocationOnScreen(location);
            x = location[0];
            y = location[1];



            if (TextUtils.isEmpty(mode) || TextUtils.equals(mode, Mode_H)) {
                isCurrentView = e.getRawX() >= x && e.getRawX() <= (x + itemView.getWidth());
            } else {
                isCurrentView = e.getRawY() >= y && e.getRawY() <= (y + itemView.getHeight());
            }

            if (isCurrentView && !itemView.isShow()) {//是当前点击的子view，且view是不是显示的状态下，直接拦截事件，做onTouchEvent中的动作；否则走父类（会返回false），才能响应ziview中设置的点击事件
                return true;
            }
        }
        return super.onInterceptTouchEvent(e);

    }

    @Override
    public boolean onTouchEvent(MotionEvent e) {

        IndicatorBaseView itemView;
        int[] location;
        int x;
        int y;

        boolean isCurrentView;

        for (int i = 0; i < getChildCount(); i++) {
            itemView = (IndicatorBaseView) getChildAt(i);
            location = new int[2];
            itemView.getLocationOnScreen(location);
            x = location[0];
            y = location[1];

            if (TextUtils.isEmpty(mode) || TextUtils.equals(mode, Mode_H)) {
                isCurrentView = e.getRawX() >= x && e.getRawX() <= (x + itemView.getWidth());
            } else {
                isCurrentView = e.getRawY() >= y && e.getRawY() <= (y + itemView.getHeight());
            }

            if (isCurrentView) {//是当前点击的子view
                if (itemView.isHide() && !itemView.isShowwing() || itemView.isHiding()) {
                    itemView.showWithAnim();
                }
//                Log.d(TAG, "onTouchEvent: \ny" + y + "\nheight" + itemView.getHeight() + "\n事件Y" + e.getY());
            } else {
                if (itemView.isShow() && !itemView.isHiding() || itemView.isShowwing()) {
                    itemView.hideWidthAnim();
                }
            }
        }
        return super.onTouchEvent(e);
    }


}
