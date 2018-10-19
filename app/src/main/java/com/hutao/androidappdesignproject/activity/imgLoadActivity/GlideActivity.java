package com.hutao.androidappdesignproject.activity.imgLoadActivity;

import android.os.Bundle;
import android.widget.ImageView;

import com.hutao.androidappdesignproject.R;
import com.hutao.androidappdesignproject.activity.ToolBarActivity;
import com.hutao.androidappdesignproject.util.BitmapUtil;

public class GlideActivity extends ToolBarActivity {

    @Override
    public String getToolbarTitleContent() {
        return "Glide图片加载技术";
    }

    private ImageView iv0, iv1, iv2, iv3;
    private String imgUrl = "http://image.uczzd.cn/1789360754519459295.jpg?id=0&from=export&height=140&width=270";
    private String gifUrl = "http://b-ssl.duitang.com/uploads/item/201806/18/20180618030627_wzd3n.gif";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_glide);

        initView();
        loadImage();
    }

    private void initView() {
        iv0 = findViewById(R.id.iv0);
        iv1 = findViewById(R.id.iv1);
        iv2 = findViewById(R.id.iv2);
        iv3 = findViewById(R.id.iv3);
    }

    private void loadImage() {
        BitmapUtil.loadScreenWidthNetImg(this, imgUrl, iv0);
        BitmapUtil.setRaidusNetImageView(this, imgUrl, iv1, 200, 200);
        BitmapUtil.loadGifResource(gifUrl, this, iv2);
        BitmapUtil.loadImg(this, imgUrl, iv3, 200, 100, 1);

    }
}
