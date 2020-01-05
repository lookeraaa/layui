package com.hjming.layui.util;

/**
 * 返回结果
 */
public class ResObject<T> {
    private Integer code;//结果编码 200：成功  500：失败
    private String message;//返回信息
    private Object data;

    public ResObject(Integer code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public ResObject(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public ResObject() {
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
