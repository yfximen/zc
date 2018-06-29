package com.example.apac.rpcdata.ui.me;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;

import com.example.apac.rpcdata.R;

public class AmentSomeActivity extends Activity implements View.OnClickListener {


    private ImageView mCominA;
    private ImageView mCominB;
    private ImageView mCominC;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        setContentView(R.layout.activity_ament_some);
        initView();

    }


    private void initView() {
        mCominA = (ImageView) findViewById(R.id.comin_a);
        mCominA.setOnClickListener(this);
        mCominB = (ImageView) findViewById(R.id.comin_b);
        mCominB.setOnClickListener(this);
        mCominC = (ImageView) findViewById(R.id.comin_c);
        mCominC.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.comin_a:
                startActivity(new Intent(AmentSomeActivity.this, RestPayPwdActivity.class));
                overridePendingTransition(0, 0);//去掉Activity切换间的动画


                break;
            case R.id.comin_b:
                startActivity(new Intent(AmentSomeActivity.this, PayRsitPwdActivity.class));
                overridePendingTransition(0, 0);//去掉Activity切换间的动画

                break;
            case R.id.comin_c:
                startActivity(new Intent(AmentSomeActivity.this, ForgetActivity.class));
                overridePendingTransition(0, 0);//去掉Activity切换间的动画


                break;
        }
    }
}
