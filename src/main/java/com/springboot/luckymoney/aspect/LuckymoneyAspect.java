package com.springboot.luckymoney.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LuckymoneyAspect {

    private final static Logger logger = LoggerFactory.getLogger(LuckymoneyAspect.class);

//    @Before("execution(* com.springboot.luckymoney.controller.LuckymoneyController.getlist(..))")
//    public void log(){
//        System.out.println(111111);
//    }
//
//    @After("execution(public * com.springboot.luckymoney.controller.LuckymoneyController.*(..))")
//    public void log2(){
//        System.out.println(222222);
//    }

    @Pointcut("execution(public * com.springboot.luckymoney.controller.LuckymoneyController.*(..))")
    public void log(){}

    @Before("log()")
    public void doBefore(){
//        System.out.println(1111111111);
        logger.info("111111111111111");
    }
    @After("log()")
    public void doAfter(){
//        System.out.println(222222222);
        logger.info("22222222222222222");
    }
}
