package com.hutao.androidappdesignproject.activity;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.FragmentTransaction;
import android.os.Bundle;
import android.widget.FrameLayout;

import com.hutao.androidappdesignproject.R;
import com.hutao.androidappdesignproject.activity.ColorActivity.NormalColorActivity;
import com.hutao.androidappdesignproject.activity.dataBindingActivity.BindAnimActivity;
import com.hutao.androidappdesignproject.activity.dataBindingActivity.BindAttActivity;
import com.hutao.androidappdesignproject.activity.dataBindingActivity.BindingListActivity;
import com.hutao.androidappdesignproject.activity.dataBindingActivity.BindDataBaseActivity;
import com.hutao.androidappdesignproject.activity.imgLoadActivity.GlideActivity;
import com.hutao.androidappdesignproject.activity.rxJavaActivity.BooleanActivity;
import com.hutao.androidappdesignproject.activity.rxJavaActivity.BuildRxActivity;
import com.hutao.androidappdesignproject.activity.rxJavaActivity.FilterActivity;
import com.hutao.androidappdesignproject.activity.rxJavaActivity.MathActivity;
import com.hutao.androidappdesignproject.activity.rxJavaActivity.StringActivity;
import com.hutao.androidappdesignproject.activity.rxJavaActivity.TransformActivity;
import com.hutao.androidappdesignproject.activity.helloChartsViewFramework.ChartMainActivity;
import com.hutao.androidappdesignproject.config.Constant;
import com.hutao.androidappdesignproject.activity.dataBindingActivity.BindFormulaActivity;
import com.hutao.androidappdesignproject.activity.dataBindingActivity.BindTwoWayActivity;
import com.hutao.androidappdesignproject.fragment.baseFragment.AbsBaseFragment;
import com.hutao.androidappdesignproject.fragment.uiLib.RefreshFragment;

import java.util.ArrayList;

/**
 * 描述: 点击列表跳转到该页面
 * 作者: 胡涛
 * 时间: 2018-10-12 8:22
 */
public class DetailActivity extends ToolBarActivity {

    private String mTitle;
    private int mTagretPosition;
    private FrameLayout fragmentContainer;
    private static final String TITLE = "title";
    private static final String TARGET_POSITION = "targetPosition";

    public static void startNextActivity(String title, int targetPosition, Context context) {
        Intent intent = new Intent(context, DetailActivity.class);
        intent.putExtra(TITLE, title);
        intent.putExtra(TARGET_POSITION, targetPosition);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        mToolbar.setNavigationIcon(R.drawable.ic_chevron_left_black_24dp);

        parsetIntent();
        initView();
        addFragment();
    }

    private void addFragment() {
        FragmentTransaction transation = getSupportFragmentManager().beginTransaction();
        switch (mTitle) {
            case Constant.TAB_0:
                mTitle = Constant.getTAB_List(Constant.TAB_0).get(mTagretPosition);
                switch (mTagretPosition) {
                    case 0://下拉上啦刷新UI页面
                        transation.add(R.id.fragmentContainer, AbsBaseFragment.newInstance(mTitle, RefreshFragment.class)).commit();
                        break;
                    case 1://图片滑动预览页面(PhotoView+ViewPager)
                        ArrayList<String> imgList = new ArrayList<>();
                        imgList.add("http://image.uczzd.cn/7447670544178288838.jpg?id=0&from=export&height=140&width=270");
                        imgList.add("http://image.uczzd.cn/4948347616431536937.jpg?id=0&from=export&height=140&width=270");
                        imgList.add("http://image.uczzd.cn/661568488638516618.jpg?id=0&from=export");
                        imgList.add("http://image.uczzd.cn/5885051054020649917.jpg?id=0&from=export");
                        imgList.add("http://image.uczzd.cn/4341610512577398639.jpg?id=0&from=export");
                        ImageBrowserActivity.startImageBrowserActivity(imgList, 0, this);
                        finish();
                        break;
                    case 2://X5WebView打开网页
                        WebActivity.startActivity("https://www.baidu.com", this);
                        finish();
                        break;
                    case 3://Tablayout+ViewPager+Fragment滑动框架
                        startNextActivity(TabVpFrmActivity.class);
                        finish();
                        break;
                    case 4:
                        break;
                    case 5:
                        break;
                    case 6://PDF文件浏览器
                        startNextActivity(RemotePDFActivity.class);
                        finish();
                        break;
                    case 7:
                        break;
                    case 8:
                        break;
                    case 9:
                        break;
                    case 10:
                        break;
                    case 11://弹出对话框
                        startNextActivity(DialogActivity.class);
                        finish();
                        break;
                    case 12:
                        break;
                    case 13://九宫格图片选择器
                        startNextActivity(ImgBroswerActivity.class);
                        finish();
                        break;
                    case 14:
                        break;
                    case 15://Card View+阴影效果
                        startNextActivity(CardViewActivity.class);
                        finish();
                        break;
                    case 16://统计图UI
//                        startNextActivity(ChartsViewActivity.class);
                        startNextActivity(ChartMainActivity.class);
                        finish();
                        break;
                    case 17://Zxing扫描二维码
                        startNextActivity(ZxingActivity.class);
                        finish();
                        break;
                    case 18://VLayout布局gtegvrfrgvfrffe
                        startNextActivity(VLayoutActivity.class);
                        finish();
                        break;
                }
                break;
            case Constant.TAB_1://数据库框架
                switch (mTagretPosition) {
                    case 0://原生数据库框架

                        break;
                    case 1://GreenDao框架
                        startNextActivity(DbHelperActivity.class);
                        break;
                    case 2://OrmLite框架

                        break;
                }
                finish();
                break;
            case Constant.TAB_2:
                break;
            case Constant.TAB_3:
                switch (mTagretPosition) {
                    case 0:
                        startNextActivity(GlideActivity.class);
                        break;
                    case 1:

                        break;
                }
                finish();
                break;
            case Constant.TAB_4://RxJava2.0操作API
                switch (mTagretPosition) {
                    case 0://创建操作符
                        startNextActivity(BuildRxActivity.class);
                        break;
                    case 1://变换操作符
                        startNextActivity(TransformActivity.class);
                        break;
                    case 2://过滤
                        startNextActivity(FilterActivity.class);
                        break;
                    case 3://布尔操作
                        startNextActivity(BooleanActivity.class);
                        break;
                    case 4://算术聚合操作
                        startNextActivity(MathActivity.class);
                        break;
                    case 5://String字符串操作
                        startNextActivity(StringActivity.class);
                        break;
                    case 6://背压Backpressure
                        break;
                }
                finish();
                break;
            case Constant.TAB_5:
                switch (mTagretPosition) {
                    case 0://DataBinding数据绑定框架
                        startNextActivity(BindDataBaseActivity.class);
                        break;
                    case 1://双向绑定
                        startNextActivity(BindTwoWayActivity.class);
                        break;
                    case 2://表达式使用
                        startNextActivity(BindFormulaActivity.class);
                        break;
                    case 3://列表绑定
                        startNextActivity(BindingListActivity.class);
                        break;
                    case 4://自定义属性
                        startNextActivity(BindAttActivity.class);
                        break;
                    case 5://动画
                        startNextActivity(BindAnimActivity.class);
                        break;
                }
                finish();
                break;
//            case Constant.TAB_6:
//                break;
            case Constant.TAB_7:
                switch (mTagretPosition) {
                    case 0:
                        startNextActivity(NormalColorActivity.class);
                        break;
                    case 1:
                        break;
                }
                finish();
                break;
            case Constant.TAB_8:
                switch (mTagretPosition) {
                    case 0://6.0权限控制
                        startNextActivity(AndroidNewStyleActivity.class);
                        break;
                    case 1:
                        break;
                    case 2:
                        break;
                    case 3:
                        break;
                    case 4:
                        break;
                }
                finish();
                break;
            case Constant.TAB_9:
                break;
        }

        setToolbarTitle(mTitle);

    }

    private void initView() {
        fragmentContainer = findViewById(R.id.fragmentContainer);
    }

    private void parsetIntent() {
        mTitle = getIntent().getStringExtra(TITLE);
        mTagretPosition = getIntent().getIntExtra(TARGET_POSITION, 0);
    }
}
