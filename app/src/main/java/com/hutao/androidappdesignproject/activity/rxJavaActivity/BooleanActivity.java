package com.hutao.androidappdesignproject.activity.rxJavaActivity;

import android.os.Bundle;
import android.view.View;

import com.hutao.androidappdesignproject.R;
import com.hutao.androidappdesignproject.activity.ToolBarActivity;

import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Predicate;

public class BooleanActivity extends ToolBarActivity {

    @Override
    public String getToolbarTitleContent() {
        return "布尔操作";
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_boolean);
    }

    //判定是否Observable发射的所有数据都满足某个条件
    public void all(View view) {
        Observable.just(1, 2, 2, 3)
                .all(new Predicate<Integer>() {
                    @Override
                    public boolean test(Integer integer) throws Exception {
                        return integer > 0;
                    }
                }).subscribe(new Consumer<Boolean>() {
            @Override
            public void accept(Boolean aBoolean) throws Exception {
                showToast(aBoolean + "");
            }
        });
    }

    //判定一个Observable是否发射一个特定的值
    public void contains(View view) {
        Observable.just(1, 2, 3, 4, 5)
                .contains(3)
                .subscribe(new Consumer<Boolean>() {
                    @Override
                    public void accept(Boolean aBoolean) throws Exception {
                        showToast(aBoolean + "");
                    }
                });
    }

    //丢弃Observable发射的数据，直到一个指定的条件不成立
    public void skipWhile(View view) {
        Observable.just(1, 2, 3, 3, 4,  5)
                .skipWhile(new Predicate<Integer>() {
                    @Override
                    public boolean test(Integer integer) throws Exception {
                        return integer < 3;
                    }
                }).subscribe(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) throws Exception {
                showToast(integer + "");
            }
        });
    }

    //当第二个Observable发射了一项数据或者终止时，丢弃原始Observable发射的任何数据
    public void takeUntil(View view) {

        Observable.just(1, 2, 3, 3, 4, 5)
                .takeUntil(new Predicate<Integer>() {
                    @Override
                    public boolean test(Integer integer) throws Exception {
                        return integer >1 ;
                    }
                }).subscribe(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) throws Exception {
                showToast(integer + "");
            }
        });
    }

    //发射Observable发射的数据，直到一个指定的条件不成立
    public void takeWhile(View view) {
        Observable.just(1, 2, 3, 3, 4, 5)
                .takeWhile(new Predicate<Integer>() {
                    @Override
                    public boolean test(Integer integer) throws Exception {
                        return integer > 3;
                    }
                }).subscribe(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) throws Exception {
                showToast(integer + "");
            }
        });
    }
}
