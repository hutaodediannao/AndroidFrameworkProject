package com.hutao.androidappdesignproject.activity.rxJavaActivity;

import android.os.Bundle;
import android.view.View;

import com.hutao.androidappdesignproject.R;
import com.hutao.androidappdesignproject.activity.ToolBarActivity;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;

public class TransformActivity extends ToolBarActivity {

    @Override
    public String getToolbarTitleContent() {
        return "变换操作";
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transform);
    }

    //flatMapIterable这个变体成对的打包数据，
    // 然后生成Iterable而不是原始数据和生成的Observables，但是处理方式是相同的。
    public void flatMapIterable(View view) {

        List<List<String>> pList = new ArrayList<>();

        List<String> list = new ArrayList<String>();
        list.add("a");
        list.add("b");
        list.add("c");

        pList.add(list);

        Observable.fromIterable(pList)
                .flatMapIterable(new Function<List<String>, Iterable<String>>() {
                    @Override
                    public Iterable<String> apply(List<String> strings) throws Exception {
                        return strings;
                    }
                }).forEach(new Consumer<String>() {
            @Override
            public void accept(String s) throws Exception {
                showToast(s);
            }
        });
    }

    //FlatMap将一个发射数据的Observable变换为多个Observables，
    // 然后将它们发射的数据合并后放进一个单独的Observable
    public void flatMap(View view) {
        Observable.just(1, 2, 3)
                .flatMap(new Function<Integer, ObservableSource<String>>() {
                    @Override
                    public ObservableSource<String> apply(final Integer integer) throws Exception {
                        return new ObservableSource<String>() {
                            @Override
                            public void subscribe(Observer<? super String> observer) {
                                observer.onNext("hello=> " + integer);
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

    //操作符对原始Observable发射的每一项数据应用一个你选择的函数，然后返回一个发射这些结果的Observable。
    public void map(View view) {
        Observable.just(1).map(new Function<Integer, String>() {
            @Override
            public String apply(Integer integer) throws Exception {
                return "hello " + integer;
            }
        });
    }

    public void window(View view) {


    }
}
