package com.example.apac.rpcdata.adapter;

 import android.content.Context;
 import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
 import android.widget.ImageView;
 import android.widget.TextView;
 import android.widget.Toast;

 import com.example.apac.rpcdata.MainActivity;
 import com.example.apac.rpcdata.R;

 import java.util.List;
 import java.util.Map;

/**
 * Created by lchtime4 on 2018/6/19.
 */

public class ExpandListAdapter extends BaseExpandableListAdapter {

    Context context;
    private List<Map<String, String>> groups;
    private List<List<Map<String, String>>> childs;

    public ExpandListAdapter(Context context, List<Map<String, String>> groups, List<List<Map<String, String>>> childs) {
        this.context = context;
        this.groups = groups;
        this.childs = childs;
    }






    @Override
    public int getGroupCount() {
        return groups.size();
    }

    @Override
    public int getChildrenCount(int i) {
        return groups.get(i).size();
    }

    @Override
    public Object getGroup(int i) {
        return null;
    }

    @Override
    public Object getChild(int i, int i1) {
        return null;
    }

    @Override
    public long getGroupId(int i) {
        return 0;
    }

    @Override
    public long getChildId(int i, int i1) {
        return 0;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int i, boolean b, View view, ViewGroup viewGroup) {
        return null;
    }

    @Override
    public View getChildView(int i, int i1, boolean b, View view, ViewGroup viewGroup) {
        return null;
    }

    @Override
    public boolean isChildSelectable(int i, int i1) {
        return false;
    }



}
