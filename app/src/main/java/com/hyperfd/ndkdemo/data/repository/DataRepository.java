package com.hyperfd.ndkdemo.data.repository;

import com.hyperfd.architecture.data.response.DataResult;
import com.hyperfd.architecture.data.response.ResponseStatus;
import com.hyperfd.ndkdemo.data.bean.User;

import java.util.Timer;
import java.util.TimerTask;

/**
 * @Description TODO
 * @Author ma
 * @Date 2021/3/4 17:14
 */
public class DataRepository {

    private static final DataRepository S_REQUEST_MANAGER = new DataRepository();

    private DataRepository() {
    }

    public static DataRepository getInstance() {
        return S_REQUEST_MANAGER;
    }

    /**
     * TODO 模拟登录的网络请求
     *
     * @param user   ui 层填写的用户信息
     * @param result 模拟网络请求返回的 token
     */
    public void login(User user, final DataResult.Result<String> result) {

        Timer timer = new Timer();

        TimerTask task = new TimerTask() {
            @Override
            public void run() {

                //TODO 模拟登录，假装花费了 2000 毫秒去提交用户信息，结果遭遇网络状况不良。
                //这时候可以通过 NetworkState 去通知 UI 层做出变化。

                String response = "";

                ResponseStatus responseStatus = new ResponseStatus("404", false);

                result.onResult(new DataResult<>(response, responseStatus));
            }
        };

        timer.schedule(task, 2000);
    }
}
