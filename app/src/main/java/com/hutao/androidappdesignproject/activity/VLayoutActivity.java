package com.hutao.androidappdesignproject.activity;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import com.hutao.androidappdesignproject.R;

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
    }

    @Override
    public String getToolbarTitleContent() {
        return "VLayout-Activity";
    }
}
