package com.hutao.androidappdesignproject.activity;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.FragmentTransaction;
import android.os.Bundle;
import android.widget.FrameLayout;

import com.hutao.androidappdesignproject.R;
import com.hutao.androidappdesignproject.config.Constant;
import com.hutao.androidappdesignproject.fragment.AbsBaseFragment;
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
                    case 3:
                        break;
                    case 4:
                        break;
                    case 5:
                        break;
                    case 6:
                        break;
                    case 7:
                        break;
                    case 8:
                        break;
                    case 9:
                        break;
                    case 10:
                        break;
                    case 11:
                        break;
                    case 12:
                        break;
                    case 13:
                        break;
                    case 14:
                        break;
                    case 15:
                        break;
                    case 16:
                        break;
                    case 17:
                        break;
                }
                break;
            case Constant.TAB_1:
                break;
            case Constant.TAB_2:
                break;
            case Constant.TAB_3:
                break;
            case Constant.TAB_4:
                break;
            case Constant.TAB_5:
                break;
            case Constant.TAB_6:
                break;
            case Constant.TAB_7:
                break;
            case Constant.TAB_8:
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

    @Override
    String getToolbarTitleContent() {
        return null;
    }
}
