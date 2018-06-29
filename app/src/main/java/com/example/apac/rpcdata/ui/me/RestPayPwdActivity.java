package com.example.apac.rpcdata.ui.me;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.TextView;

import com.example.apac.rpcdata.R;
import com.example.apac.rpcdata.bean.PayResBean;
import com.example.apac.rpcdata.bean.RegistBean;
import com.example.apac.rpcdata.utils.AppMD5Util;
import com.example.apac.rpcdata.utils.MyOkhttp;
import com.example.apac.rpcdata.utils.Sp;
import com.example.apac.rpcdata.utils.ToastUtil;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import okhttp3.Request;

public class RestPayPwdActivity extends Activity implements View.OnClickListener {

    /**  */
    private EditText mEtLoginpws;
    /**
     * 输入支付密码
     */
    private EditText mEtPasswordPayPwd;
    /**
     * 确认支付密码
     */
    private TextView mTvPayPwd;
    private String info;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        setContentView(R.layout.activity_rest_pay_pwd);
        initView();


    }

    private void initView() {
        mEtLoginpws = (EditText) findViewById(R.id.et_loginpws);
        mEtPasswordPayPwd = (EditText) findViewById(R.id.et_password_payPwd);
        mTvPayPwd = (TextView) findViewById(R.id.tv_pay_pwd);
        mTvPayPwd.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.tv_pay_pwd:
                final Sp inData = Sp.getInData(RestPayPwdActivity.this);
                String userPwd = inData.getUserPwd();

                Map<String,String> map=new HashMap<String, String>();
                String sid = Sp.getInData(RestPayPwdActivity.this).getSid();
                 map.put("sid",sid);
                map.put("index","");
                map.put("uo_lat","");
                map.put("uo_long","");
                map.put("uo_high","");

                AppMD5Util appMD5Util=new AppMD5Util();
                String payPwd = appMD5Util.MD5Util(mEtPasswordPayPwd.getText().toString().trim());
                map.put("ud_pay",payPwd);

                String userPwd1 = Sp.getInData(RestPayPwdActivity.this).getUserPwd();
                Log.i("sid-------",sid+"--"+payPwd+"----"+userPwd1);

                map.put("ud_pwd",userPwd1);

                map.put("action","1");
                //设置支付密码成功
                


                String url="http://rpc.frps.lchtime.cn/index.php/pay/password";

                MyOkhttp.postAsync(url, map, new MyOkhttp.DataCallBack() {
                    @Override
                    public void requestFailure(Request request, IOException e) {

                        ToastUtil.showToast(RestPayPwdActivity.this,request.toString());

                    }

                    @Override
                    public void requestSuccess(String result) throws Exception {
                        Gson gson=new Gson();
                        PayResBean payResBean = gson.fromJson(result, PayResBean.class);
                        info = payResBean.getResult().getInfo();


                        ToastUtil.showToast(RestPayPwdActivity.this, info);
                    }
                });


                break;
        }
    }
}
