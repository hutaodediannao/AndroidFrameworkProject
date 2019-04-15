package com.hutao.androidappdesignproject.activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.MenuItem;

import com.hutao.androidappdesignproject.R;
import com.hutao.androidappdesignproject.activity.tabLayoutViewPagerFragment.TabParentFragment;
import com.hutao.androidappdesignproject.adapter.FragmentPageAdapter;
import com.hutao.androidappdesignproject.fragment.baseFragment.AbsBaseFragment;
import com.hutao.androidappdesignproject.util.BottomNavigationViewHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * 描述: BottomNavigationBarActivity框架开发
 * 作者: 胡涛
 * 时间: 2018-11-14 9:31
 */
public class BottomNavigationBarActivity extends ToolBarActivity {

    private ViewPager vp;
    private List<AbsBaseFragment> fragments;
    private FragmentPagerAdapter fragmentPagerAdapter;
    private List<String> mTitles;

    private BottomNavigationView bottomNavigationView;

    @Override
    public String getToolbarTitleContent() {
        return "TabLayout+ViewPager+Fragment框架";
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_navgitationbar);

        setToolbarTitle("BottomNavigationView滑动UI");
        initView();
        initData();
        setAdapter();
    }

    private void setAdapter() {
        fragmentPagerAdapter = new FragmentPageAdapter(getSupportFragmentManager(), fragments, mTitles);
        vp.setAdapter(fragmentPagerAdapter);
        vp.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if (menuItem != null) {
                    menuItem.setChecked(false);
                } else {
                    bottomNavigationView.getMenu().getItem(0).setChecked(false);
                }
                menuItem = bottomNavigationView.getMenu().getItem(position);
                menuItem.setChecked(true);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
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
    }

    private void initView() {
        vp = findViewById(R.id.vp);
        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        BottomNavigationViewHelper.disableShiftMode(bottomNavigationView);
    }

    private MenuItem menuItem;
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            menuItem = item;
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    vp.setCurrentItem(0);
                    return true;
                case R.id.navigation_dashboard:
                    vp.setCurrentItem(1);
                    return true;
                case R.id.navigation_notifications:
                    vp.setCurrentItem(2);
                    return true;
            }
            return false;
        }
    };
}
