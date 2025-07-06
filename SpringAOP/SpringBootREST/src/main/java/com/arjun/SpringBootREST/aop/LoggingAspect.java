package com.arjun.SpringBootREST.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {
    private static final Logger LOGGER  = LoggerFactory.getLogger(LoggingAspect.class);

    // return type full path name for the class.method name(args)

    @Before("execution(* com.arjun.SpringBootREST.service.JobService.*(..))")
    public void beforeMethodCall(JoinPoint jp) {
        LOGGER.info("Method called! {}", jp.getSignature().getName());
    }

    @After("execution(* com.arjun.SpringBootREST.service.JobService.*(..))")
    public void afterMethodCall(JoinPoint jp) {
        LOGGER.info("Method executed! {}", jp.getSignature().getName());
    }
}
