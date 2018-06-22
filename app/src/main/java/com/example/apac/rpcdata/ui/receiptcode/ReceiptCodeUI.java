package com.example.apac.rpcdata.ui.receiptcode;

import android.widget.ImageView;

import com.example.apac.rpcdata.R;
import com.example.apac.rpcdata.ui.BaseUI;

import butterknife.BindView;

/**
 * 收款码
 * Created by user on 2018/6/21.
 */

public class ReceiptCodeUI extends BaseUI {

    @BindView(R.id.iv_receipt_code)
    ImageView iv_receipt_code;

    @Override
    protected void back() {
        finish();
    }

    @Override
    protected int getLayout() {
        return R.layout.ui_home_receipt_code;
    }

    @Override
    protected void setControlBasis() {
        setTitle("收款码");
    }

    @Override
    protected void prepareData() {

    }
}
