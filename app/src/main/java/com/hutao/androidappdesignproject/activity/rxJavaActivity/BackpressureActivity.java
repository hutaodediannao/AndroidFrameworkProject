package com.hutao.androidappdesignproject.activity.rxJavaActivity;

import android.os.Bundle;

import com.hutao.androidappdesignproject.R;
import com.hutao.androidappdesignproject.activity.ToolBarActivity;

public class BackpressureActivity extends ToolBarActivity {

    @Override
    public String getToolbarTitleContent() {
        return "背压";
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_backpressure);







    }
}
