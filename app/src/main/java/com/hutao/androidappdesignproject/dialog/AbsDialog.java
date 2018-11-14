package com.hutao.androidappdesignproject.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.hutao.androidappdesignproject.R;

/**
 * 描述: dialog基类
 * 作者: 胡涛
 * 时间: 2018-11-14 16:21
 */
public abstract class AbsDialog extends Dialog {

    public static final int DIALOG_WIDTh = 250;
    public static final int DIALOG_HEIGTH = 200;
    public View mDialogView;

    public static AbsDialog getInstance(Class cla) {
        AbsDialog absDialog = null;
        try {
            absDialog = (AbsDialog) cla.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        return absDialog;
    }

    public AbsDialog(@NonNull Context context) {
        this(context, R.style.CustomDialog);
    }

    public AbsDialog(@NonNull Context context, int themeResId) {
        super(context, themeResId);
    }

    protected AbsDialog(@NonNull Context context, boolean cancelable, @Nullable OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
    }

    public <T extends View> T getView(int viewId) {
        return this.mDialogView.findViewById(viewId);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setLayout(getDialogWidth() == 0 ? DIALOG_HEIGTH : getDialogWidth(), getDialogHeight() == 0 ? DIALOG_HEIGTH : getDialogHeight());

        mDialogView = LayoutInflater.from(getContext()).inflate(getDialogLayout(), null, false);
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.width = getDialogWidth();
        layoutParams.height = getDialogHeight();
        getWindow().setContentView(mDialogView, layoutParams);
        handEvent();

        this.setCancelable(true);
        this.setCanceledOnTouchOutside(true);
    }

    abstract int getDialogWidth();

    abstract int getDialogHeight();

    abstract int getDialogLayout();

    abstract void handEvent();

}
