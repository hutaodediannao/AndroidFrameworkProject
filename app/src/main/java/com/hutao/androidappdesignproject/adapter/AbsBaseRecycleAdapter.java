package com.hutao.androidappdesignproject.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * 描述: 万能适配器
 * 作者: 胡涛
 * 时间: 2018-10-11 14:22
 */
public abstract class AbsBaseRecycleAdapter<T> extends RecyclerView.Adapter<CommonRecycleHolder> {

    public Context mContext;
    public List<T> mList;

    public AbsBaseRecycleAdapter(Context mContext, List<T> mList) {
        this.mContext = mContext;
        this.mList = mList;
    }

    @Override
    public CommonRecycleHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return CommonRecycleHolder.getInstance(mContext, parent, getLayout());
    }

    @Override
    public void onBindViewHolder(CommonRecycleHolder holder, final int position) {
        bindHolder(holder, mList.get(position), position);
        holder.mConvertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onItemClickListener != null) onItemClickListener.clickItem(position, mList.get(position));
            }
        });
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    public abstract int getLayout();

    public abstract void bindHolder(CommonRecycleHolder holder, T t, int position);

    public interface OnItemClickListener<T>{
        void clickItem(int position, T t);
    }

    private OnItemClickListener onItemClickListener;

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }
}
