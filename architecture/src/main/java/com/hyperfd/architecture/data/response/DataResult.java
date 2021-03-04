package com.hyperfd.architecture.data.response;

/**
 * @Description TODO
 * @Author ma
 * @Date 2021/2/24 15:31
 */
public class DataResult<T> {

    private T mEntity;
    private ResponseStatus mResponseStatus;

    public DataResult(T entity, ResponseStatus responseStatus) {
        mEntity = entity;
        mResponseStatus = responseStatus;
    }

    public T getResult() {
        return mEntity;
    }

    public ResponseStatus getResponseStatus() {
        return mResponseStatus;
    }

    public interface Result<T> {
        void onResult(DataResult<T> dataResult);
    }
}
