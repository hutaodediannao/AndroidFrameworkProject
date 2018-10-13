package com.hutao.androidappdesignproject.util;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * 描述: gson解析工具类
 * 作者: 胡涛
 * 时间: 2018/7/24 8:43
 */
public class GsonUtil {

    private static Gson gson;

    public static Gson buildGson() {
        if (gson == null) {
            gson = new GsonBuilder()
                    .registerTypeAdapter(int.class, new IntegerDefault0Adapter())
                    .create();
        }

        return gson;
    }


}
