package com.hutao.androidappdesignproject.activity;

import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.hutao.androidappdesignproject.R;
import com.hutao.androidappdesignproject.activity.tabLayoutViewPagerFragment.TabParentFragment;
import com.hutao.androidappdesignproject.adapter.FragmentPageAdapter;
import com.hutao.androidappdesignproject.fragment.baseFragment.AbsBaseFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * 描述: TabLayout+ViewPager+Fragment框架开发
 * 作者: 胡涛
 * 时间: 2018-11-14 9:31
 */
public class TabVpFrmActivity extends ToolBarActivity {

    private TabLayout tabTitle;
    private ViewPager vp;
    private List<AbsBaseFragment> fragments;
    private FragmentPagerAdapter fragmentPagerAdapter;
    private List<String> mTitles;

    @Override
    public String getToolbarTitleContent() {
        return "TabLayout+ViewPager+Fragment框架";
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_vp_frm);

        initView();
        initData();
        setAdapter();
    }

    private void setAdapter() {
        fragmentPagerAdapter = new FragmentPageAdapter(getSupportFragmentManager(), fragments, mTitles);
        vp.setAdapter(fragmentPagerAdapter);
        tabTitle.setupWithViewPager(vp);
    }

    private void initData() {
        fragments = new ArrayList<>();
        TabParentFragment f0 = (TabParentFragment) AbsBaseFragment.newInstance("one", TabParentFragment.class);
        TabParentFragment f1 = (TabParentFragment) AbsBaseFragment.newInstance("two", TabParentFragment.class);
        TabParentFragment f2 = (TabParentFragment) AbsBaseFragment.newInstance("three", TabParentFragment.class);
        fragments.add(f0);
        fragments.add(f1);
        fragments.add(f2);

        mTitles = new ArrayList<>();
        mTitles.add("主页");
        mTitles.add("圈子");
        mTitles.add("我的");

        for (String tabContent : mTitles) {
            tabTitle.addTab(tabTitle.newTab());
        }

        tabTitle.getTabAt(0).select();
        tabTitle.setTabMode(TabLayout.MODE_FIXED);
    }

    private void initView() {
        tabTitle = findViewById(R.id.title);
        vp = findViewById(R.id.vp);
    }
}
