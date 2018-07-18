package com.teaanddogdog.floattagviewlib.indicator;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AccelerateInterpolator;

import com.teaanddogdog.floattagviewlib.indicator.base.IndicatorBaseView;


public class VLeftIndicatorItemView extends IndicatorBaseView {


    public VLeftIndicatorItemView(Context context) {
        this(context, null);
    }

    public VLeftIndicatorItemView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public VLeftIndicatorItemView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected ObjectAnimator getAnimShow() {
        ObjectAnimator mAnimShow = ObjectAnimator.ofFloat(this, View.TRANSLATION_X, getTranslationX(), -8, 5, 0);
        mAnimShow.setDuration(400);
        mAnimShow.setInterpolator(new AccelerateInterpolator());
        return mAnimShow;
    }

    @Override
    protected ObjectAnimator getAnimHide() {
        ObjectAnimator mAnimHide = ObjectAnimator.ofFloat(this, View.TRANSLATION_X, getTranslationX(), mInitTranslateX + 8, mInitTranslateX - 5, mInitTranslateX);
        mAnimHide.setDuration(400);
        mAnimHide.setInterpolator(new AccelerateInterpolator());
        return mAnimHide;
    }

    @Override
    protected void hideSelf() {
        this.setTranslationX(mInitTranslateX);
    }

}
