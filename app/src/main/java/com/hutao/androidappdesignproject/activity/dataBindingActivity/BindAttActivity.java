package com.hutao.androidappdesignproject.activity.dataBindingActivity;

import android.databinding.BindingAdapter;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.hutao.androidappdesignproject.R;
import com.hutao.androidappdesignproject.activity.ToolBarActivity;
import com.hutao.androidappdesignproject.databinding.ActivityAttrideBinding;
import com.hutao.androidappdesignproject.util.ImageLoader;

public class BindAttActivity extends ToolBarActivity {

    private static final String TAG = "BindAttActivity";

    @Override
    public String getToolbarTitleContent() {
        return "自定义属性绑定";
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        View view = LayoutInflater.from(this).inflate(R.layout.activity_attride, null);
        setContentView(view);

        ActivityAttrideBinding binding = DataBindingUtil.bind(view);
        binding.setData("这是一个展示文字的自定义属性");
        binding.setIsShow(true);
        binding.setUri("http://image.uczzd.cn/3235787961235114812.jpg?id=0&from=export&height=140&width=270");

    }


    //获取自定义属性
    @BindingAdapter("data")
    public static void setData(TextView tv, String data) {
        Log.i(TAG, "setData: xml中绑定的数据为：====》 " + data);
        tv.setText(data);
    }

    @BindingAdapter("isShow")
    public static void setIsShow(View view, Boolean b) {
        if (b == null || !b.booleanValue()) {
            view.setVisibility(View.GONE);
        } else {
            view.setVisibility(View.VISIBLE);
        }
    }

    /**
     * requireAll = false，表示参数不管是否设置完整都调用
     */
    @BindingAdapter(value = "uri", requireAll = false)
    public static void setUri(ImageView view, String url) {
        ImageLoader.loadImage(view, url, view.getContext());
    }

}
