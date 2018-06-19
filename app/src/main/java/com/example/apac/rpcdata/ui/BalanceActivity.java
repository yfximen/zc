package com.example.apac.rpcdata.ui;

import android.widget.ExpandableListView;

import com.example.apac.rpcdata.R;
import com.example.apac.rpcdata.adapter.ExpandListAdapter;
import com.example.apac.rpcdata.base.BaseTwoActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;

/**
 * Created by lchtime4 on 2018/6/19.
 */

public class BalanceActivity extends BaseTwoActivity {
     @BindView(R.id.expandableListView)
     ExpandableListView expandableListView_one;
    private List<Map<String, String>> groups;
    private List<List<Map<String, String>>> childs;

    @Override
    protected int getViewID() {
        return R.layout.activity_balance;
    }

    @Override
    protected void initView() {


    }

    @Override
    protected void initData() {
         Map<String, String> title_1 = new HashMap<String, String>();
         Map<String, String> title_2 = new HashMap<String, String>();
        title_1.put("group","2018-01-01");
        title_2.put("group","2018-03-03");

        groups = new ArrayList<Map<String, String>>();
         groups.add(title_1);
         groups.add(title_2);

       //创建二级条目 -
         Map<String, String> content_1 = new HashMap<String, String>();
        Map<String, String> content_2 = new HashMap<String, String>();
         Map<String, String> content_3 = new HashMap<String, String>();

        content_1.put("child","12:00:00");
        content_2.put("child","1200");
        content_3.put("child","收到红包（下级发送给上级）");

         List<Map<String, String>> child_1 = new ArrayList<Map<String, String>>();
        child_1.add(content_1);
        child_1.add(content_2);
        child_1.add(content_3);

        //内容二
         Map<String, String> content_4 = new HashMap<String, String>();
        Map<String, String> content_5 = new HashMap<String, String>();
        Map<String, String> content_6 = new HashMap<String, String>();

        content_4.put("child","12:00:00");
        content_5.put("child","1200");
        content_6.put("child","收到红包（下级发送给上级）");
        List<Map<String, String>> child_2 = new ArrayList<Map<String,String>>();
        child_2.add(content_4);
        child_2.add(content_5);
        child_2.add(content_6);

        //存放两个内容, 以便显示在列表中
        childs = new ArrayList<List<Map<String,String>>>();
        childs.add(child_1);
        childs.add(child_2);
        ExpandListAdapter adapter=new ExpandListAdapter(this, groups, childs);
        expandableListView_one.setAdapter(adapter);

    }

    @Override
    protected Object getPersenter() {
        return null;
    }
}
