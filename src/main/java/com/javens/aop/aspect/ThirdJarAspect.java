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
public class ThirdJarAspect {
    protected static final Logger logger = LoggerFactory.getLogger(ThirdJarAspect.class);

    @Around("execution(* org.springframework.aop.support..*(..))")
    public void logAround(ProceedingJoinPoint joinPoint) throws Throwable{
        logger.info("========around============");
        logger.info("========around============"+joinPoint.getSignature().getName());
        logger.info("========around============"+ Arrays.toString(joinPoint.getArgs()));

        logger.info("========around before is running============");
        joinPoint.proceed();
        logger.info("========around after is running============");
    }
}
