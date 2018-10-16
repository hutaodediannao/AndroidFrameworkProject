package com.hutao.androidappdesignproject.activity.ColorActivity;

import android.content.ClipboardManager;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.widget.Toast;

import com.hutao.androidappdesignproject.R;
import com.hutao.androidappdesignproject.activity.ToolBarActivity;
import com.hutao.androidappdesignproject.adapter.AbsBaseRecycleAdapter;
import com.hutao.androidappdesignproject.adapter.childAdapter.NormalColorAdapter;
import com.hutao.androidappdesignproject.config.Constant;
import com.hutao.androidappdesignproject.util.ColorUtil;

import java.util.List;

public class NormalColorActivity extends ToolBarActivity {

    private RecyclerView recyclerView;
    private NormalColorAdapter adapter;
    private List<Integer> colorList;

    @Override
    public String getToolbarTitleContent() {
        return "常用颜色";
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        recyclerView = (RecyclerView) LayoutInflater.from(this).inflate(R.layout.activity_normal_color, null);
        setContentView(recyclerView);

        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        colorList = Constant.getColors();
        adapter = new NormalColorAdapter(this, colorList);
        recyclerView.setAdapter(adapter);

        adapter.setOnItemClickListener(new AbsBaseRecycleAdapter.OnItemClickListener<Integer>() {
            @Override
            public void clickItem(int position, Integer integer) {
                // 从API11开始android推荐使用android.content.ClipboardManager
                // 为了兼容低版本我们这里使用旧版的android.text.ClipboardManager，虽然提示deprecated，但不影响使用。
                ClipboardManager cm = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                // 将文本内容放到系统剪贴板里。
                cm.setText(ColorUtil.changeColor(integer, NormalColorActivity.this));
                Toast.makeText(NormalColorActivity.this, "复制成功!", Toast.LENGTH_LONG).show();
            }
        });
    }
}
