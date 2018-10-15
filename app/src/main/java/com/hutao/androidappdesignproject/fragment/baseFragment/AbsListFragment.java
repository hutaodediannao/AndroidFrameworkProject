package com.hutao.androidappdesignproject.fragment.baseFragment;

import android.content.Context;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.hutao.androidappdesignproject.R;
import com.hutao.androidappdesignproject.activity.DetailActivity;
import com.hutao.androidappdesignproject.config.Constant;

import java.util.List;

public abstract class AbsListFragment<T> extends AbsBaseFragment {

    private ListView listView;
    private ArrayAdapter<T> adapter;

    public AbsListFragment() {

    }

    @Override
    public int getLayout() {
        return R.layout.fragment_list;
    }

    @Override
    public void initView() {
        listView = findView(R.id.listView);
    }

    @Override
    public void handEvent() {
        adapter = new ArrayAdapter<>(this.getContext(),
                android.R.layout.simple_list_item_1, getContentLsit());
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //点击列表跳转到对应的页面
                clickItem(getContentLsit().get(position), position, getContext());
            }
        });
    }

    public abstract List<T> getContentLsit();

    public abstract void clickItem(T t, int position, Context context);

}
