package com.hutao.androidappdesignproject.activity;

import android.os.Bundle;

import com.hutao.androidappdesignproject.R;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class GuideActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);


        startNextMainActivity();

    }

    private void startNextMainActivity() {

        Observable.timer(0, TimeUnit.SECONDS, Schedulers.io())
                .subscribeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Long>() {
                    @Override
                    public void accept(Long aLong) throws Exception {
                        startNextActivity(MainActivity.class);
                        finish();
                    }
                });
    }
}
