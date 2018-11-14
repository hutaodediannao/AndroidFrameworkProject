package com.hutao.androidappdesignproject;

import android.content.Context;

import com.tencent.smtt.sdk.QbSdk;

/**
 * Created by hutao on 2018-10-12.
 */

public class Application extends android.app.Application {

    @Override
    public void onCreate() {
        super.onCreate();

        //初始化webView
        initX5WebView(this);

    }


    private static void initX5WebView(Context context) {
        //搜集本地tbs内核信息并上报服务器，服务器返回结果决定使用哪个内核。
        QbSdk.PreInitCallback cb = new QbSdk.PreInitCallback() {
            @Override
            public void onViewInitFinished(boolean arg0) {
                // TODO Auto-generated method stub
                //x5內核初始化完成的回调，为true表示x5内核加载成功，否则表示x5内核加载失败，会自动切换到系统内核。
            }

            @Override
            public void onCoreInitFinished() {
                // TODO Auto-generated method stub
            }
        };
        //x5内核初始化接口
        QbSdk.initX5Environment(context, cb);
    }


}
