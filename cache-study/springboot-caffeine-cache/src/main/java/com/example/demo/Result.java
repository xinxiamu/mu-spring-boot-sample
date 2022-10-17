package com.example.demo;

/**
 * 统一API响应结果封装
 */
public class Result<T> {
    /**
     * 响应编号，参考ResultCode
     */
    private int code;
    /**
     * 消息
     */
    private String message;
    /**
     * 数据
     */
    private T data;

    private Boolean success;

    public Result(int code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
        this.success = isSuccess();
    }

    public boolean isSuccess() {
        return this.code == 200;
    }
}
