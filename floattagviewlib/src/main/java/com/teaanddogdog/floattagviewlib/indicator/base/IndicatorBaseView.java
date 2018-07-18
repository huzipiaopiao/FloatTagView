package com.teaanddogdog.floattagviewlib.indicator.base;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.widget.RelativeLayout;

import com.teaanddogdog.floattagviewlib.R;


/**
 * @author banbury
 * @version v1.0
 * @created 2018/7/12_11:39.
 * @description
 */

public abstract class IndicatorBaseView extends RelativeLayout {

    protected float mInitTranslateY;
    protected float mInitTranslateX;
    private boolean isHide = true;
    private boolean isShow;
    private boolean isShowwing;
    private boolean isHiding;
    private ObjectAnimator mAnimShow;
    private ObjectAnimator mAnimHide;


    public IndicatorBaseView(Context context) {
        this(context, null);
    }

    public IndicatorBaseView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public IndicatorBaseView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        if (attrs!=null) {
            TypedArray a = getContext().obtainStyledAttributes(attrs, R.styleable.IndicatorBaseView);
            mInitTranslateX = a.getDimension(R.styleable.IndicatorBaseView_init_translate_x,0);
            mInitTranslateY = a.getDimension(R.styleable.IndicatorBaseView_init_translate_y,0);
            a.recycle();
        }

        mAnimShow = getAnimShow();
        mAnimHide = getAnimHide();
        mAnimShow.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationCancel(Animator animation) {
                super.onAnimationCancel(animation);
                isShow = false;
                isShowwing = false;
                isHide = false;
                isHiding = false;
            }

            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                isShow = true;
                isShowwing = false;
                isHide = false;
                isHiding = false;
            }

            @Override
            public void onAnimationStart(Animator animation) {
                super.onAnimationStart(animation);
                isShow = false;
                isShowwing = true;
                isHide = false;
                isHiding = false;
            }


        });


        mAnimHide.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationCancel(Animator animation) {
                super.onAnimationCancel(animation);
                isHide = false;
                isHiding = false;
                isShow = true;
                isShowwing = false;
            }

            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                isHide = true;
                isHiding = false;
                isShow = false;
                isShowwing = false;
            }

            @Override
            public void onAnimationStart(Animator animation) {
                super.onAnimationStart(animation);
                isHide = false;
                isHiding = true;
                isShow = true;
                isShowwing = false;

            }
        });
    }

    public IndicatorBaseView setInitTranslateY(float initTranslateY) {
        mInitTranslateY = initTranslateY;
        return this;
    }

    public IndicatorBaseView setInitTranslateX(float initTranslateX) {
        mInitTranslateX = initTranslateX;
        return this;
    }

    protected abstract ObjectAnimator getAnimShow();

    protected abstract ObjectAnimator getAnimHide();

    protected int dpToPx(int dp) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, getResources().getDisplayMetrics());
    }

    public void hide() {
        if (isShowwing) {
            mAnimShow.cancel();
        }
        hideSelf();
        isHide = true;
        isShowwing = false;
    }

    protected abstract void hideSelf();

    public void showWithAnim() {
        if (isHiding()) {
            mAnimHide.cancel();
        }
        mAnimShow.start();
    }

    public boolean isHiding() {
        return isHiding;
    }

    public void hideWidthAnim() {
        if (isShowwing) {
            mAnimShow.cancel();
        }
        mAnimHide.start();
    }

    public boolean isHide() {
        return isHide;
    }

    public boolean isShow() {
        return isShow;
    }

    public boolean isShowwing() {
        return isShowwing;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return super.onTouchEvent(event);
    }
}
