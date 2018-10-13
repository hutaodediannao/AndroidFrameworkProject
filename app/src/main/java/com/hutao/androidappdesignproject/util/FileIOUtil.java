package com.hutao.androidappdesignproject.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/3/6.
 */

public class FileIOUtil {

    private static final String CACHE_DIR = Environment.getExternalStorageDirectory() + "/jiangGoCaches/images";// 缓存文件夹
    //    public static final String CACHE_SHARE_IMG_DIR = Environment.getExternalStoragePublicDirectory(DIRECTORY_DCIM).getPath();// 缓存文件夹
    public static final String CACHE_SHARE_IMG_DIR = Environment.getExternalStorageDirectory().getAbsolutePath() + "/jiangGoCacheShareImgs";// 缓存文件夹

    private static FileIOUtil fileIOUtilInstance;
    private Context mContext;

    public static FileIOUtil getFileIOUtilInstance() {
        if (fileIOUtilInstance == null) {
            synchronized (FileIOUtil.class) {
                if (fileIOUtilInstance == null) {
                    fileIOUtilInstance = new FileIOUtil();
                }
            }
        }
        return fileIOUtilInstance;
    }

    private FileIOUtil() {
    }

    /**
     * 判断sdcard是否挂载
     *
     * @return
     */
    public static boolean isMounted() {
        String state = Environment.getExternalStorageState();
        return state.equals(Environment.MEDIA_MOUNTED);
    }

    /**
     * 获取sdcard的根目录
     *
     * @return
     */
    public static String getSDCARDDir() {
        return Environment.getExternalStorageDirectory().getAbsolutePath();
    }

    /**
     * 存储图片一
     *
     * @param url  ： 图片的http网络地址
     * @param data
     * @throws IOException
     */
    public void saveImage(String url, byte[] data) throws IOException {
        // 1. 判断是否有sdcard
        if (!isMounted()) {
            return;
        }
        // 2. 判断是否有缓存的文件夹
        File dir = new File(CACHE_DIR);
        if (!dir.exists()) {
            dir.mkdirs();// 多层文件夹
        }
        // 3. 存储图片到sdcard
        File file = new File(dir, getFilename(url));
        FileOutputStream fos = new FileOutputStream(file);

        fos.write(data);
        fos.close();
    }


    /**
     * 读取某个文件夹里面的图片
     */
    public List<File> readLocalImgListForDirs(String dirsPath) {
        List<File> imgPathList = new ArrayList<>();
        File dirs = new File(dirsPath);
        if (!dirs.exists()) return imgPathList;
        if (dirs.exists()) {
            for (File imgFile : dirs.listFiles()) {
                if (isPicture(imgFile.getName())) imgPathList.add(imgFile);
            }
        }
        return imgPathList;
    }

    /**
     * 获取图片名
     */
    public static String getFilename(String url) {
        String name = System.currentTimeMillis() + ".jpg";

        return name;
    }

    /**
     * 读图片
     */
    public static Bitmap readImage(String url, String dirPath) {
        // 判断是否有sdcard
        if (!isMounted()) {
            return null;
        }
        File file = new File(dirPath, getFilename(url));
        if (file.exists()) {
            // file->bitmap
            return BitmapFactory.decodeFile(file.getAbsolutePath());
        }
        return null;
    }

    /**
     * 清空缓存目录
     */
    public void clearCaches(String dirPath) {
        File dir = new File(dirPath);
        if (dir.exists()) {
            File[] allfiles = dir.listFiles();
            if (null != allfiles)
                for (File file : allfiles) {
                    if (file.exists()) file.delete();
                }
        } else {
            boolean isMakeOk = dir.mkdirs();
            ToastUtil.showToast(mContext, isMakeOk + "", Toast.LENGTH_LONG);
        }
    }

    public interface SaveImgCallback {
        void dowloadOk(int dowloadProgress);
    }

    private SaveImgCallback mSaveImgCallback;

    public void setSaveImgCallback(SaveImgCallback saveImgCallback) {
        this.mSaveImgCallback = saveImgCallback;
    }

    public static boolean isPicture(String fileName) {
        if (StringUtil.isEmpty(fileName)) return false;
        else if (fileName.endsWith(".png") || fileName.endsWith(".jpg") || fileName.endsWith(".JPEG") || fileName.endsWith(".gif") ||
                fileName.endsWith(".bmp") || fileName.endsWith(".tif") || fileName.endsWith(".tiff"))
            return true;
        return false;
    }
}
