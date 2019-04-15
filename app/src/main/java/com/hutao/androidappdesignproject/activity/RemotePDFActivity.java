package com.hutao.androidappdesignproject.activity;

import android.os.Bundle;
import android.view.View;
import android.webkit.DownloadListener;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;

import com.hutao.androidappdesignproject.R;

import es.voghdev.pdfviewpager.library.RemotePDFViewPager;
import es.voghdev.pdfviewpager.library.adapter.PDFPagerAdapter;
import es.voghdev.pdfviewpager.library.remote.DownloadFile;
import es.voghdev.pdfviewpager.library.util.FileUtil;

/**
 * Created by hutao on 2018-11-14.
 */

/**
 * 描述: PDF在线查看器
 * 作者: 胡涛
 * 时间: 2018-11-14 14:58
 */
public class RemotePDFActivity extends ToolBarActivity implements DownloadFile.Listener {

    private RelativeLayout pdf_root;
    private ProgressBar pb_bar;
    private RemotePDFViewPager remotePDFViewPager;
    private String mUrl = "https://bmob-cdn-21506.b0.upaiyun.com/2018/11/14/4aa61d0c40a0991a8098440dfcbdbc7b.pdf";
    private PDFPagerAdapter adapter;

    @Override
    public String getToolbarTitleContent() {
        return "PDF在线浏览";
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdf_online_show);

        setToolbarTitle("PDFViewPager库-PDF在线查看");
        initView();
        setDownloadListener();
    }

    protected void initView() {
        pdf_root = findViewById(R.id.remote_pdf_root);
        pb_bar = findViewById(R.id.pb_bar);
    }

    /*设置监听*/
    protected void setDownloadListener() {
        final DownloadFile.Listener listener = this;
        remotePDFViewPager = new RemotePDFViewPager(this, mUrl, listener);
        remotePDFViewPager.setId(R.id.pdfViewPager);
    }

    /*加载成功调用*/
    @Override
    public void onSuccess(String url, String destinationPath) {
        pb_bar.setVisibility(View.GONE);
        adapter = new PDFPagerAdapter(this, FileUtil.extractFileNameFromURL(url));
        remotePDFViewPager.setAdapter(adapter);
        updateLayout();
    }

    /*更新视图*/
    private void updateLayout() {
        pdf_root.removeAllViewsInLayout();
        pdf_root.addView(remotePDFViewPager, LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
    }

    /*加载失败调用*/
    @Override
    public void onFailure(Exception e) {
        showToast("数据加载错误");
    }

    @Override
    public void onProgressUpdate(int progress, int total) {
//        showToast(progress*100.0/total + "");

    }
}
