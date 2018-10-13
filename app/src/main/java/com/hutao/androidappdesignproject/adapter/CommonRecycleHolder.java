package com.hutao.androidappdesignproject.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.hutao.androidappdesignproject.util.ImageLoader;

/**
 * 描述: 万能Holder
 * 作者: 胡涛
 * 时间: 2018-10-11 14:38
 */
public class CommonRecycleHolder extends RecyclerView.ViewHolder {

    private SparseArray<View> mSparseArray;
    private Context mContext;
    public View mConvertView;

    public static CommonRecycleHolder getInstance(Context context, ViewGroup parent, int layoutId) {
        View view = LayoutInflater.from(context).inflate(layoutId, parent, false);
        return new CommonRecycleHolder(view, context);
    }

    private CommonRecycleHolder(View itemView, Context context) {
        super(itemView);
        this.mConvertView = itemView;
        this.mSparseArray = new SparseArray<>();
        this.mContext = context;
    }

    private <T extends View> T getView(int viewId) {
        T t = (T) mSparseArray.get(viewId);
        if (t == null) {
            t = mConvertView.findViewById(viewId);
            mSparseArray.put(viewId, t);
        }
        return t;
    }

    /**
     * 设置TextView
     */
    public CommonRecycleHolder setTextView(int textViewId, String content) {
        TextView tv = getView(textViewId);
        tv.setText(content);
        return this;
    }

    /**
     * 设置CheckBox
     */
    public CommonRecycleHolder setCheckBox(int checkBoxId, boolean checked) {
        CheckBox checkBox = getView(checkBoxId);
        checkBox.setChecked(checked);
        return this;
    }

    /**
     * 加载ImageView网络图片
     */
    public CommonRecycleHolder loadImage(int imageViewId, String imgUrl) {
        ImageView iv = getView(imageViewId);
        ImageLoader.loadImage(iv, imgUrl, mContext);
        return this;
    }


}
