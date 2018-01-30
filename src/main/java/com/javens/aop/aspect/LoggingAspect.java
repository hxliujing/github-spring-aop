package com.javens.aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
public class LoggingAspect {
    protected static final Logger logger = LoggerFactory.getLogger(LoggingAspect.class);
    @Pointcut("execution(* com.javens.aop..*(..))")
    public void pt(){}

    @Before(value = "pt()")
    public void logBefore(JoinPoint joinPoint){
        logger.info("========before============");
        logger.info("========before============"+joinPoint.getSignature().getName());
    }

    @After(value = "pt()")
    public void logAfter(JoinPoint joinPoint){
        logger.info("========after============");
        logger.info("========after============"+joinPoint.getSignature().getName());
    }

    @AfterReturning(value = "pt()", returning = "result")
    public void logAfterReturning(JoinPoint joinPoint,Object result){
        logger.info("========afterReturning============");
        logger.info("========afterReturning============"+joinPoint.getSignature().getName());
        logger.info("========afterReturning Result============"+result);
    }


    @AfterThrowing(value = "pt()", throwing = "error")
    public void logAfterThrowing(JoinPoint joinPoint,Throwable error){
        logger.info("========afterThrowing============");
        logger.info("========afterThrowing============"+joinPoint.getSignature().getName());
        logger.info("========Exception============"+error);
    }


    @Around(value = "pt()")
    public void logAround(ProceedingJoinPoint joinPoint) throws Throwable{
        logger.info("========around============");
        logger.info("========around============"+joinPoint.getSignature().getName());
        logger.info("========around============"+ Arrays.toString(joinPoint.getArgs()));

        logger.info("========around before is running============");
        joinPoint.proceed();
        logger.info("========around after is running============");
    }
}
