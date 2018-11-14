package com.hutao.androidappdesignproject.fragment.baseFragment;

import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hutao.androidappdesignproject.activity.BaseActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hutao on 2018-10-11.
 */

public abstract class AbsBaseFragment extends Fragment{

    public View mRootView;
    public static final String ARG_PARAM1 = "param1";
    public static final String ARG_PARAM2 = "param2";
    public String mParam1;
    public List<Parcelable> mParcelables;

    public static AbsBaseFragment newInstance(String param1, Class fragmentCla) {
        AbsBaseFragment fragment = null;
        try {
            fragment = (AbsBaseFragment) fragmentCla.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        fragment.setArguments(args);
        return fragment;
    }

    public static AbsBaseFragment newInstance(ArrayList<Parcelable> parcelables, Class fragmentCla) {
        AbsBaseFragment fragment = null;
        try {
            fragment = (AbsBaseFragment) fragmentCla.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        Bundle args = new Bundle();
        args.putParcelableArrayList(ARG_PARAM2, parcelables);
        fragment.setArguments(args);
        return fragment;
    }

    public String getTitle() {
        return mParam1;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParcelables = getArguments().getParcelableArrayList(ARG_PARAM2);
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        this.mRootView = LayoutInflater.from(getContext()).inflate(getLayout(), null);
        return mRootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView();
        handEvent();
    }

    public <T extends View> T findView(int viewId) {
        return mRootView.findViewById(viewId);
    }

    public void showToast(String toastContent) {
        ((BaseActivity) getActivity()).showToast(toastContent);
    }

    public abstract int getLayout();

    public abstract void initView();

    public abstract void handEvent();

}
