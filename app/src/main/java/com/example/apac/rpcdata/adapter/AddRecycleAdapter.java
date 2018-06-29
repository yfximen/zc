package com.example.apac.rpcdata.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.apac.rpcdata.R;
import com.example.apac.rpcdata.bean.GaddrBean;
import com.example.apac.rpcdata.ui.me.AddConsing;
import com.example.apac.rpcdata.ui.me.CpmpileAdd;
import com.example.apac.rpcdata.utils.Sp;

import java.util.List;

/**
 * Created by lchtime4 on 2018/6/28.
 */

public class AddRecycleAdapter extends RecyclerView.Adapter<AddRecycleAdapter.ViewHolder> {
    private List<GaddrBean.UserAddressBean> user_address;
    private Context context;

    public AddRecycleAdapter(List<GaddrBean.UserAddressBean> user_address, Context context) {
        this.user_address = user_address;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.rectyle_ltem, null);
        final ViewHolder holder = new ViewHolder(view);


        return holder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {

        holder.itemView.setTag(position);
        GaddrBean.UserAddressBean userAddressBean = user_address.get(position);
        holder.rect_name.setText(user_address.get(position).getUa_sjr());
        holder.rect_phone.setText(user_address.get(position).getUa_phone());

        String ua_sf = user_address.get(position).getUa_sf();
        String ua_cs = user_address.get(position).getUa_cs();
        String ua_qx = user_address.get(position).getUa_qx();
        String ua_address = user_address.get(position).getUa_address();
        String ua_status = user_address.get(position).getUa_status();

        holder.rect_addlist.setText(ua_sf + ua_cs + ua_qx + ua_address);
        holder.recyle_cpmpile.setText("编辑");

         holder.itemView.findViewById(R.id.recyle_cpmpile).setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 int layoutPosition = holder.getLayoutPosition();
                 Sp.getInData(context).setLayoutPosit(layoutPosition+"");
                 mOnItemClickLitener.onItemClick(holder.itemView.findViewById(R.id.recyle_cpmpile),position);
             }
         });

    }

    @Override
    public int getItemCount() {
        return user_address.size();
    }


    class ViewHolder extends RecyclerView.ViewHolder {

        TextView rect_name, rect_phone, rect_addlist, delete_ress, recyle_cpmpile;

        public ViewHolder(View itemView) {
            super(itemView);
            rect_name = itemView.findViewById(R.id.rect_Name);
            rect_phone = itemView.findViewById(R.id.rect_phone);
            rect_addlist = itemView.findViewById(R.id.rect_addlist);

            recyle_cpmpile = itemView.findViewById(R.id.recyle_cpmpile);

        }


    }

    public static interface OnItemClickListener {
        void onItemClick(View view, int position);
    }

    private OnItemClickListener mOnItemClickLitener;

    public void setOnItemClickLitener(OnItemClickListener mOnItemClickLitener) {
        this.mOnItemClickLitener = mOnItemClickLitener;


    }
}
