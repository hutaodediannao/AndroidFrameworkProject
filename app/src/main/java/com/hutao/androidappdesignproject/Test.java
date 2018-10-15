package com.hutao.androidappdesignproject;

import android.content.Context;
import android.widget.Toast;
import com.hutao.androidappdesignproject.model.User;


/**
 * 描述: 测试工具类
 * 作者: 胡涛
 * 时间: 2018-10-15 11:48
 */
public class Test {

    /**
     * dataBinding静态方法调用
     */
    public static void showTest(Context context, User user) {
        Toast.makeText(context, user.toString(), Toast.LENGTH_SHORT).show();
    }

    /**
     * dataBinding一般方法的使用
     */
    public void showTest(Context context, String string) {
        Toast.makeText(context, string, Toast.LENGTH_SHORT).show();
    }



}
