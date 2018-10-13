package com.hutao.androidappdesignproject.util;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.util.Log;

import com.google.gson.Gson;
import com.hutao.androidappdesignproject.BuildConfig;

import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Dispatcher;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;

/**
 * Created by Administrator on 2018/1/7.
 */

public class HttpUtil {

    private static final String TAG = "HttpUtil";
    private static HttpUtil mHttpUtilInstance;

    //默认超时
    private static final long TIME_OUT = 10;
    //缓存文件最大值默认200MB
    private static final long MAX_CACHE_SIZE = 1024 * 1024 * 200;
    //http请求对象
    private OkHttpClient okHttpClient;
    //全局处理子线程和M主线程通信
    private Handler okHttpHandler;
    //实体类解析的gson
    private Gson gson;

    public static HttpUtil getHttpUtilInstance(Context context) {
        if (mHttpUtilInstance == null) {
            synchronized (HttpUtil.class) {
                if (mHttpUtilInstance == null) {
                    mHttpUtilInstance = new HttpUtil(context);
                }
            }
        }
        return mHttpUtilInstance;
    }

    public OkHttpClient getOkHttpClient() {
        return okHttpClient;
    }

    private HttpUtil(Context context) {
        OkHttpClient.Builder builder = new OkHttpClient.Builder()
                .connectTimeout(TIME_OUT, TimeUnit.SECONDS)
                .readTimeout(TIME_OUT, TimeUnit.SECONDS)
                .writeTimeout(TIME_OUT, TimeUnit.SECONDS)
                .cache(new Cache(CacheUtil.getHttpCacheFile(context), MAX_CACHE_SIZE))
                .addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))//拦截器，用于日志的打印
                .retryOnConnectionFailure(true);

        //初始化Handler
        okHttpHandler = new Handler(context.getMainLooper());
        //初始化Gson
        gson = GsonUtil.buildGson();

        if (BuildConfig.DEBUG) {
            builder.addInterceptor(getHttpLoggingInterceptor());
        }

        okHttpClient = builder.build();
    }

    private HttpLoggingInterceptor getHttpLoggingInterceptor() {
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        return httpLoggingInterceptor;
    }

    /**
     * okHttp post异步请求表单提交
     *
     * @param actionUrl 接口地址
     * @param paramsMap 请求参数
     * @param callBack  请求返回数据回调
     * @param <T>       数据泛型
     * @return
     */
    public <T> Call requestPost(String actionUrl, HashMap<String, Object> paramsMap, final Class<T> classT, final ReqCallBack<T> callBack) {
        String url = actionUrl + "?";
        for (String key : paramsMap.keySet()) {
            url += key + "=" + paramsMap.get(key) + "&";
        }

        if (url.endsWith("&")) {
            url = url.substring(0, url.length() - 1);
        }

        Log.i(TAG, "requestPost: url=====> " + url);

        Request request = addHeaders()
                .url(url)
                .tag(actionUrl)
                .build();
        Call call = okHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                failedCallBack("访问失败", callBack);
                Log.e(TAG, e.toString());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (response.isSuccessful()) {
                    String string = response.body().string();
                    L.i("test250", "response ----->" + string);
                    try {
                        T t = gson.fromJson(string, classT);
                        successCallBack(t, callBack);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else {
                    failedCallBack("服务器错误", callBack);
                }
            }
        });
        return call;
    }

    /**
     * 一般post网络请求传递json字符串的格式传参
     *
     * @param actionUrl
     * @param jsonStr
     * @param callBack
     * @param classT
     * @param <T>
     * @return
     */
    public <T> Call requestPost(String actionUrl, String jsonStr, final Class<T> classT, final ReqCallBack<T> callBack) {

        RequestBody body = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), jsonStr);
        Request request = addHeaders()
                .url(actionUrl)
                .post(body)
                .tag(actionUrl)
                .build();
        Call call = okHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                failedCallBack("请求服务器失败", callBack);
                Log.e(TAG, e.toString());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (response.isSuccessful()) {
                    String string = response.body().string();

                    Log.i(TAG, "onResponse: 请求结果为：" + string);

                    try {
                        T t = gson.fromJson(string, classT);
                        successCallBack(t, callBack);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else {
                    failedCallBack("服务器错误", callBack);
                }
            }
        });
        return call;
    }

    /**
     * 一般GET请求
     *
     * @param actionUrl
     * @param callBack
     * @param classT
     * @param <T>
     * @return
     */
    public <T> Call requestGet(String actionUrl, final Class<T> classT, final ReqCallBack<T> callBack) {
        //创建一个Request
        Request request = new Request.Builder()
                .get()
                .url(actionUrl)
                .build();
        //通过client发起请求
        Call call = okHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                failedCallBack("访问失败", callBack);
                L.i(TAG, e.toString());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (response.isSuccessful()) {
                    String string = response.body().string();
                    L.i(TAG, "response ----->" + string);
                    try {
                        T t = gson.fromJson(string, classT);
                        successCallBack(t, callBack);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else {
                    failedCallBack("服务器错误", callBack);
                }
            }
        });

        return call;
    }

    //请求成功
    private <T> void successCallBack(final T t, final ReqCallBack<T> callBack) {
        okHttpHandler.post(new Runnable() {
            @Override
            public void run() {
                if (callBack != null) callBack.onReqSuccess(t);
            }
        });
    }

    //请求失败
    private <T> void failedCallBack(final String errorMsg, final ReqCallBack<T> callBack) {
        okHttpHandler.post(new Runnable() {
            @Override
            public void run() {
                if (callBack != null) callBack.onReqFailed(errorMsg);
            }
        });
    }

    /**
     * 根据tag取消某个网络请求
     */
    public void cancleHttpRequestTask(Call call) {
        if (call != null && !call.isCanceled()) {
            call.cancel();
        }
    }

    /**
     * 取消所有网络请求
     */
    public void cancleAll(Object tag) {
        Dispatcher dispatcher = okHttpClient.dispatcher();
        synchronized (dispatcher) {
            for (Call call : dispatcher.queuedCalls()) {
                if (tag.equals(call.request().tag())) {
                    call.cancel();
                }
            }
            for (Call call : dispatcher.runningCalls()) {
                if (tag.equals(call.request().tag())) {
                    call.cancel();
                }
            }
        }
    }

    /**
     * 统一为请求添加头信息
     */
    private Request.Builder addHeaders() {
        Request.Builder builder = new Request.Builder()
                .addHeader("Connection", "keep-alive")
                .addHeader("platform", "2")
                .addHeader("phoneModel", Build.MODEL)
                .addHeader("systemVersion", Build.VERSION.RELEASE)
                .addHeader("appVersion", "1.1.1");
        return builder;
    }

    /**
     * 网络请求的接口回调
     */
    public interface ReqCallBack<T> {
        /**
         * 响应成功
         */
        void onReqSuccess(T result);

        /**
         * 响应失败
         */
        void onReqFailed(String errorMsg);
    }

}
