package com.hutao.androidappdesignproject.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.widget.TextView;

import com.hutao.androidappdesignproject.R;
import com.hutao.androidappdesignproject.adapter.CommonBroswerNeiImageViewPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * 图片浏览公共的页面
 */
public class ImageBrowserActivity extends ToolBarActivity {

    public static final String IMAGE_LIST = "imageList";
    public static final String CURRENT_INDEX = "currentIndex";
    private ViewPager viewPager;
    private CommonBroswerNeiImageViewPagerAdapter mCommonViewPagerAdapter;
    private List<String> mImagSrcUrlList;//网络图片地址
    private int mCurrentIndex = 0;//当前传递过来的下标位置

    public static void startImageBrowserActivity(ArrayList<String> imagSrcUrlList, int currentIndex, Context context) {
        Intent intent = new Intent(context, ImageBrowserActivity.class);
        intent.putStringArrayListExtra(IMAGE_LIST, imagSrcUrlList);
        intent.putExtra(CURRENT_INDEX, currentIndex);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_browser);

        setToolbarNavigationIcon(R.drawable.ic_chevron_left_black_24dp);
        parseIntent();
        initView();
        setAdapter();
        setListener();
    }

    private void setListener() {
        viewPager.addOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                mCurrentIndex = position + 1;
                setToolbarTitle(mCurrentIndex + "/" + mImagSrcUrlList.size());
            }
        });
    }

    private void setAdapter() {
        setToolbarTitle((mCurrentIndex + 1) + "/" + mImagSrcUrlList.size());
        mCommonViewPagerAdapter = new CommonBroswerNeiImageViewPagerAdapter(mImagSrcUrlList, this);
        viewPager.setAdapter(mCommonViewPagerAdapter);
        viewPager.setCurrentItem(mCurrentIndex);
    }

    private void initView() {
        viewPager = findViewById(R.id.vp);
    }

    private void parseIntent() {
        if (getIntent().getStringArrayListExtra(IMAGE_LIST) == null) return;
        this.mImagSrcUrlList = getIntent().getStringArrayListExtra(IMAGE_LIST);
        this.mCurrentIndex = getIntent().getIntExtra(CURRENT_INDEX, 0);
    }
}
