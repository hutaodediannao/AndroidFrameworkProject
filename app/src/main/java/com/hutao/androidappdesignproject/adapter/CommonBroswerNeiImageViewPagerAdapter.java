package com.hutao.androidappdesignproject.adapter;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bm.library.PhotoView;
import com.hutao.androidappdesignproject.util.BitmapUtil;

import java.util.List;

/**
 * Created by Administrator on 2018/1/28.
 */

public class CommonBroswerNeiImageViewPagerAdapter extends PagerAdapter {

    private List<String> mImageSrcUrl;
    private Context mContext;

    public CommonBroswerNeiImageViewPagerAdapter(List<String> imageSrcUrl, Context context) {
        this.mImageSrcUrl = imageSrcUrl;
        this.mContext = context;
    }

    @Override
    public int getCount() {
        return mImageSrcUrl.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        ViewPager viewPager = (ViewPager) container;
        PhotoView photoView = new PhotoView(mContext);
        photoView.enable();
        photoView.setMaxScale(3.0f);
        photoView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        photoView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mContext instanceof Activity) {
                    ((Activity) mContext).finish();
                }
            }
        });
        BitmapUtil.setNetImageView2( mImageSrcUrl.get(position), photoView,mContext);
        viewPager.addView(photoView);
        return photoView;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }
}
