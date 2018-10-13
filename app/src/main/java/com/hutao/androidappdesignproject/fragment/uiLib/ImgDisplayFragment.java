package com.hutao.androidappdesignproject.fragment.uiLib;


import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.aspsine.swipetoloadlayout.OnLoadMoreListener;
import com.aspsine.swipetoloadlayout.OnRefreshListener;
import com.aspsine.swipetoloadlayout.SwipeToLoadLayout;
import com.hutao.androidappdesignproject.R;
import com.hutao.androidappdesignproject.adapter.AbsBaseRecycleAdapter;
import com.hutao.androidappdesignproject.adapter.StringAdapter;
import com.hutao.androidappdesignproject.fragment.AbsBaseFragment;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;


public class ImgDisplayFragment extends AbsBaseFragment{


    @Override
    public int getLayout() {
        return R.layout.fragment_img_display;
    }

    @Override
    public void initView() {

    }

    @Override
    public void handEvent() {

    }

}
