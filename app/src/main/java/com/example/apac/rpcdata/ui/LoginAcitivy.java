package com.example.apac.rpcdata.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;


import com.example.apac.rpcdata.MainActivity;
import com.example.apac.rpcdata.R;
import com.example.apac.rpcdata.utils.ToastUtil;

import butterknife.BindView;


/**
 * 登录模块
 */
public class LoginAcitivy extends BaseActivity {
    @BindView(R.id.et_username)
    EditText mUserNameEt;
    @BindView(R.id.et_password)
    EditText mPasswordEt;

    @BindView(R.id.tv_login)
    TextView mLoginTv;
    @BindView(R.id.tv_register)
    TextView mRegisterTv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_login_acitivy);
        super.onCreate(savedInstanceState);

        mLoginTv.setOnClickListener(this);
        mRegisterTv.setOnClickListener(this);



    }



    @Override
    public void onClick(View v) {
        super.onClick(v);

        switch (v.getId()){
            case R.id.tv_login: //登录

                String username = mUserNameEt.getText().toString().trim();
                String password = mPasswordEt.getText().toString().trim();
                if(username.equals("") || password.equals("")){
                    ToastUtil.showToast(mContext , "请完善信息");
                }else if(username.equals("1") && password.equals("1")){
                    Intent intent = new Intent(mContext, MainActivity.class);
                    startActivity(intent);
                    finish();
                }else{
                    ToastUtil.showToast(mContext , "账号密码错误");
                }



                break;
            case R.id.tv_register://注册
                Intent intent = new Intent(mContext, RegisterAcitivy.class);
                startActivity(intent);
                break;

        }


    }
}
