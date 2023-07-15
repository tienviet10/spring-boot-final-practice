package com.viettran.springbootfinalpractice.aop;

import org.aspectj.lang.annotation.Pointcut;

public class CommonPointcutConfig {
    // Intercept base on package name
    @Pointcut("execution(* com.viettran.springbootfinalpractice.service.*.*(..))")
    public void servicePackageConfig() {
    }

    @Pointcut("execution(* com.viettran.springbootfinalpractice.repository.*.*(..))")
    public void dataPackageConfig() {
    }

    // Intercept based on name of the bean
    @Pointcut("bean(*Service*)")
    public void allServicePackageConfigUsingBean() {
    }

    @Pointcut("@annotation(com.viettran.springbootfinalpractice.aop.TrackTime)")
    public void trackTimeAnnotation() {
    }
}
