package com.hutao.androidappdesignproject.activity.dataBindingActivity;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import com.hutao.androidappdesignproject.R;
import com.hutao.androidappdesignproject.activity.ToolBarActivity;
import com.hutao.androidappdesignproject.databinding.ActivityDataBindingBaseBinding;
import com.hutao.androidappdesignproject.model.User;

public class BindDataBaseActivity extends ToolBarActivity {

    private View rootView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        rootView = LayoutInflater.from(this).inflate(R.layout.activity_data_binding_base, null);
        setContentView(rootView);

        ActivityDataBindingBaseBinding bind = DataBindingUtil.bind(rootView);
        User user = new User("胡涛", 30, true);
        bind.setUser(user);
        bind.setContext(this);

        setToolbarTitle("DataBinding基本使用");
    }
}
