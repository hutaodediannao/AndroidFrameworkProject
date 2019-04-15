package com.hutao.androidappdesignproject.activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.bumptech.glide.Glide;
import com.hutao.androidappdesignproject.R;
import com.hutao.androidappdesignproject.util.DensityUtil;
import com.yuyh.library.imgsel.ISNav;
import com.yuyh.library.imgsel.common.ImageLoader;
import com.yuyh.library.imgsel.config.ISCameraConfig;
import com.yuyh.library.imgsel.config.ISListConfig;

import java.util.List;

/**
 * 描述: 图片选择器控件
 * 作者: 胡涛
 * 时间: 2018-11-13 9:34
 */
public class ImgBroswerActivity extends ToolBarActivity {

    private LinearLayout group;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_img_broswer);
        setToolbarTitle("图片选择器");
        group = findViewById(R.id.group);
        // 自定义图片加载器
        ISNav.getInstance().init(new ImageLoader() {
            @Override
            public void displayImage(Context context, String path, ImageView imageView) {
                Glide.with(context).load(path).into(imageView);
            }
        });
    }

    private static final int REQUEST_CAMERA_CODE = 100;
    private static final int REQUEST_LIST_CODE = 101;

    /**
     * 选择图片
     */
    public void openCamera(View view) {
        ISCameraConfig config = new ISCameraConfig.Builder()
                .needCrop(true) // 裁剪
                .cropSize(1, 1, 200, 200)
                .build();

        ISNav.getInstance().toCameraActivity(this, config, REQUEST_CAMERA_CODE);
    }

    public void selectPicture(View view) {
        // 自由配置选项
        ISListConfig config2 = new ISListConfig.Builder()
                // 是否多选, 默认true
                .multiSelect(true)
                // 是否记住上次选中记录, 仅当multiSelect为true的时候配置，默认为true
                .rememberSelected(false)
                // “确定”按钮背景色
                .btnBgColor(Color.TRANSPARENT)
                // “确定”按钮文字颜色
                .btnTextColor(Color.WHITE)
                // 使用沉浸式状态栏
                .statusBarColor(getResources().getColor(R.color.red))
                // 返回图标ResId
                .backResId(android.support.v7.appcompat.R.drawable.abc_ic_ab_back_material)
                // 标题
                .title("选择图片")
                // 标题文字颜色
                .titleColor(Color.WHITE)
                // TitleBar背景色
                .titleBgColor(getResources().getColor(R.color.red))
                // 裁剪大小。needCrop为true的时候配置
                .cropSize(1, 1, 200, 200)
                .needCrop(true)
                // 第一个是否显示相机，默认true
                .needCamera(true)
                // 最大选择图片数量，默认9
                .maxNum(9)
                .build();

        // 跳转到图片选择器
        ISNav.getInstance().toListActivity(this, config2, REQUEST_LIST_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK && data != null) {

            switch (requestCode) {
                case REQUEST_CAMERA_CODE:
                    String path1 = data.getStringExtra("result"); // 图片地址
                    showToast(path1);
                    ImageView iv0 = findViewById(R.id.iv0);
                    com.hutao.androidappdesignproject.util.ImageLoader.loadImage(iv0, path1, ImgBroswerActivity.this);
                    break;
                case REQUEST_LIST_CODE:
                    List<String> pathList = data.getStringArrayListExtra("result");
                    for (String path2 : pathList) {
                        ImageView iv = new ImageView(ImgBroswerActivity.this);
                        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                                DensityUtil.dip2px(ImgBroswerActivity.this, 400),
                                DensityUtil.dip2px(ImgBroswerActivity.this, 300)
                        );
                        group.addView(iv, layoutParams);
                        com.hutao.androidappdesignproject.util.ImageLoader.loadImage(iv, path2, ImgBroswerActivity.this);
                    }
                    break;
            }
        }
    }
}
