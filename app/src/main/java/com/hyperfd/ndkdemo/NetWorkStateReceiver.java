package com.hyperfd.ndkdemo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;

/**
 * @Description TODO
 * @Author ma
 * @Date 2021/1/20 9:57
 */
public class NetWorkStateReceiver extends BroadcastReceiver {
    private static String NET_CHANGE="android.net.conn.CONNECTIVITY_CHANGE";
    private static String TAG="wp---->";

    @Override
    public void onReceive(Context context, Intent intent) {
        //收到网络变化情况发一条信息
        String action=intent.getAction();
        if (action.equals(NET_CHANGE)){
//            Log.i(TAG,"the net is change...");
//            分3种状态：1无网络，2wifi网络，3.sim卡网络
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(
                    Context.CONNECTIVITY_SERVICE);
            NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
            if(networkInfo==null){
                Log.i(TAG,"无网络");
            }
            else{
                int type2 = networkInfo.getType();
//                Log.i(TAG,"已联网，网络类型："+type2);
                switch (type2){
                    case 1:Log.i(TAG,"已联网，网络类型wifi");break;   //wifi网络
                    case 0:Log.i(TAG,"已联网，网络类型流量");break;   //sim卡网络
                    default:break;
                }
            }

        }
    }

}
