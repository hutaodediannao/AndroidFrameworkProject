package com.hutao.androidappdesignproject.activity;

import android.graphics.Color;
import android.os.Bundle;
import com.hutao.androidappdesignproject.R;

import java.util.ArrayList;
import java.util.List;

import lecho.lib.hellocharts.gesture.ContainerScrollType;
import lecho.lib.hellocharts.gesture.ZoomType;
import lecho.lib.hellocharts.model.Line;
import lecho.lib.hellocharts.model.LineChartData;
import lecho.lib.hellocharts.model.PointValue;
import lecho.lib.hellocharts.view.LineChartView;

/**
 * 描述: 统计图页面UI
 * 作者: 胡涛
 * 时间: 2018-11-13 14
 * 参考地址：https://juejin.im/post/5b3a20da6fb9a024a10d3433
 */
public class ChartsViewActivity extends ToolBarActivity {

    @Override
    public String getToolbarTitleContent() {
        return "统计图UI";
    }

    private LineChartView lineChartView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_charts_view);

        lineChartView = findViewById(R.id.chart);
        lineChartView.setInteractive(true);
        lineChartView.setZoomType(ZoomType.HORIZONTAL);
        lineChartView.setContainerScrollEnabled(true, ContainerScrollType.HORIZONTAL);

        List<PointValue> values = new ArrayList<PointValue>();
        values.add(new PointValue(0, 2));
        values.add(new PointValue(1, 4));
        values.add(new PointValue(2, 3));
        values.add(new PointValue(3, 4));
        values.add(new PointValue(4,5));
        values.add(new PointValue(5, 6));
        values.add(new PointValue(6, 5));
        values.add(new PointValue(7, 4));
        values.add(new PointValue(8, 2));
        values.add(new PointValue(9, 5));
        values.add(new PointValue(10, 1));

        //In most cased you can call data model methods in builder-pattern-like manner.
        Line line = new Line(values)
                .setColor(Color.RED)
                .setCubic(true)
                .setStrokeWidth(5);
        List<Line> lines = new ArrayList<Line>();
        lines.add(line);

        LineChartData data = new LineChartData();
        data.setLines(lines);

        lineChartView.setLineChartData(data);

    }
}
