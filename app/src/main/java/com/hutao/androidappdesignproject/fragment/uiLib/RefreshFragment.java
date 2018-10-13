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

/**
 * 描述: 上啦加载下拉刷新页面
 * 作者: 胡涛
 * 时间: 2018-10-12 16:31
 */
public class RefreshFragment extends AbsBaseFragment implements OnRefreshListener, OnLoadMoreListener{

    private static final String TAG = "RefreshFragment";
    private SwipeToLoadLayout swipeToLoadLayout;
    private RecyclerView recyclerView;
    private StringAdapter adapter;
    private List<String> list = new ArrayList<>();

    @Override
    public int getLayout() {
        return R.layout.fragment_refresh;
    }

    @Override
    public void initView() {
        swipeToLoadLayout = findView(R.id.swipeToLoadLayout);
        recyclerView = findView(R.id.swipe_target);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
    }

    @Override
    public void handEvent() {
        swipeToLoadLayout.setOnRefreshListener(this);
        swipeToLoadLayout.setOnLoadMoreListener(this);

        adapter = new StringAdapter(getContext(), list);
        recyclerView.setAdapter(adapter);

        adapter.setOnItemClickListener(new AbsBaseRecycleAdapter.OnItemClickListener<String>() {
            @Override
            public void clickItem(int position, String s) {
                showToast(s);
            }
        });

        //首次自动加载(调用该方法会自动回掉onRefresh()回掉)
        swipeToLoadLayout.setRefreshing(true);
    }

    @Override
    public void onLoadMore() {
        io.reactivex.Observable.timer(3, TimeUnit.SECONDS,  AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Long>() {
                    @Override
                    public void accept(Long aLong) throws Exception {
                        Log.i(TAG, "accept: threadName =====> " + Thread.currentThread().getName());
                        list.add("item");
                        swipeToLoadLayout.setLoadingMore(false);
                    }
                });
    }

    @Override
    public void onRefresh() {
        io.reactivex.Observable.timer(3, TimeUnit.SECONDS, AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Long>() {
                    @Override
                    public void accept(Long aLong) throws Exception {
                        Log.i(TAG, "accept: threadName =====> " + Thread.currentThread().getName());
                        list.clear();
                        list.add("item");
                        swipeToLoadLayout.setRefreshing(false);
                    }
                });
    }
}
