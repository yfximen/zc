package com.example.apac.rpcdata.ui.me;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import com.example.apac.rpcdata.R;
import com.example.apac.rpcdata.bean.AddConsigeBean;
import com.example.apac.rpcdata.bean.AddressBean;
import com.example.apac.rpcdata.bean.GaddrBean;
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

public class CpmpileAdd extends Activity implements View.OnClickListener {

    /**
     * 标题
     */
    private TextView mTitle;
    /**
     * 添加地址
     */
    private TextView mTitleadd;
    /**  */
    private EditText mRessUserComp;
    private EditText mRessPhoneComp;
    /**  */
    private EditText mRessProvinceComp;
    /**  */
    private EditText mRessCityComp;
    /**  */
    private EditText mRessAddressComp;
    /**  */
    private EditText mRessListressComp;
    /**
     * 默认发送地址
     */
    private RadioButton mDefaults;
    /**
     * 非默认地址
     */
    private RadioButton mDefaultNo;
    /**
     * 删除
     */
    private TextView mTvAddressComp;
    private String ua_sf;
    private String ua_cs;
    private String ua_qx;
    private String ua_address;
    private String ua_sjr;
    private String ud_nickname;
    private String ua_status;
    private String ua_phone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        setContentView(R.layout.activity_cpmpile_add);
        initView();
        initData();
     }


    private void initData() {

        Map<String, String> map = new HashMap<String, String>();
        String sid = Sp.getInData(CpmpileAdd.this).getSid();
        map.put("sid", sid);
        Log.i("addressSid---",sid);
        map.put("index", "");
        map.put("uo_lat", "");
        map.put("uo_long", "");
        map.put("uo_high", "");





        String url = "http://rpc.frps.lchtime.cn/index.php/user/gaddr";

        MyOkhttp.postAsync(url, map, new MyOkhttp.DataCallBack() {
            private String ua_address;

            @Override
            public void requestFailure(Request request, IOException e) {

                ToastUtil.showToast(CpmpileAdd.this, request.toString());

            }

            @Override
            public void requestSuccess(String result) throws Exception {
                Gson gson = new Gson();
                GaddrBean gaddrBean = gson.fromJson(result, GaddrBean.class);
                String info = gaddrBean.getResult().getInfo();
                ToastUtil.showToast(CpmpileAdd.this, info);
                List<GaddrBean.UserAddressBean> user_address = gaddrBean.getUser_address();
                String layoutPosit = Sp.getInData(CpmpileAdd.this).getLayoutPosit();

                ua_sf = user_address.get(Integer.parseInt(layoutPosit)).getUa_sf();
                ua_cs = user_address.get(Integer.parseInt(layoutPosit)).getUa_cs();
                ua_qx = user_address.get(Integer.parseInt(layoutPosit)).getUa_qx();
                  ua_address = user_address.get(Integer.parseInt(layoutPosit)).getUa_address();
                ua_phone = user_address.get(Integer.parseInt(layoutPosit)).getUa_phone();
                ua_sjr = user_address.get(Integer.parseInt(layoutPosit)).getUa_sjr();
                ud_nickname = user_address.get(Integer.parseInt(layoutPosit)).getUd_nickname();
                ua_status = user_address.get(Integer.parseInt(layoutPosit)).getUa_status();

                mTitleadd.setText("保存");
                mRessPhoneComp.setText(ua_phone);
                mRessCityComp.setText(ua_cs);
                mRessProvinceComp.setText(ua_sf);
                 mRessAddressComp.setText(ua_address+"城市");
                 mRessUserComp.setText(ua_sjr);

                mRessListressComp.setText(ua_address);
              }
        });



    }

    private void initView() {
        mTitle = (TextView) findViewById(R.id.title);
        mTitleadd = (TextView) findViewById(R.id.titleadd);
        mTitleadd.setOnClickListener(this);
        mRessUserComp = (EditText) findViewById(R.id.ress_user_comp);
        mRessPhoneComp = (EditText) findViewById(R.id.ress_phone_comp);
        mRessProvinceComp = (EditText) findViewById(R.id.ress_province_comp);
        mRessCityComp = (EditText) findViewById(R.id.ress_city_comp);
        mRessAddressComp = (EditText) findViewById(R.id.ress_address_comp);
        mRessListressComp = (EditText) findViewById(R.id.ress_listress_comp);
        mDefaults = (RadioButton) findViewById(R.id.defaults);
        mDefaults.setOnClickListener(this);
        mDefaultNo = (RadioButton) findViewById(R.id.default_no);
        mDefaultNo.setOnClickListener(this);
        mTvAddressComp = (TextView) findViewById(R.id.tv_address_comp);
        mTvAddressComp.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.titleadd:

                 ToastUtil.showToast(this,"点击保存");

                Map<String, String> mapadd = new HashMap<String, String>();
                String sidadd = Sp.getInData(CpmpileAdd.this).getSid();
                mapadd.put("sid", sidadd);
                Log.i("addressSid---",sidadd);
                mapadd.put("index", "");
                mapadd.put("uo_lat", "");
                mapadd.put("uo_long", "");
                mapadd.put("uo_high", "");

                //判断是否是添加删除编辑
                mapadd.put("type", "2");
                //json
                Map<String, String> list_json = new HashMap<String, String>();

                List<AddressBean> addresslist = new ArrayList<AddressBean>();


                AddressBean addressBean = new AddressBean(mRessProvinceComp.getText().toString().trim(),mRessCityComp.getText().toString().trim(),mRessAddressComp.getText().toString().trim(),mRessListressComp.getText().toString().trim(),mRessUserComp.getText().toString().trim(),mRessPhoneComp.getText().toString().trim(),"".toString().trim());
                addresslist.add(addressBean);
                Gson gson=new Gson();
                String jsonlist = gson.toJson(addresslist);
                String substring = jsonlist.substring(1, jsonlist.length());

                String jsonremove = substring.substring(0, substring.length()-1);

                Log.i("json-----add",jsonremove);



                mapadd.put("user_address", jsonremove);
                if (mDefaults.isChecked()){
                    //判断是否是默认地址
                    mapadd.put("ua_status","1");

                }else if (mDefaultNo.isChecked()){

                    mapadd.put("ua_status","0");

                }




                String url = "http://rpc.frps.lchtime.cn/index.php/user/saddr";

                MyOkhttp.postAsync(url, mapadd, new MyOkhttp.DataCallBack() {
                    @Override
                    public void requestFailure(Request request, IOException e) {

                        ToastUtil.showToast(CpmpileAdd.this, request.toString());
                        Log.i("失败原因---","djaoidjf");

                    }

                    @Override
                    public void requestSuccess(String result) throws Exception {
                        Gson gson = new Gson();
                        AddConsigeBean consigeBean = gson.fromJson(result, AddConsigeBean.class);
                        String info = consigeBean.getResult().getInfo();
                        Log.i("原因---",info);
                         ToastUtil.showToast(CpmpileAdd.this,info);




                    }
                });



                break;

            case R.id.tv_address_comp:


                Map<String, String> map1 = new HashMap<String, String>();
                String sid1 = Sp.getInData(CpmpileAdd.this).getSid();
                map1.put("sid", sid1);
                Log.i("addressSid---",sid1);
                map1.put("index", "");
                map1.put("uo_lat", "");
                map1.put("uo_long", "");
                map1.put("uo_high", "");

                //判断是否是添加删除编辑
                map1.put("type", "3");
                //json
                Map<String, String> list_json1 = new HashMap<String, String>();

                List<AddressBean> addresslist1 = new ArrayList<AddressBean>();


                AddressBean addressBean1 = new AddressBean(mRessProvinceComp.getText().toString().trim(),mRessCityComp.getText().toString().trim(),mRessAddressComp.getText().toString().trim(),mRessListressComp.getText().toString().trim(),mRessUserComp.getText().toString().trim(),mRessPhoneComp.getText().toString().trim(),"".toString().trim());
                addresslist1.add(addressBean1);
                Gson gson1=new Gson();
                String jsonlist1 = gson1.toJson(addresslist1);
                String substring1 = jsonlist1.substring(1, jsonlist1.length());

                String jsonremove1 = substring1.substring(0, substring1.length()-1);

                Log.i("json111-----",jsonremove1);



                map1.put("user_address", jsonremove1);
                if (mDefaults.isChecked()){
                    //判断是否是默认地址
                    map1.put("ua_status","1");

                }else if (mDefaultNo.isChecked()){

                    map1.put("ua_status","0");

                }




                String url1 = "http://rpc.frps.lchtime.cn/index.php/user/saddr";

                MyOkhttp.postAsync(url1, map1, new MyOkhttp.DataCallBack() {
                    @Override
                    public void requestFailure(Request request, IOException e) {

                        ToastUtil.showToast(CpmpileAdd.this, request.toString());

                    }

                    @Override
                    public void requestSuccess(String result) throws Exception {
                        Gson gson = new Gson();
                        AddConsigeBean consigeBean = gson.fromJson(result, AddConsigeBean.class);
                        String info = consigeBean.getResult().getInfo();
                        ToastUtil.showToast(CpmpileAdd.this, info);






                    }
                });





                break;
        }
    }
}
