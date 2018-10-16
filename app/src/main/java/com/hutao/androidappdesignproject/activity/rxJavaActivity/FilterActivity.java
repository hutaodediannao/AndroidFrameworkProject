package com.hutao.androidappdesignproject.activity.rxJavaActivity;

import android.os.Bundle;
import android.view.View;

import com.hutao.androidappdesignproject.R;
import com.hutao.androidappdesignproject.activity.ToolBarActivity;

import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;

public class FilterActivity extends ToolBarActivity {

    @Override
    public String getToolbarTitleContent() {
        return "过滤操作";
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filter);
    }

    /**
     * 去重
     *
     * @param view
     */
    public void distinct(View view) {
        Observable.just(1, 2, 3, 4, 3)
                .distinct(new Function<Integer, Integer>() {
                    @Override
                    public Integer apply(Integer integer) throws Exception {
                        return integer;
                    }
                }).subscribe(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) throws Exception {
                showToast(integer + "");
            }
        });
    }

    /**
     * 之发射当前选择的
     *
     * @param view
     */
    public void elementAt(View view) {
        Observable.just(1, 2, 3, 3, 5)
                .elementAt(1)
                .subscribe(new Consumer<Integer>() {
                    @Override
                    public void accept(Integer integer) throws Exception {
                        showToast(integer + "");
                    }
                });
    }

    /**
     * 筛选
     *
     * @param view
     */
    public void filter(View view) {
        Observable.just(1, 2, 2, 3, 4)
                .filter(new Predicate<Integer>() {
                    @Override
                    public boolean test(Integer integer) throws Exception {
                        return integer == 2;
                    }
                }).subscribe(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) throws Exception {
                showToast(integer + "");
            }
        });
    }

    //抑制Observable发射的前N项数据
    public void skip(View view) {
        Observable.just(1, 2, 2, 3)
                .skip(2)
                .subscribe(new Consumer<Integer>() {
                    @Override
                    public void accept(Integer integer) throws Exception {
                        showToast(integer + "");
                    }
                });
    }

    //只发射前面的N项数据
    public void take(View view) {
        Observable.just(1, 2, 2, 3)
                .take(2)
                .subscribe(new Consumer<Integer>() {
                    @Override
                    public void accept(Integer integer) throws Exception {
                        showToast(integer + "");
                    }
                });
    }
}
