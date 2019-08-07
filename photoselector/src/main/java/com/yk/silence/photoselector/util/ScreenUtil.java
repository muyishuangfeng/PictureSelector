package com.yk.silence.photoselector.util;

import android.content.Context;
import android.util.DisplayMetrics;

public class ScreenUtil {

    private ScreenUtil() {
        throw new UnsupportedOperationException("cannot be instantiated");
    }


    /**
     * 获取屏幕宽度
     */
    public static int getScreenWidth(Context context) {
        DisplayMetrics dm = context.getResources().getDisplayMetrics();
        return dm.widthPixels;
    }

    /**
     * 获取屏幕高度
     */
    public static int getScreenHeight(Context context) {
        DisplayMetrics dm = context.getResources().getDisplayMetrics();
        return dm.heightPixels;
    }

}
