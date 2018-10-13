package com.hutao.androidappdesignproject.activity;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.Menu;

import com.hutao.androidappdesignproject.R;
import com.hutao.androidappdesignproject.adapter.FragmentPageAdapter;
import com.hutao.androidappdesignproject.config.Constant;
import com.hutao.androidappdesignproject.fragment.AbsBaseFragment;
import com.hutao.androidappdesignproject.fragment.ListFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends ToolBarActivity {

    private TabLayout tabLayout;
    private ViewPager vp;
    private List<AbsBaseFragment> fragments = new ArrayList<>();
    private FragmentPageAdapter fragmentPageAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tabLayout = findViewById(R.id.tabLayout);
        tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);

        initFragment();
        for (int i = 0; i < fragments.size(); i++) tabLayout.addTab(tabLayout.newTab().setText(Constant.TAB_List.get(i)));
        initView();
        setAdapter();
        setListener();

    }

    private void setListener() {
        vp.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
    }

    private void setAdapter() {
        fragmentPageAdapter = new FragmentPageAdapter(getSupportFragmentManager(), fragments);
        vp.setAdapter(fragmentPageAdapter);
        vp.setOffscreenPageLimit(fragments.size());//缓存全部页面
        tabLayout.setupWithViewPager(vp);
    }

    private void initView() {
        vp = findViewById(R.id.vp);
    }

    private void initFragment() {
        fragments = new ArrayList<>();
        for (int i = 0; i < Constant.TAB_List.size(); i++) fragments.add(AbsBaseFragment.newInstance(Constant.TAB_List.get(i), ListFragment.class));
    }

    @Override
    String getToolbarTitleContent() {
        return "主页";
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

}
