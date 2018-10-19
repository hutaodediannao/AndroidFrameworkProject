package com.hutao.androidappdesignproject.util;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.BitmapImageViewTarget;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.transition.Transition;
import com.hutao.androidappdesignproject.R;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by Administrator on 2018/1/27.
 */

public class BitmapUtil {
    private static final String TAG = "BitmapUtil";

    private static RequestOptions options = //普通图片
            new RequestOptions()
                    .error(R.mipmap.ic_launcher)    //加载错误之后的错误图
                    .placeholder(R.mipmap.ic_launcher)    //加载成功之前占位图
                    .skipMemoryCache(false)    //跳过内存缓存
                    .diskCacheStrategy(DiskCacheStrategy.RESOURCE)    //只缓存最终的图片
                    .priority(Priority.LOW)
                    .centerCrop()
                    .dontAnimate(),
            circleOptions = //圆角图片
                    new RequestOptions()
                            .error(R.mipmap.ic_launcher)    //加载错误之后的错误图
                            .placeholder(R.mipmap.ic_launcher)    //加载成功之前占位图
                            .skipMemoryCache(false)    //跳过内存缓存
                            .diskCacheStrategy(DiskCacheStrategy.RESOURCE)    //只缓存最终的图片
                            .circleCrop()//指定图片的缩放类型为centerCrop （圆形）
                            .dontAnimate();

    //设置一个自定义大小的网络图片
    public static void setNetImageView0(Object o, String imgSrcUrl, ImageView imageView, int dpWidthValue, int dpHeightValue) {
        Context context = null;
        if (o instanceof Activity) {
            context = (Context) o;
        } else if (o instanceof Fragment) {
            context = ((Fragment) o).getContext();
        }
        options.override(dpWidthValue, dpHeightValue);
        options.centerCrop();
//        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        Glide.with(context)
                .asBitmap()
                .load(imgSrcUrl)
                .apply(options)
                .into(imageView);
    }

    //设置一个自定义大小的圆形网络图片
    public static void setCircleNetImageView(Object o, String imgSrcUrl, ImageView imageView, int dpWidthValue, int dpHeightValue) {
        Context context = null;
        if (o instanceof Activity) {
            context = (Activity) o;
        } else if (o instanceof Fragment) {
            context = ((Fragment) o).getContext();
        } else {
            context = (Context) o;
        }

        circleOptions.override(dpWidthValue, dpHeightValue);
        Glide.with(context)
                .asBitmap()
                .load(imgSrcUrl)
                .apply(circleOptions)
                .into(imageView);
    }

    //设置一个自定义大小的圆角网络图片
    public static void setRaidusNetImageView(final Context context, String imgSrcUrl, final ImageView imageView, int dpWidthValue, int dpHeightValue) {
        options.override(DensityUtil.dip2px(context, dpWidthValue), DensityUtil.dip2px(context, dpHeightValue));// 指定加载宽高
        Glide.with(context)
                .asBitmap()
                .load(imgSrcUrl)
                .thumbnail(0.5f)
                .apply(circleOptions)
                .into(new BitmapImageViewTarget(imageView) {
                    @Override
                    protected void setResource(Bitmap resource) {
                        RoundedBitmapDrawable circularBitmapDrawable =
                                RoundedBitmapDrawableFactory.create(context.getResources(), resource);
                        circularBitmapDrawable.setCornerRadius(DensityUtil.dip2px(context, 5));
                        imageView.setImageDrawable(circularBitmapDrawable);
                    }
                });
    }

    //设置一个默认大小的网络图片
    public static void setNetImageView1(String imgSrcUrl, ImageView imageView, Object o) {
        Context context = null;
        if (o instanceof Activity) {
            context = (Context) o;
        } else if (o instanceof Fragment) {
            context = ((Fragment) o).getContext();
        }

        options.override(DensityUtil.dip2px(context, 50), DensityUtil.dip2px(context, 50));
        Glide.with(context)
                .asBitmap()
                .load(imgSrcUrl)
                .apply(options)
                .into(imageView);
    }

    public static void setNetImageView2(String imgSrcUrl, ImageView imageView, Object o) {
        Context context = null;
        if (o instanceof Activity) {
            context = (Context) o;
        } else if (o instanceof Fragment) {
            context = ((Fragment) o).getContext();
        }

        options.centerInside()
                .override(DensityUtil.getScreenWidth(context), DensityUtil.getScreenHeight(context));
        Glide.with(context)
                .asBitmap()
                .load(imgSrcUrl)
                .apply(options)
                .into(imageView);
    }

    //设置一个自定义大小的并且可以自定义加载中和错误图片的网络图片
    public static void setNetImageView(Object o, String imgSrcUrl, ImageView imageView, int defacultImgRes, int errorImgRes, int dpWidthValue, int dpHeightValue) {
        Context context = null;
        if (o instanceof Activity) {
            context = (Context) o;
        } else if (o instanceof Fragment) {
            context = ((Fragment) o).getContext();
        }

        options.override(dpWidthValue, dpHeightValue)
                .error(errorImgRes).placeholder(defacultImgRes);
        Glide.with(context)
                .asBitmap()
                .load(imgSrcUrl)
                .apply(options)
                .into(imageView);
    }

    //设置一个固定大小的本地资源图片
    public static void setLocalResourceImage(int resId, ImageView imageView, Object o, int width, int height) {
        Context context = null;
        if (o instanceof Activity) {
            context = (Context) o;
        } else if (o instanceof Fragment) {
            context = ((Fragment) o).getContext();
        }

        options.override(width, height);    //指定图片的尺寸
        Glide.with(context)
                .asBitmap()
                .load(resId)
                .apply(options)
                .into(imageView);
    }

    /**
     * 设置本地bitmap
     */
    public static void setLocalBitmapImage(Bitmap bitmap, ImageView imageView, Object o, int width, int height) {
        Context context = null;
        if (o instanceof Activity) {
            context = (Context) o;
        } else if (o instanceof Fragment) {
            context = ((Fragment) o).getContext();
        }

        options.override(width, height);    //指定图片的尺寸
        Glide.with(context)
                .asBitmap()
                .load(bitmap)
                .apply(options)
                .into(imageView);
    }

    public static void loadGifResource(String gifSrcUrl, Context context, ImageView iv) {
        Glide.with(context)
                .asGif()
                .load(gifSrcUrl)
                .into(iv);
    }

    public static void loadImg(Context context, String imgSrcUrl, final ImageView imageView, final int width, int height, int listSize) {
        options.override(width, height);    //指定图片的尺寸
        Glide.with(context)
                .asBitmap()
                .load(imgSrcUrl)
                .apply(options)
                .into(imageView);
    }

    public static void loadScreenWidthNetImg(final Context context, String imgUrl, final ImageView iv) {
        RequestOptions options = //普通图片
                new RequestOptions()
                        .error(R.mipmap.ic_launcher)    //加载错误之后的错误图
                        .placeholder(R.mipmap.ic_launcher)    //加载成功之前占位图
                        .skipMemoryCache(false)    //跳过内存缓存
                        .diskCacheStrategy(DiskCacheStrategy.RESOURCE)    //只缓存最终的图片
                        .priority(Priority.HIGH)
                        .dontAnimate();

        Glide.with(context)
                .asBitmap()
                .load(imgUrl)
                .apply(options)
                .into(new SimpleTarget<Bitmap>() {
                    @Override
                    public void onResourceReady(@NonNull Bitmap bitmap, @Nullable Transition<? super Bitmap> transition) {
                        int bitmapWidth = bitmap.getWidth();
                        int bitmapHeight = bitmap.getHeight();
                        float ls = bitmapHeight * 1.0f / bitmapWidth;

                        ViewGroup.LayoutParams lp = iv.getLayoutParams();
                        lp.width = DensityUtil.getScreenWidth(context);
                        lp.height = (int) (lp.width * ls);

                        iv.setLayoutParams(lp);
                        iv.setScaleType(ImageView.ScaleType.CENTER_CROP);
                        iv.setImageBitmap(bitmap);
                    }
                });
    }

    /**
     * 手动回收图片
     *
     * @param iv
     */
    public static void clearImageViewCache(ImageView iv) {
        iv.setImageDrawable(null);
    }

    public static Bitmap compressImage(Bitmap image, int kbSize) {

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        image.compress(Bitmap.CompressFormat.JPEG, 100, baos);//质量压缩方法，这里100表示不压缩，把压缩后的数据存放到baos中
        int options = 100;
        while (baos.toByteArray().length / 1024 > kbSize) {    //循环判断如果压缩后图片是否大于kbSizekb,大于继续压缩
            baos.reset();//重置baos即清空baos
            image.compress(Bitmap.CompressFormat.JPEG, options, baos);//这里压缩options%，把压缩后的数据存放到baos中
            options -= 10;//每次都减少10
        }
        ByteArrayInputStream isBm = new ByteArrayInputStream(baos.toByteArray());//把压缩后的数据baos存放到ByteArrayInputStream中
        Bitmap bitmap = BitmapFactory.decodeStream(isBm, null, null);//把ByteArrayInputStream数据生成图片
        return bitmap;
    }

    /**
     * 通过图片url生成Bitmap对象
     *
     * @param urlpath
     * @return Bitmap
     * 根据图片url获取图片对象
     */
    public static Bitmap getBitMBitmap(String urlpath) {
        Bitmap map = null;
        try {
            URL url = new URL(urlpath);
            URLConnection conn = url.openConnection();
            conn.connect();
            InputStream in;
            in = conn.getInputStream();
            map = BitmapFactory.decodeStream(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return map;
    }
}
