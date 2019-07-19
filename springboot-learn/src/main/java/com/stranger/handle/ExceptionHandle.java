package com.stranger.handle;

import com.stranger.Exception.GirlException;
import com.stranger.domain.Result;
import com.stranger.util.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

//异常捕获
/*
* 在spring 3.2中，新增了@ControllerAdvice 注解，
* 可以用于定义@ExceptionHandler、@InitBinder、@ModelAttribute，
* 并应用到所有@RequestMapping中。参考：@ControllerAdvice 文档*/
@ControllerAdvice
public class ExceptionHandle {
    private final static Logger logger= LoggerFactory.getLogger(ExceptionHandle.class);
    /**
     * 全局异常捕捉处理
     * @param
     * @return
     */
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Result hadle(Exception e){
        if(e instanceof GirlException) {
            GirlException  ex=(GirlException) e;
            return ResultUtil.error(ex.getCode(), ex.getMessage());
        }else{
            System.out.println("系统异常");
            logger.info("[系统异常]{}",e);
            return ResultUtil.error("-1","未知错误");
        }
    }
}
