package com.hungnt.funny.Animations;

import android.support.v4.view.ViewPager.PageTransformer;
import android.view.View;

/**
 * Created by HungNT on 27/July/2015.
 */
public class DepthPageTransformer implements PageTransformer {

    private static final float MIN_SCALE = 0.8f;

    @Override
    public void transformPage(View page, float position) {
        int pageWidth = page.getWidth();

        if (position < -1) {
            page.setAlpha(0f);
        } else if (position <= 0) {
            page.setAlpha(1);
            page.setTranslationX(0);
            page.setScaleX(1);
            page.setScaleY(1);
        } else if (position <= 1) {
            page.setAlpha(1 - position);
            page.setTranslationX(pageWidth * -position);

            float scaleFactor = MIN_SCALE + (1 - MIN_SCALE) * (1 - Math.abs(position));

            page.setScaleY(scaleFactor);
            page.setScaleY(scaleFactor);
        } else {
            page.setAlpha(0f);
        }

    }
}
