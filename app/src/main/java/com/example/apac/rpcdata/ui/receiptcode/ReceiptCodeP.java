package com.example.apac.rpcdata.ui.receiptcode;

import android.support.v4.app.FragmentActivity;

import com.example.apac.rpcdata.bean.CommonBean;
import com.example.apac.rpcdata.ui.BasePresenter;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import okhttp3.Call;

/**
 * Created by user on 2018/6/22.
 */

public class ReceiptCodeP extends BasePresenter {

    private ReceiptCodePface face;

    public ReceiptCodeP(ReceiptCodePface face, FragmentActivity activity) {
        this.face = face;
        setActivity(activity);
    }

    /**
     * 生成收款码
     */
    public void getReceiptCode(int id) {
        OkHttpUtils.post().url("")
                .addParams("sid", "")
                .addParams("index", "")
                .addParams("ub_id", "")
                .addParams("uo_long", "")
                .addParams("uo_lat", "")
                .addParams("uo_high", "")
                .build().execute(new StringCallback() {
            @Override
            public void onError(Call call, Exception e, int id) {

            }

            @Override
            public void onResponse(String response, int id) {

            }
        });
    }

    public interface ReceiptCodePface {
        void setUserShareInfo(CommonBean userShareBean);
    }


}
