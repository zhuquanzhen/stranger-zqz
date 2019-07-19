package com.stranger.util;

import com.stranger.domain.Result;
import com.stranger.enums.ResultEnum;

public class ResultUtil {
    public static Result success(Object object){
        Result result=new Result();
        result.setCode(ResultEnum.SUCCESS.getCode());
        result.setMsg(ResultEnum.SUCCESS.getMsg());
        result.setData(object);
        return result;
    }
    public static Result success(){
        return success(null);
    }
    public static Result error(String code ,String msg){
        Result result=new Result();
        result.setCode(code);
        result.setMsg(msg);
        result.setData(null);
        return result;
    }
}
