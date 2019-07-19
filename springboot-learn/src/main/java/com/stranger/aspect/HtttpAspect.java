package com.stranger.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Aspect
@Component
public class HtttpAspect {
    private final static Logger logger= LoggerFactory.getLogger(HtttpAspect.class);//spring自带的日志类

    @Pointcut("execution(public * com.stranger.controller.GirlController.insertGirl(..))")//..表示该方法的任何参数都会被拦截希望类中的所有方法都被拦截使用
    //public * com.stranger.controller.GirlController.*(..)
    public void  log(){
    }
    //为了减少重复代码使用可以改造
    @Before("log()")
    public void  logtwo(JoinPoint joinPoint){
        //处理请求
        //url,ip,method,param
        ServletRequestAttributes attributes= (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
        HttpServletRequest request=attributes.getRequest();
        //url
        logger.info("url={}",request.getRequestURI());
        //method
        logger.info("method={}",request.getMethod());
        //ip
        logger.info("ip={}",request.getRemoteAddr());
        //类方法
        logger.info("class_method={}",joinPoint.getSignature().getDeclaringTypeName()+"."+joinPoint.getSignature().getName());//类名加类方法
        //参数
        logger.info("class_parm{}",joinPoint.getArgs());
    }
    @After("log()")
    public void  logtth(){
        logger.info("切口后执行");
    }
    @AfterReturning(returning = "object",pointcut = "log()")//获取返回值
    public void doAfterReturn(Object object){
        logger.info("response={}",object.toString());
    }
}
