package com.hutao.androidappdesignproject.activity;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.hutao.androidappdesignproject.R;
import com.hutao.androidappdesignproject.util.StringUtil;

/**
 * 描述: toolbar父页面
 * 作者: 胡涛
 * 时间: 2018-10-9 18:28
 */
public class ToolBarActivity extends BaseActivity {

    private View mRootView;
    private FrameLayout mContainer;
    public Toolbar mToolbar;
    public TextView mTitleTv;

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
        // 在setContentView之后，适配顶部状态栏
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        //  适配底部导航栏
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);

        mContainer = findViewById(R.id.container);
        mContainer.addView(view);

        initToolbar(R.id.toolbar, R.id.toolbar_title);
    }

    /**
     * 初始化toolbar
     */
    public Toolbar initToolbar(int id, int titleId) {
        mToolbar = findViewById(id);
        mTitleTv = findViewById(titleId);
        setSupportActionBar(mToolbar);
        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setDisplayShowTitleEnabled(false);
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isFinishing()) finish();
            }
        });
        setToolbarNavigationIcon(R.drawable.ic_chevron_left_black_24dp);
        return mToolbar;
    }

    public void setToolbarTitle(String title) {
        mTitleTv.setText(title);
    }

    public String getToolbarTitleContent() {
        return "";
    }

    public void setToolbarNavigationIcon(int res) {
        if (res != 0) {
            //统一设置返回图标icon
            mToolbar.setNavigationIcon(res);
        } else {
            mToolbar.setNavigationIcon(getResources().getDrawable(R.color.transparent));
        }
    }

}
