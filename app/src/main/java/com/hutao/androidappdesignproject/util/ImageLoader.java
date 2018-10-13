package com.hutao.androidappdesignproject.util;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.hutao.androidappdesignproject.R;

/**
 * Created by hutao on 2018-10-11.
 */

public class ImageLoader {

    private static RequestOptions requestOptions = new RequestOptions()
            .placeholder(R.drawable.ic_insert_photo_black_24dp)
            .error(R.drawable.ic_insert_photo_black_24dp)
            .centerCrop()
            .dontAnimate()
            .diskCacheStrategy(DiskCacheStrategy.AUTOMATIC)
            .skipMemoryCache(false);

    /**
     * 加载图片
     */
    public static void loadImage(ImageView iv, String url, Context context) {
        Glide.with(context)
                .load(url)
                .apply(requestOptions)
                .into(iv);
    }


}
