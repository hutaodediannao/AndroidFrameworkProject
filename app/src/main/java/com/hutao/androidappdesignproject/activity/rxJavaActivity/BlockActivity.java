package com.hutao.androidappdesignproject.activity.rxJavaActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.hutao.androidappdesignproject.R;
import com.hutao.androidappdesignproject.activity.ToolBarActivity;

import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class BlockActivity extends ToolBarActivity {

    private static final String TAG = "BlockActivity";

    @Override
    public String getToolbarTitleContent() {
        return "阻塞操作";
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_block);


    }

    public void test0(View view) {


        Observable.just(1, 2, 3, 4)
                .observeOn(Schedulers.io())
                .subscribeOn(Schedulers.io())
                .blockingForEach(new Consumer<Integer>() {
                    @Override
                    public void accept(Integer integer) throws Exception {
                        Thread.sleep((long) (1000 * Math.random() * 10));
                        Log.i(TAG, "accept2: integer ====> " + integer + ", threadName=====>" + Thread.currentThread().getName());
                    }
                });

    }
}
