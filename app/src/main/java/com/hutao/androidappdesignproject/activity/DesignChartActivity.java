package com.hutao.androidappdesignproject.activity;

import android.os.Bundle;
import com.hutao.androidappdesignproject.R;
import com.hutao.androidappdesignproject.view.LineChartView;

import java.util.HashMap;
import java.util.Map;

/**
 * 作者:胡涛
 * 日期:2019-7-11
 * 时间:22:37
 * 功能:自定义折线统计图
 */
public class DesignChartActivity extends ToolBarActivity {

    @Override
    public String getToolbarTitleContent() {
        return "自定义绘制统计图UI";
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_design_chart);

        LineChartView lineChartView = findViewById(R.id.lineChatView);


        Map<String, String> map = new HashMap<>();
        map.put("1", "200");
        map.put("2", "500");
        map.put("3", "100");
        map.put("4", "800");
        map.put("5", "200");
        map.put("6", "400");
        map.put("7", "300");


        lineChartView.setUpData(map);





    }
}
