package com.teaanddogdog.floattagviewlib.indicator;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AccelerateInterpolator;

import com.teaanddogdog.floattagviewlib.indicator.base.IndicatorBaseView;


public class HTopIndicatorItemView extends IndicatorBaseView {


    public HTopIndicatorItemView(Context context) {
        this(context, null);
    }

    public HTopIndicatorItemView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public HTopIndicatorItemView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    @Override
    protected ObjectAnimator getAnimShow() {
        ObjectAnimator mAnimShow = ObjectAnimator.ofFloat(this, View.TRANSLATION_Y, getTranslationY(), -8, 5, 0);
        mAnimShow.setDuration(400);
        mAnimShow.setInterpolator(new AccelerateInterpolator());
        return mAnimShow;
    }

    @Override
    protected ObjectAnimator getAnimHide() {
        ObjectAnimator mAnimHide = ObjectAnimator.ofFloat(this, View.TRANSLATION_Y, getTranslationY(), mInitTranslateY + 8, mInitTranslateY - 5, mInitTranslateY);
        mAnimHide.setDuration(400);
        mAnimHide.setInterpolator(new AccelerateInterpolator());
        return mAnimHide;
    }

    @Override
    protected void hideSelf() {
        this.setTranslationY(mInitTranslateY);
    }

}
