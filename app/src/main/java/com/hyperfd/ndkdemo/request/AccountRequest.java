package com.hyperfd.ndkdemo.request;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.hyperfd.architecture.data.response.DataResult;
import com.hyperfd.ndkdemo.data.bean.User;

import com.kunminx.architecture.domain.request.BaseRequest;

/**
 * @Description request 的职责仅限于 对数据请求的转发，不建议在此处理 UI 逻辑，
 * @Author ma
 * @Date 2021/3/4 16:37
 */
public class AccountRequest extends BaseRequest {

    private final MutableLiveData<DataResult<String>> tokenLiveData=new MutableLiveData<>();

    //TODO tip 2：向 ui 层提供的 request LiveData，使用父类 LiveData 而不是 MutableLiveData，
    //如此达成了 "唯一可信源" 的设计，也即通过访问控制权限实现 "读写分离"（国外称 "单向数据流"），
    //从而确保了消息分发的一致性和可靠性。

    public LiveData<DataResult<String>> getTokenLiveData(){
        //TODO tip 3：与此同时，为了方便语义上的理解，故而直接将 DataResult 作为 LiveData value 回推给 UI 层，
        //而不是将 DataResult 的泛型实体拆下来单独回推，如此
        //一方面使 UI 层有机会基于 DataResult 的 responseStatus 来分别处理 请求成功或失败的情况下的 UI 表现，
        //另一方面从语义上强调了 该数据是请求得来的结果，是只读的，与 "可变状态" 形成明确的区分，
        //从而方便团队开发人员自然而然遵循 "唯一可信源"/"单向数据流" 的开发理念，规避消息同步一致性等不可预期的错误。

        return tokenLiveData;
    }

    public void requestLogin(User user) {

        //TODO Tip：lambda 语句只有一行时可简写，具体可结合实际情况选择和使用

        /*DataRepository.getInstance().login(user, dataResult -> {
            tokenLiveData.postValue(dataResult);
        });*/


        //DataRepository.getInstance().login(user, tokenLiveData::postValue);
    }
}
