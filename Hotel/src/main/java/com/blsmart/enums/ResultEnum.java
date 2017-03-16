package com.blsmart.enums;

/**
 * Created by charspan on 16/03/2017.
 */
public enum ResultEnum {

    UNKOW_ERROR(-1, "未知错误"),
    SUCCESS(0, "成功"),
    PRIMARY_SCHOOL(100, "你可能在上小学"),
    MIDDLE_SCHOOL(101, "你可能在上初中"),
    HIGHT_SCHOOL(102, "你可能在上大学");

    private Integer code;
    private String msg;

    ResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

}
