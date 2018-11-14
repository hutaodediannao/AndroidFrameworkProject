package com.hutao.androidappdesignproject.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.hutao.androidappdesignproject.R;
import com.hutao.androidappdesignproject.dialog.DialogFactory;
import com.hutao.androidappdesignproject.dialog.EnterTipsDialog;
import com.hutao.androidappdesignproject.dialog.TipsDialog;

/**
 * 描述: 对话框集合
 * 作者: 胡涛
 * 时间: 2018-11-14 16:46
 */
public class DialogActivity extends ToolBarActivity {

    @Override
    public String getToolbarTitleContent() {
        return "应用对话框";
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog);
    }

    public void tipsDialog(View view) {
        TipsDialog tipsDialog = DialogFactory.getTipsDialogInstance(this, "这是提示语");
        tipsDialog.show();
    }


    public void enterTipsDialog(View view) {
        EnterTipsDialog enterTipsDialog = DialogFactory.getTipsDialogInstance(this, "对话框dialog",
                new EnterTipsDialog.EnterClickListener() {
                    @Override
                    public void clickEnter(String content) {
                        showToast(content);
                    }
                });
    }
}
