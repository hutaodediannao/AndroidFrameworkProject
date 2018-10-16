package com.hutao.androidappdesignproject.adapter.childAdapter;

import android.content.Context;

import com.hutao.androidappdesignproject.R;
import com.hutao.androidappdesignproject.adapter.AbsBaseRecycleAdapter;
import com.hutao.androidappdesignproject.adapter.CommonRecycleHolder;
import com.hutao.androidappdesignproject.util.ColorUtil;

import java.util.List;

/**
 * 描述: 颜色展示
 * 作者: 胡涛
 * 时间: 2018-10-16 8:37
 */
public class NormalColorAdapter  extends AbsBaseRecycleAdapter<Integer> {

    public NormalColorAdapter(Context mContext, List<Integer> mList) {
        super(mContext, mList);
    }

    @Override
    public int getLayout() {
        return R.layout.item_normal_textview;
    }

    @Override
    public void bindHolder(CommonRecycleHolder holder, Integer integer, int position) {
        holder.setTextViewAndColor(R.id.tv, ColorUtil.changeColor(integer, mContext), integer);
    }
}
