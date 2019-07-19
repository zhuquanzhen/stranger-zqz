package com.stranger.Exception;

import com.stranger.enums.ResultEnum;

/*
自己定义异常
* */
public class GirlException extends RuntimeException {
    private String code;
    public GirlException(ResultEnum resultEnum){
        super(resultEnum.getMsg());
        this.code=resultEnum.getCode();
    }
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "GirlException{" +
                "code='" + code + '\'' +
                '}';
    }
}
