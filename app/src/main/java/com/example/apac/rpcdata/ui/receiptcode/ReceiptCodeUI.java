package com.example.apac.rpcdata.ui.receiptcode;

import android.content.Intent;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.apac.rpcdata.MainActivity;
import com.example.apac.rpcdata.R;
import com.example.apac.rpcdata.bean.ReceiptCodeBean;
import com.example.apac.rpcdata.ui.BaseUI;
import com.example.apac.rpcdata.utils.Sp;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 收款码
 * Created by user on 2018/6/21.
 */

public class ReceiptCodeUI extends BaseUI implements ReceiptCodeP.ReceiptCodePface {

    @BindView(R.id.iv_receipt_code)
    ImageView iv_receipt_code;
     @BindView(R.id.receipt_count_page1)
    TextView receipt_count_page1;
    @BindView(R.id.receipt_num_page1)
    TextView receipt_num_page1;
    @BindView(R.id.go_maincode)
    ImageView go_maincode;
     @OnClick(R.id.go_maincode)
     public void onClick(){
         startActivity(new Intent(ReceiptCodeUI.this, MainActivity.class));
         finish();
     }

    private ReceiptCodeP receiptCodeP;

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
        String count = Sp.getInData(this).getCount();
        String num = Sp.getInData(this).getNum();
        receipt_count_page1.setText(count);
        receipt_num_page1.setText(num);

        setTitle("收款码");
        receiptCodeP = new ReceiptCodeP(this, getActivity());
    }

    @Override
    protected void prepareData() {
        receiptCodeP.getReceiptCode(R.string.pay_qrcode);
    }

    @Override
    public void setReceiptCode(ReceiptCodeBean receiptCodeBean) {
        Glide.with(this).load(receiptCodeBean.getUrl_qrcode()).into(iv_receipt_code);
    }
}
