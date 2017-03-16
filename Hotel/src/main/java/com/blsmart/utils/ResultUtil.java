package com.blsmart.utils;

import com.blsmart.domain.Result;

/**
 * Created by charspan on 16/03/2017.
 */
public class ResultUtil {

    public static Result success(Object object){
        Result result=new Result();
        result.setCode(0);
        result.setMag("成功");
        result.setData(object);
        return result;
    }

    public static Result success(){
        return success(null);
    }

    public static Result error(Integer code,String msg){
        Result result=new Result();
        result.setCode(code);
        result.setMag(msg);
        return result;
    }

}
