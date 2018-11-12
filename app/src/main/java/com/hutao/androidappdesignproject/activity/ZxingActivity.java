package com.hutao.androidappdesignproject.activity;

import android.Manifest;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.google.zxing.WriterException;
import com.hutao.androidappdesignproject.R;
import com.hutao.androidappdesignproject.util.StringUtil;
import com.tbruyelle.rxpermissions2.Permission;
import com.tbruyelle.rxpermissions2.RxPermissions;
import com.yzq.zxinglibrary.android.CaptureActivity;
import com.yzq.zxinglibrary.bean.ZxingConfig;
import com.yzq.zxinglibrary.common.Constant;
import com.yzq.zxinglibrary.encode.CodeCreator;

import io.reactivex.functions.Consumer;

import static com.yzq.zxinglibrary.common.Constant.CODED_CONTENT;

/**
 * 描述: 二维码扫描页面
 * 作者: 胡涛
 * 时间: 2018-11-12 21:17
 */
public class ZxingActivity extends ToolBarActivity {

    private EditText cameraEt, cameraEt2;
    private ImageView camearaIv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zxing);

        camearaIv = findViewById(R.id.camearaIv);
        cameraEt = findViewById(R.id.cameraEt);
        cameraEt2 = findViewById(R.id.cameraEt2);
    }

    @Override
    public String getToolbarTitleContent() {
        return "二维码扫描";
    }

    public static final int REQUEST_CODE_SCAN = 100;

    /**
     * 开始扫描二维码
     */
    public void openCamera(View view) {


        RxPermissions rxPermissions = new RxPermissions(this);
        rxPermissions.requestEach(Manifest.permission.CAMERA)
                .subscribe(new io.reactivex.functions.Consumer<Permission>() {
                    @Override
                    public void accept(Permission permission) throws Exception {
                        if (permission.granted) {
                            // 用户已经同意该权限
//                            showToast("用户已经同意该权限");

                            openCamera();

                        } else if (permission.shouldShowRequestPermissionRationale) {
                            // 用户拒绝了该权限，没有选中『不再询问』（Never ask again）,那么下次再次启动时，还会提示请求权限的对话框
                            showToast("用户拒绝了该权限");
                        } else {
                            // 用户拒绝了该权限，并且选中『不再询问』，提醒用户手动打开权限
                            showToast("权限被拒绝，请在设置里面开启相应权限，若无相应权限会影响使用");
                        }
                    }
                });
    }

    private void openCamera() {
        Intent intent = new Intent(this, CaptureActivity.class);
         /*ZxingConfig是配置类  可以设置是否显示底部布局，闪光灯，相册，是否播放提示音  震动等动能
         * 也可以不传这个参数
         * 不传的话  默认都为默认不震动  其他都为true
         * */

        ZxingConfig config = new ZxingConfig();
        config.setShowbottomLayout(true);//底部布局（包括闪光灯和相册）
        config.setPlayBeep(true);//是否播放提示音
        config.setShake(true);//是否震动
        config.setShowAlbum(true);//是否显示相册
        config.setShowFlashLight(true);//是否显示闪光灯
        intent.putExtra(Constant.INTENT_ZXING_CONFIG, config);
        startActivityForResult(intent, REQUEST_CODE_SCAN);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // 扫描二维码/条码回传
        if (requestCode == REQUEST_CODE_SCAN && resultCode == RESULT_OK) {
            if (data != null) {
                String content = data.getStringExtra(CODED_CONTENT);
                cameraEt.setText("扫描结果为：" + content);
            }
        }
    }

    /**
     * 生成二维码
     */
    public void designResult(View view) {

        String contentEtString = cameraEt2.getText().toString().trim();

        if (StringUtil.isEmpty(contentEtString)) {
            showToast("内容不能为空");
            return;
        }
        Bitmap bitmap = null;
        try {
                    /*
                    * contentEtString：字符串内容
                    * w：图片的宽
                    * h：图片的高
                    * logo：不需要logo的话直接传null
                    * */

            Bitmap logo = BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher);
            bitmap = CodeCreator.createQRCode(contentEtString, 400, 400, logo);
            camearaIv.setImageBitmap(bitmap);
        } catch (WriterException e) {
            e.printStackTrace();
        }
    }

    public void morePermissionTest(View view) {
        new RxPermissions(this).request(
                Manifest.permission.CAMERA
        )
                .subscribe(new Consumer<Boolean>() {
                    @Override
                    public void accept(Boolean aBoolean) throws Exception {
                        if (aBoolean) {
                            //所有权限都开启aBoolean才为true，否则为false
                            showToast("权限已开启");
                            openCamera();
                        } else {
                            showToast("权限被拒绝，请在设置里面开启相应权限，若无相应权限会影响使用");
                        }
                    }
                });
    }
}
