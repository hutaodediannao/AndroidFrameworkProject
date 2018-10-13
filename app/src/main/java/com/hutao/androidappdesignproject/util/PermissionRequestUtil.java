package com.hutao.androidappdesignproject.util;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.provider.Settings;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;

import com.hutao.androidappdesignproject.activity.BaseActivity;

/**
 * 描述: 适配安卓6.0以上的权限工具类
 * 作者: 胡涛
 * 时间 2018/8/11  9:39
 */

public class PermissionRequestUtil {

    private static final int PERMISSION_DENIEG = 1;//权限不足，或者被拒绝的时候
    private static final String PACKAGE_URL_SCHEME = "package:";//权限方案

    /**
     * 请求读写内部存储的权限功能
     */
    public static void requestSystemPermission(int requestCode, String checkSelfPermission, String[] requestPermissions, Activity activity) {
        if (ContextCompat.checkSelfPermission(activity, checkSelfPermission) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(activity, requestPermissions, 1);
        }
    }


    public static void showMissingPermissionDialog(int requestCode, int[] grantResults, final Activity activity) {
        if (requestCode == 1) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                //permission granted

            } else {
                new AlertDialog.Builder(activity)
                        .setTitle("帮助")
                        .setMessage("当前应用缺少必要权限，请点击“设置”-“权限”-打开相应应用所需的所有权限后再次开启本应用")
                        .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                activity.setResult(PERMISSION_DENIEG);//权限不足
                                ((BaseActivity) activity).showToast("没有分享图片权限, 请授权！");
                            }
                        }).setPositiveButton("设置", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //跳到系统应用权限
                        Intent intent = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
                        intent.setData(Uri.parse(PACKAGE_URL_SCHEME + activity.getPackageName()));
                        activity.startActivity(intent);
                    }
                })
                        .setCancelable(false)
                        .create()
                        .show();
            }
        }
    }


}
