package com.stranger.enums;

public enum ResultEnum {
    UNKONW_ERROR ("-1","未知错误"),
    ERROR("1","失败"),
   SUCCESS("0","成功"),
    PRIMARY_SCHOOL("100","你应该在上小学"),
    MIDDLE_SCHOOL("101","你在上中学"),
    HIGHT_SCHOOL("102","你在上高中吧")
    ;
    private String code;
    private String msg;
    ResultEnum(String code,String msg){
        this.code=code;
        this.msg=msg;
    }

    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
