package com.viettran.springbootfinalpractice.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Configuration
@Aspect
public class PerformanceTrackingAspect {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    //// Intercept all methods in the service package
    //    @Around("execution(* com.viettran.springbootfinalpractice.service.*.*(..))")

    // ONLY intercept methods that are annotated with @TrackTime
    @Around("com.viettran.springbootfinalpractice.aop.CommonPointcutConfig.trackTimeAnnotation()")
    public Object findExecutionTime(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        //Start a timer
        long startTimeMillis = System.currentTimeMillis();

        //Execute the method
        Object returnValue = proceedingJoinPoint.proceed();

        //Stop the timer
        long stopTimeMillis = System.currentTimeMillis();

        long executionDuration = stopTimeMillis - startTimeMillis;

        logger.info("AROUND Aspect - {} Method executed in {} ms"
                , proceedingJoinPoint, executionDuration);

        return returnValue;
    }
}
