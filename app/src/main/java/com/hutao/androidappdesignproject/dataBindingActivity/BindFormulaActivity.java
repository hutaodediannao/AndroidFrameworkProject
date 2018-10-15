package com.hutao.androidappdesignproject.dataBindingActivity;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import com.hutao.androidappdesignproject.R;
import com.hutao.androidappdesignproject.Test;
import com.hutao.androidappdesignproject.activity.ToolBarActivity;
import com.hutao.androidappdesignproject.databinding.ActivityFormulaBinding;
import com.hutao.androidappdesignproject.databinding.ActivityTwoWayBindBinding;
import com.hutao.androidappdesignproject.model.User;

/**
 * 描述: dataBinding中表达式的使用
 * 作者: 胡涛
 * 时间: 2018-10-15 14:34
 */
public class BindFormulaActivity extends ToolBarActivity {

    private View rootView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        rootView = LayoutInflater.from(this).inflate(R.layout.activity_formula, null);
        setContentView(rootView);
        ActivityFormulaBinding bind = DataBindingUtil.bind(rootView);
        User user = new User("胡涛", 28, true);
        bind.setUser(user);
        bind.setContext(this);
        bind.setTest(new Test());
    }

    @Override
    public String getToolbarTitleContent() {
        return "表达式使用";
    }
}
