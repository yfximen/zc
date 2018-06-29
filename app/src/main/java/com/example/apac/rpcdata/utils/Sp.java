package com.example.apac.rpcdata.utils;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Administrator on 2018/6/18.
 */

public class Sp {
    private static Sp RETROFIT_UTILS = null;
     private Context context;
    private SharedPreferences sharedPreferences;

    public Sp(Context context) {
        this.context = context;
        sharedPreferences = context.getSharedPreferences("abc", Context.MODE_PRIVATE);

    }

    private Sp() {}

    public static Sp getInData(Context context) {
        if (RETROFIT_UTILS == null){
            synchronized (RetrofitUtils.class){
                if (RETROFIT_UTILS == null){
                    RETROFIT_UTILS = new Sp(context);
                }
            }
        }
        return RETROFIT_UTILS;
    }


   public void setUserName(String str){
    SharedPreferences.Editor edit = sharedPreferences.edit();
    edit.putString("Uname",str);

    edit.commit();
    }

    public void setUserPwd(String str){
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.putString("Upwd",str);

        edit.commit();
    }

    public void setSid(String str){
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.putString("Sid",str);

        edit.commit();
    }


    public void setLayoutPosit(String str){
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.putString("posit",str);

        edit.commit();
    }
    public void setCount(String str){
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.putString("count",str);

        edit.commit();
    }
    public String getCount(){
        return sharedPreferences.getString("count","");
    }

    public void setNum(String str){
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.putString("num",str);

        edit.commit();
    }
    public String getNum(){
        return sharedPreferences.getString("num","");
    }



    public String getLayoutPosit(){
        return sharedPreferences.getString("posit","");
    }


    public String getSid(){
        return sharedPreferences.getString("Sid","");
    }

    public String getUserName(){
        return sharedPreferences.getString("Uname","");
    }

    public String getUserPwd(){
        return sharedPreferences.getString("Upwd","");
    }

}
