package com.hutao.androidappdesignproject.util;

import android.content.Context;
import android.widget.Toast;

/**
 * 参考http://blog.csdn.net/shenyuanqing/article/details/46985091
 * Created by Administrator on 2018/1/21.
 */

public class ToastUtil {

    private static Toast mToast = null;

    public static void showToast(final Context context, final String text, final int duration) {
        if (context == null || StringUtil.isEmpty(text)) return;
        final android.os.Handler handler = new android.os.Handler(context.getMainLooper());
        handler.post(new Runnable() {
            @Override
            public void run() {
                cancelToast();
                mToast = Toast.makeText(context, text, duration);
                mToast.show();
                handler.removeCallbacks(this);
            }
        });
    }

    public static void showToast(Context context, String text) {
        showToast(context, text, Toast.LENGTH_SHORT);
    }

    public static void showToast(Context context, int resId) {
        showToast(context, context.getString(resId));
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
