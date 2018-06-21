package com.example.apac.rpcdata.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;

import com.example.apac.rpcdata.R;

public class MyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);



    }

    @Override
    public void setContentView(View view) {
        super.setContentView(view);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);//去掉标题栏

    }


}
