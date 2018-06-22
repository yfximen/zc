package com.example.apac.rpcdata.ui.pay;

import com.example.apac.rpcdata.R;
import com.example.apac.rpcdata.ui.BaseUI;

/**
 * 支付扫描结果
 * Created by user on 2018/6/21.
 */

public class ScanResultUI extends BaseUI {


    @Override
    protected void back() {
        finish();
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_pay_ment;
    }

    @Override
    protected void setControlBasis() {
        setTitle("支付");
    }

    @Override
    protected void prepareData() {
        String url = getIntent().getStringExtra("url");
        makeText(url);
    }
}
