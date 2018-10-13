package com.hutao.androidappdesignproject.adapter;

import android.content.Context;

import com.hutao.androidappdesignproject.R;

import java.util.List;

/**
 * Created by hutao on 2018-10-12.
 */

public class StringAdapter extends AbsBaseRecycleAdapter<String> {

    public StringAdapter(Context mContext, List<String> mList) {
        super(mContext, mList);
    }

    @Override
    int getLayout() {
        return R.layout.item_textview;
    }

    @Override
    void bindHolder(CommonRecycleHolder holder, String s, int position) {
        holder.setTextView(R.id.tv, s);
    }
}
