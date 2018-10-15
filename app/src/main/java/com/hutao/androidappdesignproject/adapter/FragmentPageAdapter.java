package com.hutao.androidappdesignproject.adapter;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.hutao.androidappdesignproject.config.Constant;
import com.hutao.androidappdesignproject.fragment.baseFragment.AbsBaseFragment;

import java.util.List;

/**
 * 描述: fragment适配器
 * 作者: 胡涛
 * 时间: 2018-10-11 10:32
 */
public class FragmentPageAdapter extends FragmentPagerAdapter {

    private List<AbsBaseFragment> fragmentList;

    public FragmentPageAdapter(FragmentManager fm, List<AbsBaseFragment> fragments) {
        super(fm);
        this.fragmentList = fragments;
    }

    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return Constant.TAB_List.get(position);
    }
}
