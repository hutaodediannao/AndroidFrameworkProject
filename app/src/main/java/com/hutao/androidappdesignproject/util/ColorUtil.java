package com.hutao.androidappdesignproject.util;

import android.content.Context;
import android.graphics.Color;

/**
 * Created by hutao on 2018-10-16.
 */

public class ColorUtil {

    public static String changeColor(int id, Context context) {
        StringBuffer stringBuffer = new StringBuffer();
        int color = context.getResources().getColor(id);
        stringBuffer.append("#");
        stringBuffer.append(Integer.toHexString(Color.alpha(color)));
        stringBuffer.append(Integer.toHexString(Color.red(color)));
        stringBuffer.append(Integer.toHexString(Color.green(color)));
        stringBuffer.append(Integer.toHexString(Color.blue(color)));
        return stringBuffer.toString();
    }

}
