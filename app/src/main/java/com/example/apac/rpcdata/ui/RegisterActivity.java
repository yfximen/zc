package com.example.apac.rpcdata.ui;


import android.content.Intent;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.example.apac.rpcdata.R;
 import com.example.apac.rpcdata.base.BaseTwoActivity;
import com.example.apac.rpcdata.bean.RegisterBean;
import com.example.apac.rpcdata.presenter.RegsitPresenter;

import butterknife.BindView;
import butterknife.OnClick;


public class RegisterActivity extends BaseTwoActivity<RegsitPresenter> implements Iview{

    @BindView(R.id.tv_registerok)
    Button tv_registerok;

     @BindView(R.id.tv_returnlogin)
     Button tv_returnlogin;


    @Override
    protected int getViewID() {
        return R.layout.activity_register;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {

    }

    @Override
    protected RegsitPresenter getPersenter() {
        return null;
    }

    @OnClick(R.id.tv_registerok)
    public void onViewRegistOk() {
        tv_registerok.setText("我被点击了");

     }
    @OnClick(R.id.tv_returnlogin)
    public void onViewLogin() {
        startActivity(new Intent(RegisterActivity.this,LoginAcitivy.class));
        finish();
        tv_returnlogin.setText("我被点击了");

    }

    @Override
    public void onFailed(String str) {



    }

    @Override
    public void onSuccess(RegisterBean registerBean) {

    }
}
