package com.hutao.androidappdesignproject.activity;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;

import com.hutao.androidappdesignproject.R;
import com.hutao.androidappdesignproject.view.MySurfaceView;
import com.hutao.androidappdesignproject.view.SurfaceViewHandWriting;

/**
 * 描述: SurfaceView-心电图模拟UI
 * 作者: 胡涛
 * 时间: 2019-4-15 9:47
 */
public class SurfaceViewActivity extends ToolBarActivity {

    private MySurfaceView surfaceView;
    private SurfaceViewHandWriting surfaceView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_surface_view);

        setToolbarTitle("SurfaceView控件基本使用原理");
        surfaceView = findViewById(R.id.surfaceView);
        surfaceView2 = findViewById(R.id.surfaceView2);


    }

    public void clear(View view) {
        surfaceView2.clear();
    }
}
