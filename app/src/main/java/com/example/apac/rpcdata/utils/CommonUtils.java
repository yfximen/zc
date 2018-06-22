package com.example.apac.rpcdata.utils;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.widget.Toast;

/**
 * Created by user on 2018/6/22.
 */

public class CommonUtils {

    /**
     * 文本复制
     *
     * @param context
     * @param content
     */
    public static void getTextCopy(Context context, String content) {
        //获取剪贴板管理器：
        ClipboardManager cm = (ClipboardManager) context.getSystemService(Context.CLIPBOARD_SERVICE);
        //创建普通字符型ClipData
        ClipData mClipData = ClipData.newPlainText("Label", content);
        //将ClipData内容放到系统剪贴板里
        cm.setPrimaryClip(mClipData);
        Toast.makeText(context, "复制成功", Toast.LENGTH_SHORT).show();
    }

}
