package com.hutao.androidappdesignproject.activity.tabLayoutViewPagerFragment;

import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;

import com.hutao.androidappdesignproject.R;
import com.hutao.androidappdesignproject.adapter.FragmentPageAdapter;
import com.hutao.androidappdesignproject.fragment.baseFragment.AbsBaseFragment;

import java.util.ArrayList;
import java.util.List;

public class TabParentFragment extends AbsBaseFragment {

    private TabLayout tabTitle;
    private ViewPager vp;
    private List<AbsBaseFragment> fragments;
    private FragmentPagerAdapter fragmentPagerAdapter;
    private List<String> mTitles;


    @Override
    public int getLayout() {
        return R.layout.fragment_tab_parent;
    }

    @Override
    public void initView() {
        tabTitle = findView(R.id.title);
        vp = findView(R.id.vp);
    }

    private void setAdapter() {
        fragmentPagerAdapter = new FragmentPageAdapter(getChildFragmentManager(), fragments, mTitles);
        vp.setAdapter(fragmentPagerAdapter);
        tabTitle.setupWithViewPager(vp);
    }

    private void initData() {
        fragments = new ArrayList<>();
        TabChildFragment f0 = (TabChildFragment) AbsBaseFragment.newInstance("one", TabChildFragment.class);
        TabChildFragment f1 = (TabChildFragment) AbsBaseFragment.newInstance("two", TabChildFragment.class);
        TabChildFragment f2 = (TabChildFragment) AbsBaseFragment.newInstance("three", TabChildFragment.class);
        fragments.add(f0);
        fragments.add(f1);
        fragments.add(f2);

        mTitles = new ArrayList<>();
        String tabKey = getArguments().getString(ARG_PARAM1);
        switch (tabKey) {
            case "one":
                mTitles.add("头条");
                mTitles.add("新闻");
                mTitles.add("天气");
                break;
            case "two":
                mTitles.add("朋友圈");
                mTitles.add("明星圈");
                mTitles.add("个人圈");
                break;
            case "three":
                mTitles.add("个人中心");
                mTitles.add("设置");
                mTitles.add("偏好设置");
                break;
        }

        for (String tabContent : mTitles) {
            tabTitle.addTab(tabTitle.newTab());
        }

        if (tabTitle.getTabCount() != 0) {
            tabTitle.getTabAt(0).select();
        }
        tabTitle.setTabMode(TabLayout.MODE_FIXED);
    }

    @Override
    public void handEvent() {
        initData();
        setAdapter();
    }
}
