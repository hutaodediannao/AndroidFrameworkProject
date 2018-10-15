package com.hutao.androidappdesignproject.fragment;

import android.content.Context;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.hutao.androidappdesignproject.R;
import com.hutao.androidappdesignproject.activity.DetailActivity;
import com.hutao.androidappdesignproject.config.Constant;
import com.hutao.androidappdesignproject.fragment.baseFragment.AbsBaseFragment;
import com.hutao.androidappdesignproject.fragment.baseFragment.AbsListFragment;

import java.util.List;

/**
 * 描述: 字符串列表展示
 * 作者: 胡涛
 * 时间: 2018-10-15 10:57
 */
public class ListFragment extends AbsListFragment<String> {

    @Override
    public List<String> getContentLsit() {
        return Constant.getTAB_List(mParam1);
    }

    @Override
    public void clickItem(String s, int position, Context context) {
        //点击列表跳转到对应的页面
        DetailActivity.startNextActivity(mParam1, position, getContext());
    }

}
