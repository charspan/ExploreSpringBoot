package com.blsmart.domain;

/**
 * http 请求返回的最外层对象
 * Created by charspan on 16/03/2017.
 */
public class Result<T> {

    /**
     * 错误码
     */
    private Integer code;
    /**
     * 提示信息
     */
    private String mag;
    /**
     * 具体内容
     */
    private T data;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMag() {
        return mag;
    }

    public void setMag(String mag) {
        this.mag = mag;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Result{" +
                "code=" + code +
                ", mag='" + mag + '\'' +
                ", data=" + data +
                '}';
    }
}
