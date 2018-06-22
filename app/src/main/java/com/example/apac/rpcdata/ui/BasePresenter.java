package com.example.apac.rpcdata.ui;

import android.support.v4.app.FragmentActivity;
import android.widget.Toast;

import com.example.apac.rpcdata.MyApplication;

/**
 * Created by user on 2017/6/7.
 */

public abstract class BasePresenter {

    protected FragmentActivity activity;
    protected MyApplication application;

    public FragmentActivity getActivity() {
        return activity;
    }

    public void setActivity(FragmentActivity activity) {
        this.activity = activity;
        application = (MyApplication) activity.getApplication();
    }

    protected void makeText(final String content) {
        Toast.makeText(getActivity(), content, Toast.LENGTH_SHORT).show();
    }

}
