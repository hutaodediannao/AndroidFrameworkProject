package com.hutao.androidappdesignproject.dialog;

import android.content.Context;

/**
 * 描述: 对话框工厂类
 * 作者: 胡涛
 * 时间: 2018-11-14 16:23
 */
public class DialogFactory {

    /**
     * 获取一个tipsDialog
     */
    public static TipsDialog getTipsDialogInstance(Context context, String content) {
        TipsDialog tipsDialog = new TipsDialog(context, content);
        return tipsDialog;
    }








}
