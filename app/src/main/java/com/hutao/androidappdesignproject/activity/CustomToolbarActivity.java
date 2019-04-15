package com.hutao.androidappdesignproject.activity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.hutao.androidappdesignproject.R;

/**
 * 描述: 各种风格的dialog
 * 作者: 胡涛
 * 时间: 2019-4-15 9:05
 */
public class CustomToolbarActivity extends ToolBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_toolbar);

        setToolbarTitle("Toolbar控件使用");
        mTitleTv.setVisibility(View.GONE);
        // 显示应用的Logo
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        getSupportActionBar().setLogo(R.mipmap.xx_xiaoxi);

        // 显示标题和子标题
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        mToolbar.setTitle("标题");
        mToolbar.setSubtitle("这是消息内容部分");
        // 显示导航按钮
        mToolbar.setNavigationIcon(R.drawable.ic_chevron_left_black_24dp);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_toolbar_demo, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.toolbar_action1:
                showToast("投诉");
                return true;
            case R.id.toolbar_action2:
                showToast("表扬");
                return true;
            case R.id.toolbar_action3:
                showToast("批评");
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
