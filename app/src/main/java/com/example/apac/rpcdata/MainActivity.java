package com.example.apac.rpcdata;


import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ViewSwitcher;

import com.example.apac.rpcdata.bean.HomeBean;
import com.example.apac.rpcdata.ui.FaRedPageActivity;
import com.example.apac.rpcdata.ui.MyActivity;
import com.example.apac.rpcdata.ui.balancerecord.BalanceRecordUI;
import com.example.apac.rpcdata.ui.invitefriend.InviteFriendUI;
import com.example.apac.rpcdata.ui.pay.ScanUI;
import com.example.apac.rpcdata.ui.receiptcode.ReceiptCodeUI;
import com.example.apac.rpcdata.ui.transfer.TransferUI;
import com.example.apac.rpcdata.utils.Sp;
import com.example.apac.rpcdata.utils.ToastUtil;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import butterknife.ButterKnife;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

//import com.uuzuche.lib_zxing.activity.CaptureActivity;
//import com.uuzuche.lib_zxing.activity.CodeUtils;
//import com.uuzuche.lib_zxing.activity.ZXingLibrary;

public class MainActivity extends Activity implements View.OnClickListener {

    private static final int REQUEST_CODE = 0x1111;
    private ArrayList<String> list_path;
    private ArrayList<String> list_title;
    final OkHttpClient client = new OkHttpClient();
    private String sid;
    private ViewSwitcher mViewSwitcher;
    private HomeBean homeBean;
    private int rpc_level;

    private List<HomeBean.RpcUpBean> rpc_up;

    private TextView red_packet_ok;
    private String rpc_count;
    private String rpc_num;
    private TextView home_count_page1;
    private TextView home_num_page1;
    @SuppressLint("HandlerLeak")
    private Handler mHandler = new Handler() {


        @Override
        public void handleMessage(Message msg) {
            if (msg.what == 1) {
                String ReturnMessage = (String) msg.obj;
                Log.i("获取的返回信息", ReturnMessage);
                homeBean = new Gson().fromJson(ReturnMessage, HomeBean.class);
                String info = homeBean.getResult().getInfo();

                //判断用户的状态，0为未完成发红包，1为完成
                rpc_level = homeBean.getRpc_level();
                if (rpc_level == 1) {
                    red_packet_ok.setText("");

                } else {
                    red_packet_ok.setText("确认红包链");

                }
                rpc_num = homeBean.getRpc_num();
                rpc_count = homeBean.getRpc_count();
                Sp.getInData(MainActivity.this).setNum(rpc_num);
                 Sp.getInData(MainActivity.this).setCount(rpc_count);
                home_count_page1.setText(rpc_count);
                home_num_page1.setText(rpc_num);

                //得到用户要发送红包的用户id
                rpc_up = homeBean.getRpc_up();

                /***
                 * 在此处可以通过获取到的Msg值来判断
                 * 给出用户提示注册成功 与否，以及判断是否用户名已经存在
                 *
                 */


            }

        }

    };
    private ImageView mImgWelcome;
    /**
     * 余额:
     */
    private TextView mYe;
    /**
     * 1000
     */
    private TextView mHomeNumPage1;
    /**
     * 红包数:
     */
    private TextView mTextView;
    /**
     * 1000
     */
    private TextView mHomeCountPage1;
    private ImageView mFe1;
    private ImageView mHblImg;
    /**
     * 红包链
     */
    private TextView mHblTv;
    private ImageView mZfImg;
    /**
     * 支付
     */
    private TextView mZfTv;
    private ImageView mSkmImg;
    /**
     * 收款码
     */
    private TextView mSkmTv;
    private ImageView mZzImg;
    /**
     * 转账
     */
    private TextView mZzTv;
    private ImageView mYejlImg;
    /**
     * 余额记录
     */
    private TextView mYejlTv;
    private ImageView mScImg;
    /**
     * 商城
     */
    private TextView mScTv;
    private ImageView mYqhyImg;
    /**
     * 邀请好友
     */
    private TextView mYqhyTv;
    private ImageView mSzzcImg;
    /**
     * 数字资产
     */
    private TextView mSzzcTv;
    private ImageView mWdImg;
    /**
     * 我的
     */
    private TextView mWdTv;
    /**  */
    private TextView mRedPacketOk;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        ButterKnife.bind(this);
        setContentView(R.layout.activity_main);

        Intent intent = this.getIntent();
        sid = intent.getStringExtra("sid");
        Sp.getInData(MainActivity.this).setSid(sid);

        initView();

        initData();
        initNine();

    }

    private void initData() {

        postRequest(sid);

    }

    private void initNine() {
        if (rpc_level == 0) {
            //确认发送红包
            red_packet_ok.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(MainActivity.this, FaRedPageActivity.class);
                    intent.putExtra("rpc_count", rpc_count);
                    intent.putExtra("rpc_num", rpc_num);
                     intent.putExtra("sid", sid);
                    Log.i("sid--------", sid);
                    Log.i("ub_id_1", rpc_up.get(0).getUb_id());
                    Log.i("ub_id_2", rpc_up.get(1).getUb_id());
                    Log.i("ub_id_3", rpc_up.get(2).getUb_id());
                    Log.i("ub_id_4", rpc_up.get(3).getUb_id());
                    Log.i("ub_id_5", rpc_up.get(4).getUb_id());

                    intent.putExtra("ub_id_1", rpc_up.get(0).getUb_id());
                    intent.putExtra("ud_nickname_1", rpc_up.get(0).getUd_nickname());

                    intent.putExtra("ub_id_2", rpc_up.get(1).getUb_id());
                    intent.putExtra("ud_nickname_2", rpc_up.get(1).getUd_nickname());

                    intent.putExtra("ub_id_3", rpc_up.get(2).getUb_id());
                    intent.putExtra("ud_nickname_3", rpc_up.get(2).getUd_nickname());

                    intent.putExtra("ub_id_4", rpc_up.get(3).getUb_id());
                    intent.putExtra("ud_nickname_4", rpc_up.get(3).getUd_nickname());

                    intent.putExtra("ub_id_5", rpc_up.get(4).getUb_id());
                    intent.putExtra("ud_nickname_5", rpc_up.get(4).getUd_nickname());

                    startActivity(intent);


                }
            });

            return;
        }
    }


    @Override
    protected void onResume() {
        super.onResume();
        postRequest(sid);

    }

    private void initView() {

        home_count_page1 = findViewById(R.id.home_count_page1);
        home_num_page1 = findViewById(R.id.home_num_page1);


        red_packet_ok = findViewById(R.id.red_packet_ok1);

        mViewSwitcher = findViewById(R.id.viewswitcher);
        mViewSwitcher.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                return getLayoutInflater().inflate(R.layout.item_viewswitch, null);
            }
        });


//设置切入动画
        TranslateAnimation animationTop = new TranslateAnimation(0, 0, 200, 0);
        animationTop.setFillAfter(true);
        animationTop.setDuration(200);
        //设置切出动画
        TranslateAnimation animationBottom = new
                TranslateAnimation(0, 0, 0, -200);
        animationBottom.setFillAfter(true);
        animationBottom.setDuration(200);
        mViewSwitcher.setInAnimation(animationTop);
        mViewSwitcher.setOutAnimation(animationBottom);
        mTimer.schedule(mTimerTask, 1000, 4000);


        mImgWelcome = (ImageView) findViewById(R.id.img_welcome);
        mYe = (TextView) findViewById(R.id.ye);
        mHomeNumPage1 = (TextView) findViewById(R.id.home_num_page1);
        mTextView = (TextView) findViewById(R.id.textView);
        mHomeCountPage1 = (TextView) findViewById(R.id.home_count_page1);
        mFe1 = (ImageView) findViewById(R.id.fe1);
        mHblImg = (ImageView) findViewById(R.id.hbl_img);
        mHblImg.setOnClickListener(this);
        mHblTv = (TextView) findViewById(R.id.hbl_tv);
        mHblTv.setOnClickListener(this);
        mZfImg = (ImageView) findViewById(R.id.zf_img);
        mZfImg.setOnClickListener(this);
        mZfTv = (TextView) findViewById(R.id.zf_tv);
        mZfTv.setOnClickListener(this);
        mSkmImg = (ImageView) findViewById(R.id.skm_img);
        mSkmImg.setOnClickListener(this);
        mSkmTv = (TextView) findViewById(R.id.skm_tv);
        mSkmTv.setOnClickListener(this);
        mZzImg = (ImageView) findViewById(R.id.zz_img);
        mZzImg.setOnClickListener(this);
        mZzTv = (TextView) findViewById(R.id.zz_tv);
        mZzTv.setOnClickListener(this);
        mYejlImg = (ImageView) findViewById(R.id.yejl_img);
        mYejlImg.setOnClickListener(this);
        mYejlTv = (TextView) findViewById(R.id.yejl_tv);
        mYejlTv.setOnClickListener(this);
        mScImg = (ImageView) findViewById(R.id.sc_img);
        mScImg.setOnClickListener(this);
        mScTv = (TextView) findViewById(R.id.sc_tv);
        mScTv.setOnClickListener(this);
        mYqhyImg = (ImageView) findViewById(R.id.yqhy_img);
        mYqhyImg.setOnClickListener(this);
        mYqhyTv = (TextView) findViewById(R.id.yqhy_tv);
        mYqhyTv.setOnClickListener(this);
        mSzzcImg = (ImageView) findViewById(R.id.szzc_img);
        mSzzcImg.setOnClickListener(this);
        mSzzcTv = (TextView) findViewById(R.id.szzc_tv);
        mSzzcTv.setOnClickListener(this);
        mWdImg = (ImageView) findViewById(R.id.wd_img);
        mWdImg.setOnClickListener(this);
        mWdTv = (TextView) findViewById(R.id.wd_tv);
        mWdTv.setOnClickListener(this);
        mRedPacketOk = (TextView) findViewById(R.id.red_packet_ok1);
        mRedPacketOk.setOnClickListener(this);
    }

    //滚动
    Timer mTimer = new Timer();
    TimerTask mTimerTask = new TimerTask() {
        @Override
        public void run() {
            mHandler1.sendEmptyMessage(0);
        }
    };
    Handler mHandler1 = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            ((TextView) mViewSwitcher.getNextView().findViewById(R.id.viewswitcher_tv_one)).setText("中包赠送价值200元的套餐");
            mViewSwitcher.showNext();
        }
    };

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mHandler1.removeCallbacksAndMessages(null);
    }

    private void postRequest(String sid) {
        //建立请求表单，添加上传服务器的参数
        RequestBody formBody = new FormBody.Builder()


                .add("sid", sid)
                .add("index", "")
                .add("ub_id", "")
                .add("uo_long", "")
                .add("uo_lat", "")
                .add("uo_high", "")


                .build();
        //发起请求
        final Request request = new Request.Builder()

                .url("http://rpc.frps.lchtime.cn/index.php/rpc/index")
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


    @Override
    public void onClick(View v) {
        if (rpc_level==1){


        switch (v.getId()) {
            default:
                break;
            case R.id.hbl_img:
                ToastUtil.showToast(MainActivity.this, "敬请期待");

                break;
            case R.id.hbl_tv:
                ToastUtil.showToast(MainActivity.this, "敬请期待");

                break;
            case R.id.zf_img:
                Intent intent = new Intent(MainActivity.this, ScanUI.class);
                startActivity(intent);

                break;
            case R.id.zf_tv:
                Intent intenttv = new Intent(MainActivity.this, ScanUI.class);
                startActivity(intenttv);
                break;
            case R.id.skm_img:
                Intent intentskm = new Intent(MainActivity.this, ReceiptCodeUI.class);
                startActivity(intentskm);

                break;
            case R.id.skm_tv:
                Intent intentskmtv = new Intent(MainActivity.this, ReceiptCodeUI.class);
                startActivity(intentskmtv);

                break;
            case R.id.zz_img:
                Intent intentzz = new Intent(MainActivity.this, TransferUI.class);
                startActivity(intentzz);

                break;
            case R.id.zz_tv:
                Intent intentzztv = new Intent(MainActivity.this, TransferUI.class);
                startActivity(intentzztv);

                break;
            case R.id.yejl_img:
                Intent intentjl = new Intent(MainActivity.this, BalanceRecordUI.class);
                startActivity(intentjl);

                break;
            case R.id.yejl_tv:
                Intent intentjltv = new Intent(MainActivity.this, BalanceRecordUI.class);
                startActivity(intentjltv);

                break;
            case R.id.sc_img:
                ToastUtil.showToast(MainActivity.this, "敬请期待");

                break;
            case R.id.sc_tv:
                ToastUtil.showToast(MainActivity.this, "敬请期待");

                break;
            case R.id.yqhy_img:
                Intent intentyqhy = new Intent(MainActivity.this, InviteFriendUI.class);
                startActivity(intentyqhy);

                break;
            case R.id.yqhy_tv:
                Intent intentyqhytv = new Intent(MainActivity.this, InviteFriendUI.class);
                startActivity(intentyqhytv);

                break;
            case R.id.szzc_img:
                ToastUtil.showToast(MainActivity.this, "敬请期待");
                break;
            case R.id.szzc_tv:
                ToastUtil.showToast(MainActivity.this, "敬请期待");
                break;
            case R.id.wd_img:
                startActivity(new Intent(MainActivity.this, MyActivity.class));

                break;
            case R.id.wd_tv:
                startActivity(new Intent(MainActivity.this, MyActivity.class));

                break;

        }
        }
    }
}
