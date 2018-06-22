package com.example.apac.rpcdata;


import android.content.Context;
import android.content.Intent;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.apac.rpcdata.ui.BalanceActivity;
import com.example.apac.rpcdata.ui.MyActivity;
import com.example.apac.rpcdata.ui.PayMentActivity;
import com.example.apac.rpcdata.ui.RedPacketActivity;
import com.example.apac.rpcdata.ui.TransferActivity;
import com.example.apac.rpcdata.ui.balancerecord.BalanceRecordUI;
import com.example.apac.rpcdata.ui.invitefriend.InviteFriendUI;
import com.example.apac.rpcdata.ui.pay.ScanUI;
import com.example.apac.rpcdata.ui.receiptcode.ReceiptCodeUI;
import com.example.apac.rpcdata.ui.transfer.TransferUI;
import com.example.apac.rpcdata.utils.ToastUtil;
//import com.uuzuche.lib_zxing.activity.CaptureActivity;
//import com.uuzuche.lib_zxing.activity.CodeUtils;
//import com.uuzuche.lib_zxing.activity.ZXingLibrary;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;
import com.youth.banner.listener.OnBannerListener;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity implements OnBannerListener {
    private Banner banner;
    private ArrayList<String> list_path;
    private ArrayList<String> list_title;
    private static final int REQUEST_CODE = 0x1111;

    //定义图标数组
    private int[] imageRes = {
            R.mipmap.icon_weixin,
            R.mipmap.icon_weixin,
            R.mipmap.icon_weixin,
            R.mipmap.icon_weixin,
            R.mipmap.icon_weixin,
            R.mipmap.icon_weixin,
            R.mipmap.icon_weixin,
            R.mipmap.icon_weixin,
            R.mipmap.icon_weixin,
    };

    //定义图标下方的名称数组
    private String[] name = {
            "红包链",
            "支付",
            "收款码",
            "转账",
            "余额记录",
            "商城",
            "邀请好友",
            "数字资产",
            "我的"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initNine();
//        ZXingLibrary.initDisplayOpinion(this);
    }

    private void initNine() {
        GridView gridview = (GridView) findViewById(R.id.gridview);
        int length = imageRes.length;

        //生成动态数组，并且转入数据
        ArrayList<HashMap<String, Object>> lstImageItem = new ArrayList<HashMap<String, Object>>();
        for (int i = 0; i < length; i++) {
            HashMap<String, Object> map = new HashMap<String, Object>();
            map.put("ItemImage", imageRes[i]);//添加图像资源的ID
            map.put("ItemText", name[i]);//按序号做ItemText
            lstImageItem.add(map);
        }
        //生成适配器的ImageItem 与动态数组的元素相对应
        SimpleAdapter saImageItems = new SimpleAdapter(this,
                lstImageItem,//数据来源
                R.layout.item_nine,//item的XML实现

                //动态数组与ImageItem对应的子项
                new String[]{"ItemImage", "ItemText"},

                //ImageItem的XML文件里面的一个ImageView,两个TextView ID
                new int[]{R.id.img_shoukuan, R.id.txt_shoukuan});
        //添加并且显示
        gridview.setAdapter(saImageItems);
        //添加消息处理
        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


//                Toast.makeText(MainActivity.this, position+"", Toast.LENGTH_LONG).show();
                if (position==0){
                    Intent intent=new Intent(MainActivity.this, RedPacketActivity.class);
                    startActivity(intent);
                    finish();

                }else if (position==1){

//                    Intent intent = new Intent(MainActivity.this, CaptureActivity.class);
//                    startActivityForResult(intent, REQUEST_CODE);
                    Intent intent=new Intent(MainActivity.this, ScanUI.class);
                    startActivity(intent);

                }else if (position==2){
//                    ToastUtil.showToast(MainActivity.this,"敬请期待");
//                    finish();
                    Intent intent=new Intent(MainActivity.this, ReceiptCodeUI.class);
                    startActivity(intent);

                }else if (position==3){
//                     startActivity(new Intent(MainActivity.this,TransferActivity.class));
//                    finish();
                    Intent intent=new Intent(MainActivity.this, TransferUI.class);
                    startActivity(intent);

                }else if (position==4){
//                    startActivity(new Intent(MainActivity.this,BalanceActivity.class));
//                    finish();
                    Intent intent=new Intent(MainActivity.this, BalanceRecordUI.class);
                    startActivity(intent);
                }else if (position==6){
                    Intent intent=new Intent(MainActivity.this, InviteFriendUI.class);
                    startActivity(intent);
                }else if (position==8){

                    startActivity(new Intent(MainActivity.this,MyActivity.class));
                    finish();

                }



            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE) {
            //处理扫描结果（在界面上显示）
//            if (null != data) {
//                Bundle bundle = data.getExtras();
//                if (bundle == null) {
//                    return;
//                }
//                if (bundle.getInt(CodeUtils.RESULT_TYPE) == CodeUtils.RESULT_SUCCESS) {
//                    String result = bundle.getString(CodeUtils.RESULT_STRING);
//                    Toast.makeText(this, "解析结果:" + result, Toast.LENGTH_LONG).show();
//                    startActivity(new Intent(MainActivity.this, PayMentActivity.class));
//                    finish();
//
//
//                } else if (bundle.getInt(CodeUtils.RESULT_TYPE) == CodeUtils.RESULT_FAILED) {
//                    Toast.makeText(MainActivity.this, "解析二维码失败", Toast.LENGTH_LONG).show();
//                }
//            }
        }
    }



    private void initView() {
        banner = findViewById(R.id.banner);
        list_path= new ArrayList<>();
        list_title= new ArrayList<>();

        list_path.add("http://ww4.sinaimg.cn/large/006uZZy8jw1faic21363tj30ci08ct96.jpg");
        list_path.add("http://ww4.sinaimg.cn/large/006uZZy8jw1faic259ohaj30ci08c74r.jpg");
        list_path.add("http://ww4.sinaimg.cn/large/006uZZy8jw1faic2b16zuj30ci08cwf4.jpg");
        list_path.add("http://ww4.sinaimg.cn/large/006uZZy8jw1faic2e7vsaj30ci08cglz.jpg");
        list_title.add("好好学习");
        list_title.add("天天向上");
        list_title.add("热爱劳动");
        list_title.add("不搞对象");
        //设置内置样式，共有六种可以点入方法内逐一体验使用。
        banner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR_TITLE_INSIDE);
        //设置图片加载器，图片加载器在下方
        banner.setImageLoader(new MyLoader());
        //设置图片网址或地址的集合
        banner.setImages(list_path);
        //设置轮播的动画效果，内含多种特效，可点入方法内查找后内逐一体验
        banner.setBannerAnimation(Transformer.Default);
        //设置轮播图的标题集合
        banner.setBannerTitles(list_title);
        //设置轮播间隔时间
        banner.setDelayTime(3000);
        //设置是否为自动轮播，默认是“是”。
        banner.isAutoPlay(true);
        //设置指示器的位置，小点点，左中右。
        banner.setIndicatorGravity(BannerConfig.CENTER)
                //以上内容都可写成链式布局，这是轮播图的监听。比较重要。方法在下面。
                .setOnBannerListener(this)
                //必须最后调用的方法，启动轮播图。
                .start();



    }

    @Override
    public void OnBannerClick(int position) {

        Toast.makeText(this, "你点击了"+position, Toast.LENGTH_SHORT).show();

    }

    private class MyLoader extends ImageLoader {

        @Override
        public void displayImage(Context context, Object path, ImageView imageView) {
            Glide.with(context).load((String) path).into(imageView);

        }
    }




}
