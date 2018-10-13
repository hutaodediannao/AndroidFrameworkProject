package com.hutao.androidappdesignproject.fragment;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.hutao.androidappdesignproject.R;
import com.hutao.androidappdesignproject.activity.DetailActivity;
import com.hutao.androidappdesignproject.config.Constant;

public class ListFragment extends AbsBaseFragment {

    private ListView listView;
    private ArrayAdapter<String> adapter;

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
                android.R.layout.simple_list_item_1, Constant.getTAB_List(mParam1));
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //点击列表跳转到对应的页面
                DetailActivity.startNextActivity(mParam1, position, getContext());
            }
        });
    }

}
