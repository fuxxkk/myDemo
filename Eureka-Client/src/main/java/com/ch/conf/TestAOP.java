//package com.ch.conf;
//
//import org.aspectj.lang.ProceedingJoinPoint;
//import org.aspectj.lang.annotation.Around;
//import org.aspectj.lang.annotation.Aspect;
//import org.aspectj.lang.annotation.Pointcut;
//import org.springframework.context.annotation.Configuration;
//
//@Aspect
//@Configuration
//public class TestAOP {
//
//  @Pointcut("execution(public com.ch.controller.* *(..))")
//  public void excudeService(){}
//  @Around("excudeService()")
//  public Object handlerControllerMethod(ProceedingJoinPoint pjp){
//    try {
//      pjp.proceed();
//    } catch (final Throwable e) {
//      e.printStackTrace();
//    }
//    return null;
//  }
//
//
//  @SuppressWarnings("unused")
//  private void handlerException(ProceedingJoinPoint pjp, Throwable e) {
//    throw new RuntimeException(e.getMessage());
//  }
//}
