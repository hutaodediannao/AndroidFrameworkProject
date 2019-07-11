package com.hutao.androidappdesignproject.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import com.hutao.androidappdesignproject.R;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 作者:胡涛
 * 日期:2019-7-11
 * 时间:22:44
 * 功能:折线图自定义绘制
 */
public class LineChartView extends View {

    //最大的Y轴值
    private int mMaxYv = 1000;
    //Y轴数据
    private String[] mYArray = {
            "尾段",
            "后段",
            "中段",
            "前段",
            "头段",
            "期号"
    };


    public LineChartView(Context context) {
        this(context, null);
    }

    public LineChartView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public LineChartView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.LineChartView);
        typedArray.recycle();
        initPaint();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //绘制灰白相间的条纹
        drawRangeArray(canvas);
        //绘制X轴的文字
        drawXText(canvas);
        //绘制线条
        drawDataLine(canvas);


    }

    private Paint mGrayPaint, mWhitePaint, textPaint, linePaint, radiusPaing;

    private void initPaint() {
        mGrayPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mGrayPaint.setColor(getResources().getColor(R.color.lightgrey));
        mGrayPaint.setStyle(Paint.Style.FILL);
        mGrayPaint.setAntiAlias(true);
        mGrayPaint.setStrokeCap(Paint.Cap.ROUND);
        mGrayPaint.setStrokeWidth(10);

        mWhitePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mWhitePaint.setColor(getResources().getColor(R.color.white));
        mWhitePaint.setStyle(Paint.Style.FILL);

        textPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        textPaint.setColor(getResources().getColor(R.color.black));
        textPaint.setStyle(Paint.Style.FILL);
        textPaint.setAntiAlias(true);
        textPaint.setStrokeCap(Paint.Cap.ROUND);
        textPaint.setStrokeWidth(1);
        textPaint.setTextSize(getResources().getDimension(R.dimen._14sp));

        linePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        linePaint.setColor(getResources().getColor(R.color.orangered));
        linePaint.setStyle(Paint.Style.STROKE);
        linePaint.setAntiAlias(true);
        linePaint.setStrokeCap(Paint.Cap.ROUND);
        linePaint.setStrokeWidth(5f);
        linePaint.setTextSize(getResources().getDimension(R.dimen._14sp));

        radiusPaing = new Paint(Paint.ANTI_ALIAS_FLAG);
        radiusPaing.setColor(getResources().getColor(R.color.orangered));
        radiusPaing.setStyle(Paint.Style.FILL);
        radiusPaing.setAntiAlias(true);
        radiusPaing.setStrokeCap(Paint.Cap.ROUND);
        radiusPaing.setStrokeWidth(5f);
        radiusPaing.setTextSize(getResources().getDimension(R.dimen._14sp));
    }

    int left = 100;
    private int mLimitXValue = 100;

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        mLimitXValue = (getMeasuredWidth() - left) / list.size();
    }

    /**
     * 绘制灰白相间的条纹
     *
     * @param canvas
     */
    private void drawRangeArray(Canvas canvas) {
        int height = getMeasuredHeight();
        int limitHeight = height / mYArray.length;
        for (int i = 0; i < mYArray.length; i++) {
            int result = i % 2;
            canvas.drawText(mYArray[i], left / 4, limitHeight / 2 + limitHeight * i, textPaint);
            if (i < mYArray.length - 1) {
                canvas.drawRect(left, limitHeight * i, getMeasuredWidth(),
                        limitHeight * (i + 1), result == 0 ? mGrayPaint : mWhitePaint);
            }
        }
    }

    //X周线数据
    private List<String> list = Arrays.asList("1", "2", "3", "4", "5", "6", "7");

    /**
     * 绘制X轴横向坐标轴的文字
     *
     * @param canvas
     */
    private void drawXText(Canvas canvas) {
        int height = getMeasuredHeight();
        int limitHeight = height / mYArray.length;
        for (int i = 0; i < list.size(); i++) {
            canvas.drawText(list.get(i), left + mLimitXValue / 2 + mLimitXValue * (i),
                    limitHeight / 2 + limitHeight * (mYArray.length - 1), textPaint);
        }
    }

    private Map<String, String> dataMap = new HashMap<>();

    public void setUpData(Map<String, String> dataMap) {
        this.dataMap = dataMap;
        this.postInvalidate();
    }

    /**
     * 绘制折线数据
     *
     * @param canvas
     */
    private void drawDataLine(Canvas canvas) {
        Path path = new Path();
        for (int i = 0; i < dataMap.size(); i++) {
            int yValue = (mMaxYv*5/6 - Integer.parseInt(dataMap.get(list.get(i)))) * (getMeasuredHeight()*5/6) / (mMaxYv*5/6);
            if (i == 0) {
                path.moveTo(left + mLimitXValue / 2 + mLimitXValue * (i),
                        yValue);
            } else if (i < dataMap.size() - 1) {
                path.lineTo(left + mLimitXValue / 2 + mLimitXValue * (i),
                        yValue);
            } else {
                path.lineTo(left + mLimitXValue / 2 + mLimitXValue * (i),
                        yValue);
            }
            canvas.drawCircle(left + mLimitXValue / 2 + mLimitXValue * (i),
                    yValue, 5, linePaint);
        }
        canvas.drawPath(path, linePaint);
    }

}
