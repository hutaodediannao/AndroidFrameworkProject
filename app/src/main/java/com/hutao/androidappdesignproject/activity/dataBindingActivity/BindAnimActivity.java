package com.hutao.androidappdesignproject.activity.dataBindingActivity;

import android.databinding.DataBindingUtil;
import android.databinding.OnRebindCallback;
import android.databinding.ViewDataBinding;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.os.Bundle;
import android.transition.TransitionManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hutao.androidappdesignproject.R;
import com.hutao.androidappdesignproject.activity.ToolBarActivity;
import com.hutao.androidappdesignproject.databinding.ActivityBindAnimBinding;

/**
 * 描述: dataBinding动画绑定机制
 * 作者: 胡涛
 * 时间: 2018-10-15 17:22
 */
public class BindAnimActivity extends ToolBarActivity {

    private View mRootView;
    private ActivityBindAnimBinding mBinding;


    @Override
    public String getToolbarTitleContent() {
        return "动画绑定机制";
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mRootView = LayoutInflater.from(this).inflate(R.layout.activity_bind_anim, null);
        setContentView(mRootView);

        mBinding = DataBindingUtil.bind(mRootView);
        mBinding.setPresenter(new AnimatorPresenter());
        mBinding.addOnRebindCallback(new OnRebindCallback() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public boolean onPreBind(ViewDataBinding binding) {
                ViewGroup viewGroup = (ViewGroup) binding.getRoot();
                //开启延时位移动画
                TransitionManager.beginDelayedTransition(viewGroup);
                return true;
            }
        });
    }

    public class AnimatorPresenter{
        public void onCheckedChanged(boolean isChecked){
            mBinding.setShowImage(isChecked);
        }
    }

}
