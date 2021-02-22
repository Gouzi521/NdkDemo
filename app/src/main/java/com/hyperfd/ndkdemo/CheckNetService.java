package com.hyperfd.ndkdemo;

import android.app.Service;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.IBinder;

/**
 * @Description TODO
 * @Author ma
 * @Date 2021/1/20 10:11
 */
public class CheckNetService extends Service {
    NetWorkStateReceiver netBroadcastReceiver;
    IntentFilter filter;
    private static String TAG="wp CheckNetService";
    Thread mThread=null;
    private boolean mThreadFlag=true;
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        //       动态注册广播
        filter = new IntentFilter();
        filter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        netBroadcastReceiver=new NetWorkStateReceiver();
        //注册广播接收
        registerReceiver(netBroadcastReceiver, filter);
//        mThread=new Thread(){
//            @Override
//            public void run() {
//                super.run();
//                while (mThreadFlag){
//                    if(true){
//        网络连通
//                    }
//                    else{
//                网络中断
//                    }
//                    try {
//                        Thread.sleep(10000);    //10s后执行
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//            }
//        };
    }

    @Override
    public void onDestroy() {
        mThreadFlag=false;
        if (mThread!=null){
            mThread.interrupt();
        }
        //        注销广播
        unregisterReceiver(netBroadcastReceiver);
        super.onDestroy();

    }

}
