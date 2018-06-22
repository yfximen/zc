package com.example.apac.rpcdata.ui.balancerecord;

import android.support.v7.widget.LinearLayoutManager;

import com.example.apac.rpcdata.R;
import com.example.apac.rpcdata.adapter.BalanceRecordAdapter;
import com.example.apac.rpcdata.bean.BalanceRecordBean;
import com.example.apac.rpcdata.ui.BaseUI;
import com.jcodecraeer.xrecyclerview.ProgressStyle;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import butterknife.BindView;

/**
 * 余额记录
 * Created by user on 2018/6/22.
 */

public class BalanceRecordUI extends BaseUI implements XRecyclerView.LoadingListener, BalanceRecordP.BalanceRecordPface {

    @BindView(R.id.xrv_balance_record)
    XRecyclerView xrv_balance_record;

    private BalanceRecordAdapter balanceRecordAdapter;
    private BalanceRecordP balanceRecordP;

    @Override
    protected void back() {
        finish();
    }

    @Override
    protected int getLayout() {
        return R.layout.ui_home_balance_record;
    }

    @Override
    protected void setControlBasis() {
        setTitle("余额记录");
        balanceRecordP = new BalanceRecordP(this, getActivity());
        initAdapter();
    }

    private void initAdapter() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        xrv_balance_record.setLayoutManager(linearLayoutManager);
        xrv_balance_record.setLoadingMoreProgressStyle(ProgressStyle.BallClipRotate);

        balanceRecordAdapter = new BalanceRecordAdapter(this);
        xrv_balance_record.setAdapter(balanceRecordAdapter);
        xrv_balance_record.setLoadingListener(this);
    }

    @Override
    protected void prepareData() {

    }

    @Override
    public void setBalanceRecord(BalanceRecordBean balanceRecordBean, int curPage) {

    }

    @Override
    public void setNoData() {

    }

    @Override
    public void onRefresh() {

    }

    @Override
    public void onLoadMore() {

    }

}
