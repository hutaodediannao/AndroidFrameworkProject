package com.hutao.androidappdesignproject.activity;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.hutao.androidappdesignproject.R;
import com.hutao.androidappdesignproject.util.StringUtil;

/**
 * 描述: toolbar父页面
 * 作者: 胡涛
 * 时间: 2018-10-9 18:28
 */
public abstract class ToolBarActivity extends BaseActivity {

    private View mRootView;
    private FrameLayout mContainer;
    public Toolbar mToolbar;
    private  TextView mTitleTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void setContentView(View view) {
        this.setContentView(view, new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
    }

    @Override
    public void setContentView(int layoutResID) {
        this.setContentView(LayoutInflater.from(this).inflate(layoutResID, null));
    }

    @Override
    public void setContentView(View view, ViewGroup.LayoutParams params) {

        mRootView = LayoutInflater.from(this).inflate(R.layout.activity_tool_bar, null, false);
        super.setContentView(mRootView, params);

        mContainer = findViewById(R.id.container);
        mContainer.addView(view);

        initToolbar(R.id.toolbar, R.id.toolbar_title, StringUtil.getContent(getToolbarTitleContent()));
    }

    /**
     * 初始化toolbar
     */
    public Toolbar initToolbar(int id, int titleId, String titleString) {
        mToolbar = findViewById(id);
        mTitleTv = findViewById(titleId);
        mTitleTv.setText(titleString);
        setSupportActionBar(mToolbar);
        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        if (actionBar != null){
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setDisplayShowTitleEnabled(false);
        }

        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isFinishing()) finish();
            }
        });

        return mToolbar;
    }

    public void setToolbarTitle(String title) {
        mTitleTv.setText(title);
    }

   abstract String getToolbarTitleContent();

}
