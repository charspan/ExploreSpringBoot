package com.blsmart.exception;

import com.blsmart.enums.ResultEnum;

/**
 * Created by charspan on 16/03/2017.
 */
//spring 要求你必须继承 RuntimeException
public class GirlException extends RuntimeException {

    private Integer code;

    public GirlException(ResultEnum resultEnum) {
        super(resultEnum.getMsg());
        this.code = resultEnum.getCode();
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
