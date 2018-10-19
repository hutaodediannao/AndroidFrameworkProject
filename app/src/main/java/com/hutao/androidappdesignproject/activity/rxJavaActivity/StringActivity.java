package com.hutao.androidappdesignproject.activity.rxJavaActivity;

import android.os.Bundle;
import android.view.View;

import com.hutao.androidappdesignproject.R;
import com.hutao.androidappdesignproject.activity.ToolBarActivity;

import io.reactivex.Observable;
import io.reactivex.Observer;
import rx.observables.StringObservable;

public class StringActivity extends ToolBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_string);
    }

    public void split(View view) {


    }

    public void decode(View view) {



    }

    public void encode(View view) {



    }
}
