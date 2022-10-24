package com.junho.customerrelationshipmanager.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class CRMLoggingAspect {

    // set up pointcut declarations
    @Pointcut("execution(* com.junho.customerrelationshipmanager.controller.*.*(..))")
    private void forControllerPackage() {}

    @Pointcut("execution(* com.junho.customerrelationshipmanager.service.*.*(..))")
    private void forServicePackage() {}

    @Pointcut("execution(* com.junho.customerrelationshipmanager.repository.*.*(..))")
    private void forDaoPackage() {}

    @Pointcut("forControllerPackage() || forServicePackage() || forDaoPackage()")
    private void forAppFlow() {}

    @Before("forAppFlow()")
    public void before(JoinPoint theJoinPoint) {
        
        String theMethod = theJoinPoint.getSignature().toShortString();
        log.info("=====>> 메소드 실행 전: " + theMethod);


        Object[] args = theJoinPoint.getArgs();

        for (Object tempArg : args) {
            log.info("====>> argument: "+ tempArg );
        }
    }

    @AfterReturning(
            pointcut = "forAppFlow()",
            returning = "theResult" )
    public void afterReturning(JoinPoint theJoinPoint, Object theResult) {

        // display method we are returning from
        String theMethod = theJoinPoint.getSignature().toShortString();
        log.info("=====>> 메소드 실행 후 " + theMethod);

        // display data returned
        log.info("====>> result: " + theResult);
    }
}