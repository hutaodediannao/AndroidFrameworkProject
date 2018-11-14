package com.hutao.androidappdesignproject.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.hutao.androidappdesignproject.R;

/**
 * 描述: 阴影效果的CardView
 * 作者: 胡涛
 * 时间: 2018-11-14 15:21
 */
public class CardViewActivity extends ToolBarActivity {

    @Override
    public String getToolbarTitleContent() {
        return "CardView阴影效果";
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_view);
    }
}
