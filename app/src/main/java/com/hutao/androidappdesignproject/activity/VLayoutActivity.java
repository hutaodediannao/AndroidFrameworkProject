package com.hutao.androidappdesignproject.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.LayoutHelper;
import com.alibaba.android.vlayout.VirtualLayoutManager;
import com.alibaba.android.vlayout.layout.GridLayoutHelper;
import com.alibaba.android.vlayout.layout.LinearLayoutHelper;
import com.alibaba.android.vlayout.layout.OnePlusNLayoutHelper;
import com.alibaba.android.vlayout.layout.SingleLayoutHelper;
import com.hutao.androidappdesignproject.R;

import java.util.LinkedList;

public class VLayoutActivity extends ToolBarActivity {

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vlayout);

        initView();
    }

    private void initView() {
        recyclerView = findViewById(R.id.recyclerView);
        //绑定VirtualLayoutManager
        VirtualLayoutManager virtualLayoutManager = new VirtualLayoutManager(this);
        recyclerView.setLayoutManager(virtualLayoutManager);

        OnePlusNLayoutHelper onePlusNLayoutHelper = new OnePlusNLayoutHelper();
        SingleLayoutHelper singleLayoutHelper = new SingleLayoutHelper();

        //设置线性布局
        LinearLayoutHelper linearLayoutHelper = new LinearLayoutHelper();
        linearLayoutHelper.setItemCount(5);
        linearLayoutHelper.setMarginBottom(100);

        GridLayoutHelper gridLayoutHelper = new GridLayoutHelper(3);
        GridLayoutHelper gridLayoutHelper2 = new GridLayoutHelper(2);
        LinearLayoutHelper linearLayoutHelper3 = new LinearLayoutHelper();

        LinkedList<DelegateAdapter.Adapter> adapters = new LinkedList<>();
        MyAdapterB adapter = new MyAdapterB(R.layout.vlayout_item_banner, singleLayoutHelper, 1, this);
        MyAdapter adapter0 = new MyAdapter(R.layout.vlayout_item0, linearLayoutHelper, 3, this);
        MyAdapter2 adapter1 = new MyAdapter2(R.layout.vlayout_item1, gridLayoutHelper, 3, this);
        MyAdapter3 adapter2 = new MyAdapter3(R.layout.vlayout_item2, gridLayoutHelper2, 5, this);
        MyAdapter4 adapter3 = new MyAdapter4(R.layout.vlayout_item3, linearLayoutHelper3, 5, this);
        MyAdapterOneN adapter4 = new MyAdapterOneN(R.layout.vlayout_item_one_n, onePlusNLayoutHelper, 3, this);

        adapters.add(adapter);
        adapters.add(adapter0);
        adapters.add(adapter4);
        adapters.add(adapter1);
        adapters.add(adapter2);
        adapters.add(adapter3);

        DelegateAdapter delegateAdapter = new DelegateAdapter(virtualLayoutManager, false);
        delegateAdapter.setAdapters(adapters);
        recyclerView.setAdapter(delegateAdapter);

    }

    @Override
    public String getToolbarTitleContent() {
        return "VLayout-Activity";
    }

    class MyAdapterB extends DelegateAdapter.Adapter<MyViewHolder> {

        private LayoutHelper mLayoutHelper;
        private int mLayout;
        private int mItemCount;
        private Context mContext;

        public MyAdapterB(int layout, LayoutHelper layoutHelper, int itemCount, Context context) {
            this.mLayoutHelper = layoutHelper;
            this.mLayout = layout;
            this.mItemCount = itemCount;
            this.mContext = context;
        }

        @Override
        public LayoutHelper onCreateLayoutHelper() {
            return mLayoutHelper;
        }

        @NonNull
        @Override
        public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View itemView = LayoutInflater.from(mContext).inflate(mLayout, parent, false);
            return new MyViewHolder(itemView);
        }

        @Override
        public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        }

        @Override
        public int getItemCount() {
            return mItemCount;
        }

        @Override
        public int getItemViewType(int position) {
            return 0;
        }
    }

    class MyAdapter extends DelegateAdapter.Adapter<MyViewHolder> {

        private LayoutHelper mLayoutHelper;
        private int mLayout;
        private int mItemCount;
        private Context mContext;

        public MyAdapter(int layout, LayoutHelper layoutHelper, int itemCount, Context context) {
            this.mLayoutHelper = layoutHelper;
            this.mLayout = layout;
            this.mItemCount = itemCount;
            this.mContext = context;
        }

        @Override
        public LayoutHelper onCreateLayoutHelper() {
            return mLayoutHelper;
        }

        @NonNull
        @Override
        public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View itemView = LayoutInflater.from(mContext).inflate(mLayout, parent, false);
            return new MyViewHolder(itemView);
        }

        @Override
        public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
            TextView tv = holder.itemView.findViewById(R.id.tv);
            tv.setText("item" + position);
        }

        @Override
        public int getItemCount() {
            return mItemCount;
        }

        @Override
        public int getItemViewType(int position) {
            return 1;
        }
    }

    class MyAdapterOneN extends DelegateAdapter.Adapter<MyViewHolder> {

        private LayoutHelper mLayoutHelper;
        private int mLayout;
        private int mItemCount;
        private Context mContext;

        public MyAdapterOneN(int layout, LayoutHelper layoutHelper, int itemCount, Context context) {
            this.mLayoutHelper = layoutHelper;
            this.mLayout = layout;
            this.mItemCount = itemCount;
            this.mContext = context;
        }

        @Override
        public LayoutHelper onCreateLayoutHelper() {
            return mLayoutHelper;
        }

        @NonNull
        @Override
        public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View itemView = LayoutInflater.from(mContext).inflate(mLayout, parent, false);
            return new MyViewHolder(itemView);
        }

        @Override
        public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        }

        @Override
        public int getItemCount() {
            return mItemCount;
        }

        @Override
        public int getItemViewType(int position) {
            return 5;
        }
    }

    class MyAdapter2 extends DelegateAdapter.Adapter<MyViewHolder> {

        private LayoutHelper mLayoutHelper;
        private int mLayout;
        private int mItemCount;
        private Context mContext;

        public MyAdapter2(int layout, LayoutHelper layoutHelper, int itemCount, Context context) {
            this.mLayoutHelper = layoutHelper;
            this.mLayout = layout;
            this.mItemCount = itemCount;
            this.mContext = context;
        }

        @Override
        public LayoutHelper onCreateLayoutHelper() {
            return mLayoutHelper;
        }

        @NonNull
        @Override
        public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View itemView = LayoutInflater.from(mContext).inflate(mLayout, parent, false);
            return new MyViewHolder(itemView);
        }

        @Override
        public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
            ImageView iv = holder.itemView.findViewById(R.id.iv);
            iv.setImageResource(R.mipmap.ic_launcher);
        }

        @Override
        public int getItemCount() {
            return mItemCount;
        }

        @Override
        public int getItemViewType(int position) {
            return 2;
        }
    }

    class MyAdapter3 extends DelegateAdapter.Adapter<MyViewHolder> {

        private LayoutHelper mLayoutHelper;
        private int mLayout;
        private int mItemCount;
        private Context mContext;

        public MyAdapter3(int layout, LayoutHelper layoutHelper, int itemCount, Context context) {
            this.mLayoutHelper = layoutHelper;
            this.mLayout = layout;
            this.mItemCount = itemCount;
            this.mContext = context;
        }

        @Override
        public LayoutHelper onCreateLayoutHelper() {
            return mLayoutHelper;
        }

        @NonNull
        @Override
        public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View itemView = LayoutInflater.from(mContext).inflate(mLayout, parent, false);
            return new MyViewHolder(itemView);
        }

        @Override
        public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
            ImageView iv = holder.itemView.findViewById(R.id.iv);
            iv.setImageResource(R.mipmap.ic_launcher);
        }

        @Override
        public int getItemCount() {
            return mItemCount;
        }

        @Override
        public int getItemViewType(int position) {
            return 3;
        }
    }

    class MyAdapter4 extends DelegateAdapter.Adapter<MyViewHolder> {

        private LayoutHelper mLayoutHelper;
        private int mLayout;
        private int mItemCount;
        private Context mContext;

        public MyAdapter4(int layout, LayoutHelper layoutHelper, int itemCount, Context context) {
            this.mLayoutHelper = layoutHelper;
            this.mLayout = layout;
            this.mItemCount = itemCount;
            this.mContext = context;
        }

        @Override
        public LayoutHelper onCreateLayoutHelper() {
            return mLayoutHelper;
        }

        @NonNull
        @Override
        public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View itemView = LayoutInflater.from(mContext).inflate(mLayout, parent, false);
            return new MyViewHolder(itemView);
        }

        @Override
        public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
            ImageView iv = holder.itemView.findViewById(R.id.iv);
            iv.setImageResource(R.mipmap.ic_launcher);
        }

        @Override
        public int getItemCount() {
            return mItemCount;
        }

        @Override
        public int getItemViewType(int position) {
            return 4;
        }
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        public MyViewHolder(View itemView) {
            super(itemView);
        }
    }
}
