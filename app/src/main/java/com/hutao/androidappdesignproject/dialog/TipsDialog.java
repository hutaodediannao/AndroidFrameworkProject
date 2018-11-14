package com.hutao.androidappdesignproject.dialog;

import android.content.Context;
import android.support.annotation.NonNull;
import android.widget.TextView;

import com.hutao.androidappdesignproject.R;
import com.hutao.androidappdesignproject.util.DensityUtil;

/**
 * 描述: 一个提示语的dialog
 * 作者: 胡涛
 * 时间: 2018-11-14 16:34
 */
public class TipsDialog extends AbsDialog {

    private String mTitle;

    public TipsDialog(@NonNull Context context, String title) {
        super(context);
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
    }
}
