package com.hutao.androidappdesignproject.util;

import android.content.Context;
import android.widget.Toast;

/**
 * 参考http://blog.csdn.net/shenyuanqing/article/details/46985091
 * Created by Administrator on 2018/1/21.
 */

public class ToastUtil {

    private static Toast mToast = null;

    public static void showToast(Context context, String text, int duration) {
        if (context == null || StringUtil.isEmpty(text)) return;
        cancelToast();
        mToast = Toast.makeText(context, text, duration);
        mToast.show();
    }

    public static void showToastShort(Context context, String text) {
        showToast(context, text, Toast.LENGTH_SHORT);
    }

    public static void showToastShort(Context context, int resId) {
        showToastShort(context, context.getString(resId));
    }

    public static void showToastLong(Context context, String text) {
        showToast(context, text, Toast.LENGTH_LONG);
    }

    public static void showToastLong(Context context, int resId) {
        showToastLong(context, context.getString(resId));
    }

    public static void cancelToast() {
        if (mToast != null) {
            mToast.cancel();
        }
    }

}
