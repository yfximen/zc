package com.example.apac.rpcdata.ui.me;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import com.example.apac.rpcdata.R;
import com.example.apac.rpcdata.bean.AddConsigeBean;
import com.example.apac.rpcdata.bean.AddressBean;
import com.example.apac.rpcdata.ui.MyActivity;
import com.example.apac.rpcdata.utils.MyOkhttp;
import com.example.apac.rpcdata.utils.Sp;
import com.example.apac.rpcdata.utils.ToastUtil;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import okhttp3.Request;

public class AddressActivity extends Activity implements View.OnClickListener {


    /**  */
    private EditText mRessUser;
    /**
     * 确认6位密码
     */
    private EditText ress_phone;
    /**  */
    private EditText mRessProvince;
    /**  */
    private EditText mRessCity;
    /**  */
    private EditText mRessAddress;
    /**  */
    private EditText mRessListress;
    /**  */
    private EditText mRessMail;
    /**
     * 默认发送地址
     */
    private RadioButton mDefaults;
    /**
     * 非默认地址
     */
    private RadioButton mDefaultNo;
    /**
     * 添加地址信息
     */
    private TextView mTvAddress;
    private String etRessProvince;
    private String etRessCity;
    private String etRessAddress;
    private String etRessListress;
    private String etRessPhone;
    private String etRessUser;
    private ImageView mBackMyadd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        setContentView(R.layout.activity_address);
        initView();


    }


    private void initView() {
        mRessUser = (EditText) findViewById(R.id.ress_user);
        ress_phone = (EditText) findViewById(R.id.ress_phone);
        mRessProvince = (EditText) findViewById(R.id.ress_province);
        mRessCity = (EditText) findViewById(R.id.ress_city);
        mRessAddress = (EditText) findViewById(R.id.ress_address);

        mRessListress = (EditText) findViewById(R.id.ress_listress);
        mDefaults = (RadioButton) findViewById(R.id.defaults);
        mDefaultNo = (RadioButton) findViewById(R.id.default_no);
        mTvAddress = (TextView) findViewById(R.id.tv_address);
        mTvAddress.setOnClickListener(this);
        mDefaults.setOnClickListener(this);
        mDefaultNo.setOnClickListener(this);
        mBackMyadd = (ImageView) findViewById(R.id.back_myadd);
        mBackMyadd.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.tv_address:
                ToastUtil.showToast(this, "sssss");
                etRessProvince = mRessProvince.getText().toString().trim();
                etRessCity = mRessCity.getText().toString().trim();
                etRessAddress = mRessAddress.getText().toString().trim();
                etRessListress = mRessListress.getText().toString().trim();
                etRessPhone = ress_phone.getText().toString().trim();
                etRessUser = mRessUser.getText().toString().trim();
                if (etRessProvince.equals("") || etRessCity.equals("") || etRessAddress.equals("") || etRessListress.equals("") || etRessPhone.equals("") || etRessUser.equals("")) {

                    return;


                } else {

                    Map<String, String> map = new HashMap<String, String>();
                    String sid = Sp.getInData(AddressActivity.this).getSid();
                    map.put("sid", sid);
                    Log.i("addressSid---", sid);
                    map.put("index", "");
                    map.put("uo_lat", "");
                    map.put("uo_long", "");
                    map.put("uo_high", "");

                    //判断是否是添加删除编辑
                    map.put("type", "1");
                    //json
                    Map<String, String> list_json = new HashMap<String, String>();

                    List<AddressBean> addresslist = new ArrayList<AddressBean>();


                    AddressBean addressBean = new AddressBean(etRessProvince, etRessCity, etRessAddress, etRessListress, etRessUser, etRessPhone, "");
                    addresslist.add(addressBean);
                    Gson gson = new Gson();
                    String jsonlist = gson.toJson(addresslist);
                    String substring = jsonlist.substring(1, jsonlist.length());

                    String jsonremove = substring.substring(0, substring.length() - 1);

                    Log.i("json-----", jsonremove);


                    map.put("user_address", jsonremove);
                    if (mDefaults.isChecked()) {
                        //判断是否是默认地址
                        map.put("ua_status", "1");

                    } else if (mDefaultNo.isChecked()) {

                        map.put("ua_status", "0");

                    }


                    String url = "http://rpc.frps.lchtime.cn/index.php/user/saddr";

                    MyOkhttp.postAsync(url, map, new MyOkhttp.DataCallBack() {
                        @Override
                        public void requestFailure(Request request, IOException e) {

                            ToastUtil.showToast(AddressActivity.this, request.toString());

                        }

                        @Override
                        public void requestSuccess(String result) throws Exception {
                            Gson gson = new Gson();
                            AddConsigeBean consigeBean = gson.fromJson(result, AddConsigeBean.class);
                            String info = consigeBean.getResult().getInfo();
                            ToastUtil.showToast(AddressActivity.this, info);


                        }
                    });

                }
                break;

            case R.id.back_myadd:
                startActivity(new Intent(AddressActivity.this, AddConsing.class));
                finish();
                break;
        }
    }
}
