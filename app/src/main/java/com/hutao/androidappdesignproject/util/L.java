package com.hutao.androidappdesignproject.util;

import android.util.Log;

/**
 * log日志打印工具类
 * Created by Administrator on 2018/1/7.
 */

public class L {

    //日志打印开关
    public static boolean IS_DEBUG = false;

    //规定每段显示的长度
    private static int LOG_MAXLENGTH = 2000;

    public static void i(String tag, String logMsg) {
        int strLength = logMsg.length();
        int start = 0;
        int end = LOG_MAXLENGTH;
        for (int i = 0; i < 100; i++) {
            //剩下的文本还是大于规定长度则继续重复截取并输出
            if (strLength > end) {
                if (IS_DEBUG)Log.i(tag, logMsg.substring(start, end));
                start = end;
                end = end + LOG_MAXLENGTH;
            } else {
                if (IS_DEBUG)Log.i(tag, logMsg.substring(start, strLength));
                break;
            }
        }
    }

    public static void v(String tag, String logMsg) {
        int strLength = logMsg.length();
        int start = 0;
        int end = LOG_MAXLENGTH;
        for (int i = 0; i < 100; i++) {
            //剩下的文本还是大于规定长度则继续重复截取并输出
            if (strLength > end) {
                if (IS_DEBUG)Log.v(tag + i, logMsg.substring(start, end));
                start = end;
                end = end + LOG_MAXLENGTH;
            } else {
                if (IS_DEBUG)Log.v(tag, logMsg.substring(start, strLength));
                break;
            }
        }
    }

    public static void e(String tag, String logMsg) {
        int strLength = logMsg.length();
        int start = 0;
        int end = LOG_MAXLENGTH;
        for (int i = 0; i < 100; i++) {
            //剩下的文本还是大于规定长度则继续重复截取并输出
            if (strLength > end) {
                if (IS_DEBUG)Log.e(tag + i, logMsg.substring(start, end));
                start = end;
                end = end + LOG_MAXLENGTH;
            } else {
                if (IS_DEBUG)Log.e(tag, logMsg.substring(start, strLength));
                break;
            }
        }
    }

}
