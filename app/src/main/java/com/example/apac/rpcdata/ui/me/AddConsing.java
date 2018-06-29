package com.example.apac.rpcdata.ui.me;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.TextView;
import android.widget.Toast;

import com.example.apac.rpcdata.MainActivity;
import com.example.apac.rpcdata.R;
import com.example.apac.rpcdata.adapter.AddRecycleAdapter;
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

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.Request;

public class AddConsing extends Activity implements View.OnClickListener {

    /**
     * 标题
     */
    private TextView mTitle;
    /**
     * 添加地址
     */

    private TextView mTitleadd;
    private RecyclerView mConfinRecy;
    private List<GaddrBean.UserAddressBean> user_address;
    private TextView recyle_cpmpile;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        setContentView(R.layout.activity_add_consing);
        initView();

    }

    private void initView() {
        mTitle = (TextView) findViewById(R.id.title);
        mTitleadd = (TextView) findViewById(R.id.titleadd);
        mTitleadd.setOnClickListener(this);
        mConfinRecy = (RecyclerView) findViewById(R.id.confinRecy);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.titleadd:
                startActivity(new Intent(AddConsing.this,AddressActivity.class));

                break;
            case R.id.recyle_cpmpile:
                startActivity(new Intent(AddConsing.this,CpmpileAdd.class));

                break;
        }
    }

    @Override
    protected void onResume() {
        super.onResume();


        Map<String, String> map = new HashMap<String, String>();
        String sid = Sp.getInData(AddConsing.this).getSid();
        map.put("sid", sid);
        Log.i("addressSid---",sid);
        map.put("index", "");
        map.put("uo_lat", "");
        map.put("uo_long", "");
        map.put("uo_high", "");


        //json
        Map<String, String> list_json = new HashMap<String, String>();

        List<GaddrBean> gaddrBeans = new ArrayList<GaddrBean>();





        String url = "http://rpc.frps.lchtime.cn/index.php/user/gaddr";

        MyOkhttp.postAsync(url, map, new MyOkhttp.DataCallBack() {
            @Override
            public void requestFailure(Request request, IOException e) {

                ToastUtil.showToast(AddConsing.this, request.toString());

            }

            @Override
            public void requestSuccess(String result) throws Exception {
                Gson gson = new Gson();
                GaddrBean gaddrBean = gson.fromJson(result, GaddrBean.class);
                String info = gaddrBean.getResult().getInfo();
                user_address = gaddrBean.getUser_address();

                LinearLayoutManager manager=new LinearLayoutManager(AddConsing.this,LinearLayoutManager.VERTICAL,false);
                mConfinRecy.setLayoutManager(manager);

                mConfinRecy.addItemDecoration(new DividerItemDecoration(AddConsing.this,DividerItemDecoration.VERTICAL));

                 AddRecycleAdapter addRecycleAdapter = new AddRecycleAdapter(user_address,AddConsing.this);
                 addRecycleAdapter.setOnItemClickLitener(new AddRecycleAdapter.OnItemClickListener() {
                     @Override
                     public void onItemClick(View view, int position) {
                       Intent intent=new Intent(AddConsing.this,CpmpileAdd.class);
                       startActivity(intent);

                     }
                 });


                mConfinRecy.setAdapter(addRecycleAdapter);



                ToastUtil.showToast(AddConsing.this, info);
            }
        });



    }


}
