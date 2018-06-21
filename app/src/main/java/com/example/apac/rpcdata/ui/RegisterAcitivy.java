package com.example.apac.rpcdata.ui;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.apac.rpcdata.MainActivity;
import com.example.apac.rpcdata.R;
import com.example.apac.rpcdata.utils.AppMD5Util;
import com.example.apac.rpcdata.utils.UserBean;
import com.google.gson.Gson;

import java.io.IOException;

import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class RegisterAcitivy extends AppCompatActivity {

    private EditText tjr_phone;
    private EditText tvpassword;
    private EditText ub_phone;
    private Button btdl;
    private Button btzc;
    private String tjr_phone1;
    private String tvpassword1;
    private String ub_phone1;

    final OkHttpClient client = new OkHttpClient();

    private Handler mHandler = new Handler(){

        @Override
        public void handleMessage(Message msg){
            if(msg.what==1){
                String ReturnMessage = (String) msg.obj;
                Log.i("获取的返回信息",ReturnMessage);
                UserBean userBean = new Gson().fromJson(ReturnMessage, UserBean.class);
                String AA = userBean.getUb_id();
                /***
                 * 在此处可以通过获取到的Msg值来判断
                 * 给出用户提示注册成功 与否，以及判断是否用户名已经存在
                 */

            }

        }

    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_acitivy);
        initView();
        initData();
    }
    private void initData() {
        btzc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(RegisterAcitivy.this, "ss", Toast.LENGTH_SHORT).show();
                tjr_phone1 = tjr_phone.getText().toString();
                tvpassword1 = tvpassword.getText().toString();
                AppMD5Util appMD5Util = new AppMD5Util();
                String s = appMD5Util.MD5Util(tvpassword1);
                ub_phone1 = ub_phone.getText().toString();
                postRequest(tjr_phone1,s,ub_phone1);

            }
        });
    }

    private void initView() {
        tjr_phone = findViewById(R.id.tjr_phone);
        tvpassword = findViewById(R.id.tvpassword);

        ub_phone = findViewById(R.id.ub_phone);
        btdl = findViewById(R.id.btdl);
        btzc = findViewById(R.id.btzc);



    }


    private void postRequest(String tjr_phone1,String tvpassword1,String ub_phone1)  {
        //建立请求表单，添加上传服务器的参数
        RequestBody formBody = new FormBody.Builder()
                .add("tjr_phone",tjr_phone1)
                .add("ud_pwd",tvpassword1)
                .add("ub_phone",ub_phone1)

                .add("sid","")
                .add("index","")
                .add("uo_lat","")
                .add("uo_long","")
                .add("uo_high","")
                .add("ub_id","")
                .add("ud_ol_status","1")


                .build();
        //发起请求
        final Request request = new Request.Builder()
                .url("http://rpc.frps.lchtime.cn/index.php/user/reg?")
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
