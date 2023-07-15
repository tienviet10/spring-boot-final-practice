package com.viettran.springbootfinalpractice.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Configuration
@Aspect
public class LoggingAspect {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Before("com.viettran.springbootfinalpractice.aop.CommonPointcutConfig.allServicePackageConfigUsingBean()")
    public void logMethodCallBeforeExecution(JoinPoint joinPoint) {
        logger.info("BEFORE Aspect - {} is CALLED with arguments: {}"
                , joinPoint, joinPoint.getArgs());//WHAT
    }

    @After("com.viettran.springbootfinalpractice.aop.CommonPointcutConfig.servicePackageConfig()")
    public void logMethodCallAfterExecution(JoinPoint joinPoint) {
        logger.info("AFTER Aspect - {} has EXECUTED", joinPoint);
    }

    @AfterThrowing(pointcut = "com.viettran.springbootfinalpractice.aop.CommonPointcutConfig.servicePackageConfig()", throwing = "exception")
    public void logMethodCallAfterException(JoinPoint joinPoint, Exception exception) {
        logger.info("AFTERTHROWING Aspect - {} has THROWN an exception {}"
                , joinPoint, exception);
    }

    @AfterReturning(
            pointcut = "com.viettran.springbootfinalpractice.aop.CommonPointcutConfig.dataPackageConfig()",
            returning = "resultValue"
    )
    public void logMethodCallAfterSuccessfulExecution(JoinPoint joinPoint, Object resultValue) {
        logger.info("AFTERRETURNING Aspect - {} has returned {}"
                , joinPoint, resultValue);
    }
}
