package com.hutao.androidappdesignproject.dialog;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.hutao.androidappdesignproject.R;
import com.hutao.androidappdesignproject.util.DensityUtil;

/**
 * 描述: 一个提示语和一个按钮的dialog
 * 作者: 胡涛
 * 时间: 2018-11-14 16:34
 */
public class EnterTipsDialog extends AbsDialog {

    private String mTitle;

    public EnterTipsDialog(@NonNull Context context, String title, EnterClickListener enterClickListener) {
        super(context);
        this.enterClickListener = enterClickListener;
        this.mTitle = title;
    }

    @Override
    int getDialogWidth() {
        return DensityUtil.dip2px(getContext(), 200);
    }

    @Override
    int getDialogHeight() {
        return DensityUtil.dip2px(getContext(), 100);
    }

    @Override
    int getDialogLayout() {
        return R.layout.dialog_tips_lay;
    }

    @Override
    void handEvent() {
        TextView tvTitle = getView(R.id.tv);
        tvTitle.setText(mTitle);
        Button btn = getView(R.id.enterBtn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (enterClickListener != null) enterClickListener.clickEnter(mTitle);
                dismiss();
            }
        });
    }

    private EnterClickListener enterClickListener;

    public void setEnterClickListener(EnterClickListener enterClickListener) {
        this.enterClickListener = enterClickListener;
    }

    public interface EnterClickListener{
        void clickEnter(String content);
    }
}
