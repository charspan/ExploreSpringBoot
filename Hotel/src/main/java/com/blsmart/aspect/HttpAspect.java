package com.blsmart.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by charspan on 16/03/2017.
 */
@Aspect
@Component
public class HttpAspect {

//    //.. 代表不管是什么参数都会被拦截
//    //public * com.blsmart.controller.GirlController.girlList(..)) 指定girlList方法
//    // * 所有方法
//    @Before("execution(public * com.blsmart.controller.GirlController.*(..))")
//    public void log(){
//        System.out.println(11111);
//    }
//
//    @After("execution(public * com.blsmart.controller.GirlController.*(..)))")
//    public void log1(){
//        System.out.println(2222);
//    }

    private final static Logger logger = LoggerFactory.getLogger(HttpAspect.class);

    @Pointcut("execution(public * com.blsmart.controller.GirlController.*(..))")
    public void filter() {

    }

    @Before("filter()")
    public void doBefore(JoinPoint joinPoint) {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
        HttpServletRequest request = (HttpServletRequest) attributes.getRequest();
        //url
        logger.info("url={}", request.getRequestURL());
        //method
        logger.info("method={}", request.getMethod());
        //ip
        logger.info("ip={}", request.getRemoteAddr());
        //类方法
        logger.info("class_method={}", joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
        //参数
        logger.info("args={}", joinPoint.getArgs());
    }

    @After("filter()")
    public void doAfter() {
        logger.info("doAfter");
    }

    //returning 就是入参
    @AfterReturning(returning = "object", pointcut = "filter()")
    public void doAfterReturning(Object object) {
        logger.info("response={}", object);

    }

}
