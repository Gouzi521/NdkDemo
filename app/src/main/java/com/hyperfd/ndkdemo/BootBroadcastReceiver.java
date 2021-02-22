package com.hyperfd.ndkdemo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * @Description TODO
 * @Author ma
 * @Date 2021/1/20 9:56
 */
public class BootBroadcastReceiver extends BroadcastReceiver {
    private static String TAG="wp BootBroadcastReceiver";
    private static final String ACTION_BOOT = "android.intent.action.BOOT_COMPLETED"; //开机启动
    @Override
    public void onReceive(Context context, Intent intent) {
//        开机启动服务监测网络情况
        Log.i(TAG, "系统已经启动 ,接收到广播："+intent.getAction());
        String action = intent.getAction();
        if (ACTION_BOOT.equals(action)) {
            Log.i(TAG,"开启BootBroadcastReceiver");
            Intent intentt = new Intent(context, CheckNetService.class);//启动服务器
            context.startService(intentt);
        }
    }

}
