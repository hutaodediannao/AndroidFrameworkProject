package com.hutao.androidappdesignproject.util;

import android.content.Context;
import android.os.Environment;

import java.io.File;
import java.io.IOException;

/**
 * 缓存工具类
 * Created by Administrator on 2018/1/7.
 */

public class CacheUtil {

    private static final String HTTP_CACHE_FILE_NAME = "httpFileCache";

    /**
     * http请求缓存文件夹
     */
    public static File getHttpCacheFile(Context context) {
        File httpCacheFile = new File(Environment.getExternalStorageDirectory(), HTTP_CACHE_FILE_NAME);
        if (!httpCacheFile.exists()) {
            try {
                httpCacheFile.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
                httpCacheFile = context.getCacheDir();
            }
        }
        return httpCacheFile;
    }


}
