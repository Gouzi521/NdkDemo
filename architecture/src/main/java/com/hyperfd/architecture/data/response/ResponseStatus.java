package com.hyperfd.architecture.data.response;

/**
 * @Description TODO
 * @Author ma
 * @Date 2021/3/4 16:43
 */
public class ResponseStatus {

    private String responseCode="";
    private boolean success=true;
    private Enum source=ResultSource.NETWORK;


    public ResponseStatus(){

    }

    public ResponseStatus(String responseCode, boolean success) {
        this.responseCode = responseCode;
        this.success = success;
    }

    public ResponseStatus(String responseCode, boolean success, Enum source) {
        this.responseCode = responseCode;
        this.success = success;
        this.source = source;
    }

    public String getResponseCode() {
        return responseCode;
    }

    public boolean isSuccess() {
        return success;
    }

    public Enum getSource() {
        return source;
    }

    /**
     * @Description TODO
     * @Author ma
     * @Date 2021/3/4 16:40
     */
    public static class DataResult<T> {

        private T mEntity;
        private ResponseStatus mResponseStatus;

        public DataResult(T mEntity, ResponseStatus mResponseStatus) {
            this.mEntity = mEntity;
            this.mResponseStatus = mResponseStatus;
        }

        public T getmEntity() {
            return mEntity;
        }

        public ResponseStatus getmResponseStatus() {
            return mResponseStatus;
        }

        public interface Result<T>{
            void onResult(DataResult<T> dataResult);
        }
    }
}
