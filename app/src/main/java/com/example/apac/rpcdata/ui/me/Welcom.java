package com.example.apac.rpcdata.ui.me;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.widget.TextView;

import com.example.apac.rpcdata.MainActivity;
import com.example.apac.rpcdata.R;
import com.example.apac.rpcdata.ui.LoginAcitivy;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class Welcom extends Activity {

    @BindView(R.id.go_to)
    TextView go_to;

    @OnClick(R.id.go_to)
    public void onClick(){
        startActivity(new Intent(Welcom.this, LoginAcitivy.class));
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        setContentView(R.layout.activity_welcom);
        ButterKnife.bind(this);
    }
}
