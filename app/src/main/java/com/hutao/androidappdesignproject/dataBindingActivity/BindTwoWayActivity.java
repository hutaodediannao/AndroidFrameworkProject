package com.hutao.androidappdesignproject.dataBindingActivity;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import com.hutao.androidappdesignproject.R;
import com.hutao.androidappdesignproject.activity.ToolBarActivity;
import com.hutao.androidappdesignproject.databinding.ActivityTwoWayBindBinding;
import com.hutao.androidappdesignproject.model.User;

/**
 * 描述: dabaBinding实现双向绑定机制
 * 作者: 胡涛
 * 时间: 2018-10-15 14:26
 */
public class BindTwoWayActivity extends ToolBarActivity {

    private View rootView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        rootView = LayoutInflater.from(this).inflate(R.layout.activity_two_way_bind, null);
        setContentView(rootView);
        ActivityTwoWayBindBinding bind = DataBindingUtil.bind(rootView);
        User user = new User("胡涛", 28, true);
        bind.setUser(user);
    }

    @Override
    public String getToolbarTitleContent() {
        return "双向绑定";
    }
}
