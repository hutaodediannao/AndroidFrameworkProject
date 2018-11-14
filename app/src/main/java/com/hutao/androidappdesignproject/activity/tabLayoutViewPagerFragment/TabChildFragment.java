package com.hutao.androidappdesignproject.activity.tabLayoutViewPagerFragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.hutao.androidappdesignproject.R;
import com.hutao.androidappdesignproject.fragment.baseFragment.AbsBaseFragment;

public class TabChildFragment extends AbsBaseFragment {

    private TextView tv;

    @Override
    public int getLayout() {
        return R.layout.fragment_tab_child;
    }

    @Override
    public void initView() {
        tv = findView(R.id.tv);
    }

    @Override
    public void handEvent() {
        String content = getArguments().getString(ARG_PARAM1);
        tv.setText(content);
    }


}
