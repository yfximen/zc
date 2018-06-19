package com.example.apac.rpcdata.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.apac.rpcdata.R;
import com.example.apac.rpcdata.utils.ToastUtil;

import butterknife.BindView;


public class RegisterActivity extends BaseActivity {

     //推介人账号
    @BindView(R.id.et_reproductname)
     EditText reProductName;
    //注册账号
    @BindView(R.id.et_reusername)
    EditText reUserName;
    //注册密码
    @BindView(R.id.et_repassword)
    EditText rePwd;
    //确认注册密码
    @BindView(R.id.et_repasswordok)
    EditText rePwdOk;
    //注册按钮
    @BindView(R.id.tv_registerok)
    TextView tvRegistOk;
    //返回登录
    @BindView(R.id.tv_returnlogin)
    TextView tvReturnLogin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        setContentView(R.layout.activity_register);
        super.onCreate(savedInstanceState);
     tvRegistOk.setOnClickListener(this);
     tvReturnLogin.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        switch (v.getId()){
            case R.id.tv_registerok: //注册按钮

                String reProductNames = reProductName.getText().toString().trim();
                String reUserNames = reUserName.getText().toString().trim();

                String rePwds = rePwd.getText().toString().trim();
                String rePwdOks = rePwdOk.getText().toString().trim();


                if(reProductNames.equals("")||reUserNames.equals("") || rePwds.equals("")||rePwdOks.equals("")){
                    ToastUtil.showToast(mContext , "请完善信息");
                }else if(!rePwds.equals(rePwdOks)){
                    ToastUtil.showToast(mContext , "密码不一致，请重新输入！");

                }



                break;
            case R.id.tv_returnlogin://注册
                Intent intent = new Intent(mContext, LoginAcitivy.class);
                startActivity(intent);
                finish();
                break;



        }


    }
}
