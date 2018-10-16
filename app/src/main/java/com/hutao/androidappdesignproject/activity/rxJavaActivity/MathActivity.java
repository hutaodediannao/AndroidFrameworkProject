package com.hutao.androidappdesignproject.activity.rxJavaActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.hutao.androidappdesignproject.R;
import com.hutao.androidappdesignproject.activity.ToolBarActivity;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.functions.BiConsumer;

public class MathActivity extends ToolBarActivity {

    private Observable<Integer> ob;
    private static final String TAG = "MathActivity";

    @Override
    public String getToolbarTitleContent() {
        return "算术和聚合操作";
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_math);

       ob =  Observable.fromArray(1, 2, 3, 4);
    }


    public void min(View view) {

    }

    public void max(View view) {

    }

    //Count操作符将一个Observable转换成一个发射单个值的Observable，
    // 这个值表示原始Observable发射的数据的数量。
    public void count(View view) {
        Observable.fromArray(new String[] { "one", "two", "three" })
                .count()
                .subscribe(new BiConsumer<Long, Throwable>() {
                    @Override
                    public void accept(Long aLong, Throwable throwable) throws Exception {
                        showToast(aLong + "");
                    }
                });
    }

    public void sum(View view) {

    }

    public void concat(View view) {

    }
}
