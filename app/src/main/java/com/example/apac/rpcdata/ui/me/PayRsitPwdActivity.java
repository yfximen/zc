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
import com.example.apac.rpcdata.utils.AppMD5Util;
import com.example.apac.rpcdata.utils.MyOkhttp;
import com.example.apac.rpcdata.utils.Sp;
import com.example.apac.rpcdata.utils.ToastUtil;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import okhttp3.Request;

/**
 * 修改支付密码
 */

public class PayRsitPwdActivity extends Activity implements View.OnClickListener {

    /**  */
    private EditText mEtLoginrsi;
    /**
     * 输入支付密码
     */
    private EditText mEtPasswordRsi;
    /**
     * 确认修改密码
     */
    private TextView mTvPayRsi;
    private String info;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        setContentView(R.layout.activity_pay_rsit_pwd);
        initView();
    }

    private void initView() {
        mEtLoginrsi = (EditText) findViewById(R.id.et_loginrsi);
        mEtPasswordRsi = (EditText) findViewById(R.id.et_password_rsi);
        mTvPayRsi = (TextView) findViewById(R.id.tv_pay_rsi);
        mTvPayRsi.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.tv_pay_rsi:

                final Sp inData = Sp.getInData(PayRsitPwdActivity.this);
                String userPwd = inData.getUserPwd();

                Map<String,String> map=new HashMap<String, String>();
                String sid = Sp.getInData(PayRsitPwdActivity.this).getSid();
                map.put("sid",sid);
                map.put("index","");
                map.put("uo_lat","");
                map.put("uo_long","");
                map.put("uo_high","");

                AppMD5Util appMD5Util=new AppMD5Util();
                String payPwd = appMD5Util.MD5Util(mEtPasswordRsi.getText().toString().trim());
                map.put("ud_pay",payPwd);

                String userPwd1 = Sp.getInData(PayRsitPwdActivity.this).getUserPwd();
                Log.i("sid-------",sid+"--"+payPwd+"----"+userPwd1);

                map.put("ud_pwd",userPwd1);

                map.put("action","2");
                //修改支付密码成功



                String url="http://rpc.frps.lchtime.cn/index.php/pay/password";

                MyOkhttp.postAsync(url, map, new MyOkhttp.DataCallBack() {
                    @Override
                    public void requestFailure(Request request, IOException e) {

                        ToastUtil.showToast(PayRsitPwdActivity.this,request.toString());

                    }

                    @Override
                    public void requestSuccess(String result) throws Exception {
                        Gson gson=new Gson();
                        PayResBean payResBean = gson.fromJson(result, PayResBean.class);
                        info = payResBean.getResult().getInfo();


                        ToastUtil.showToast(PayRsitPwdActivity.this, info);
                    }
                });



                break;
        }
    }
}
