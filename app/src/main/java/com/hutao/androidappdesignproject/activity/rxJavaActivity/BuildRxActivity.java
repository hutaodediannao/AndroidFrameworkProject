package com.hutao.androidappdesignproject.activity.rxJavaActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.hutao.androidappdesignproject.R;
import com.hutao.androidappdesignproject.activity.ToolBarActivity;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;

public class BuildRxActivity extends ToolBarActivity {

    private static final String TAG = "BuildRxActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_build_rx);
    }

    @Override
    public String getToolbarTitleContent() {
        return "创建操作";
    }

    //普通创建方法
    public void create(View view) {
        Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> e) throws Exception {

                for (int i = 0; i < 5; i++) {
                    e.onNext(i);
                }
                e.onComplete();
            }
        }).subscribe(new Observer<Integer>() {
            @Override
            public void onSubscribe(Disposable d) {
                Log.i(TAG, "onSubscribe: ");
                showToast("onSubscribe: Disposable => " + d.isDisposed());
            }

            @Override
            public void onNext(Integer integer) {
                Log.i(TAG, "onNext: " + integer);
                showToast("onNext: " + integer);
            }

            @Override
            public void onError(Throwable e) {
                Log.i(TAG, "onError: " + e.getMessage());
            }

            @Override
            public void onComplete() {
                Log.i(TAG, "onComplete: ");
                showToast("onComplete");
            }
        });
    }

    //直到有观察者订阅时才创建Observable，并且为每个观察者创建一个新的Observable
    public void defer(View view) {
        Observable.defer(new Callable<ObservableSource<String>>() {
            @Override
            public ObservableSource<String> call() throws Exception {
                return new ObservableSource<String>() {
                    @Override
                    public void subscribe(Observer<? super String> observer) {
                        observer.onNext("hello defer");
                    }
                };
            }
        }).subscribe(new Consumer<String>() {
            @Override
            public void accept(String s) throws Exception {
                showToast(s);
            }
        });
    }

    //创建一个不发射任何数据但是正常终止的Observable
    public void empty(View view) {
        Observable.empty()
                .subscribe(new Consumer<Object>() {
                    @Override
                    public void accept(Object o) throws Exception {
                        showToast("hello empty");
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        showToast("error");
                    }
                }, new Action() {
                    @Override
                    public void run() throws Exception {
                        showToast("complete");
                    }
                });
    }

    //将其它种类的对象和数据类型转换为Observable
    public void fromIterable(View view) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            list.add(i);
        }
        Observable.fromIterable(list)
                .forEach(new Consumer<Integer>() {
                    @Override
                    public void accept(Integer integer) throws Exception {
                        showToast(integer + "");
                    }
                });
    }

    //将其它种类的对象和数据类型转换为Observable
    public void fromArray(View view) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            list.add(i);
        }
        Observable.fromArray(1, 2, 3, 4, 5)
                .forEach(new Consumer<Integer>() {
                    @Override
                    public void accept(Integer integer) throws Exception {
                        showToast(integer + "");
                    }
                });
    }

    private Disposable d;

    //创建一个按固定时间间隔发射整数序列的Observable
    public void interval(View view) {
        d = Observable.interval(2, TimeUnit.SECONDS, AndroidSchedulers.mainThread())
                .forEach(new Consumer<Long>() {
                    @Override
                    public void accept(Long aLong) throws Exception {
                        showToast(aLong + "");
                        if (aLong == 5) d.dispose();
                    }
                });
    }

    //创建一个发射指定值的Observable
    public void just(View view) {
        Observable.just("hello just")
                .subscribe(new Consumer<String>() {
                    @Override
                    public void accept(String s) throws Exception {
                        showToast(s);
                    }
                });
    }

    //创建一个发射特定整数序列的Observable
    public void range(View view) {
        Observable.range(3, 5)
                .subscribe(new Consumer<Integer>() {
                    @Override
                    public void accept(Integer integer) throws Exception {
                        showToast(integer + "");
                    }
                });
    }

    /**
     * 创建一个发射特定数据重复多次的Observable
     * RxJava将这个操作符实现为repeat方法。
     * 它不是创建一个Observable，
     * 而是重复发射原始Observable的数据序列，
     * 这个序列或者是无限的，或者通过repeat(n)指定重复次数。
     */
    public void repet(View view) {
        Observable.just(1).repeat(3)//指定发射3次，不指定则无限
                .subscribe(new Consumer<Integer>() {
                    @Override
                    public void accept(Integer integer) throws Exception {
                        showToast(integer + "");
                    }
                });
    }

    public void timer(View view) {
        Observable.timer(3, TimeUnit.SECONDS)
                .observeOn(AndroidSchedulers.mainThread())
//                .subscribeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Long>() {
                    @Override
                    public void accept(Long aLong) throws Exception {
                        showToast(aLong+"");
                        Log.i(TAG, "accept: along ====> " + aLong + Thread.currentThread().getName());
                    }
                });
    }
}
