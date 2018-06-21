package com.example.apac.rpcdata.ui;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import com.example.apac.rpcdata.MainActivity;
import com.example.apac.rpcdata.R;
import com.example.apac.rpcdata.bean.LoginBean;
import com.example.apac.rpcdata.utils.ToastUtil;
import com.example.apac.rpcdata.utils.UserBean;
import com.google.gson.Gson;

import java.io.IOException;

import butterknife.BindView;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;


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
    final OkHttpClient client = new OkHttpClient();

    private Handler mHandler = new Handler(){

        @Override
        public void handleMessage(Message msg){
            if(msg.what==1){
                String ReturnMessage = (String) msg.obj;
                Log.i("获取的返回信息",ReturnMessage);
                LoginBean userBean = new Gson().fromJson(ReturnMessage, LoginBean.class);
                 String info = userBean.getResult().getInfo();
                /***
                 * 在此处可以通过获取到的Msg值来判断
                 * 给出用户提示注册成功 与否，以及判断是否用户名已经存在
                 */
                Toast.makeText(LoginAcitivy.this, info, Toast.LENGTH_SHORT).show();

            }

        }

    };

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
                }else {

                      postRequest(username,password);
                      startActivity(new Intent(LoginAcitivy.this,MainActivity.class));
                      finish();
                 }



                break;
            case R.id.tv_register://注册
                Intent intent = new Intent(mContext, RegisterAcitivy.class);
                startActivity(intent);
                break;

        }


    }
    private void postRequest(String username,String password)  {
        //建立请求表单，添加上传服务器的参数
        RequestBody formBody = new FormBody.Builder()


                .add("sid","")
                .add("index","")
                .add("uo_lat","")
                .add("uo_long","")
                .add("uo_high","")
                .add("ub_phone",username)
                .add("ud_pwd",password)


                .build();
        //发起请求
        final Request request = new Request.Builder()
                .url("http://rpc.frps.lchtime.cn/index.php/user/login")
                .post(formBody)
                .build();
        //新建一个线程，用于得到服务器响应的参数
        new Thread(new Runnable() {
            @Override
            public void run() {
                Response response = null;
                try {
                    //回调
                    response = client.newCall(request).execute();
                    if (response.isSuccessful()) {
                        //将服务器响应的参数response.body().string())发送到hanlder中，并更新ui
                        mHandler.obtainMessage(1, response.body().string()).sendToTarget();

                    } else {
                        throw new IOException("Unexpected code:" + response);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();

    }
}
