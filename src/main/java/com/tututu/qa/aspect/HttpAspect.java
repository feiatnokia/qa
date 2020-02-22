package com.tututu.qa.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * @program: qa
 * @description:
 * @author: 玉麒麟
 * @create: 2020-02-22 23:11
 **/
@Aspect
@Component
public class HttpAspect {

    public static final Logger logger = LoggerFactory.getLogger(HttpAspect.class);

    @Pointcut("execution(public * com.tututu.qa.controller.*.*(..))")
    public void log(){

    }

    @Before("log()")
    public void doBefore(JoinPoint joinPoint){
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        requestAttributes.getRequest();
        logger.info("request parameters: " + requestAttributes.getRequest().getRequestURL());
        logger.info("request parameters: " + requestAttributes.getRequest().getMethod());
        logger.info("request parameters: " + joinPoint.getArgs());
    }

    @After("log()")
    public void doAfter(){
        logger.info("response parameters: ");
    }
}
