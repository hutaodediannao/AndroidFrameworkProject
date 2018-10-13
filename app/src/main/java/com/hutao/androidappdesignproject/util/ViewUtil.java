package com.hutao.androidappdesignproject.util;

import android.content.Context;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.widget.TextView;

import com.hutao.androidappdesignproject.R;

/**
 * 设置各种view的特殊显示工具
 * Created by Administrator on 2018/1/30.
 */

public class ViewUtil {


    /**
     * 给一个TextView设置文字显示不同的颜色
     */
    public static void setSpannableString(Context context, TextView tv, String string, int startIndex, int endIndex) {
        SpannableString spannableString = new SpannableString(string);
        if (StringUtil.isEmpty(string))return;
        if (startIndex>= endIndex)return;
        if (startIndex<0 || startIndex>string.length()-1)return;
        if (endIndex>string.length()-1)return;
        spannableString.setSpan(new ForegroundColorSpan(context.getResources().getColor(R.color.red)), startIndex,endIndex, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        setTextView(tv, spannableString);
    }

    public static void setTextView(TextView tv, CharSequence content) {
        if (StringUtil.isEmpty(content)) return;
        if (tv == null) return;
        tv.setText(content);
    }
}
