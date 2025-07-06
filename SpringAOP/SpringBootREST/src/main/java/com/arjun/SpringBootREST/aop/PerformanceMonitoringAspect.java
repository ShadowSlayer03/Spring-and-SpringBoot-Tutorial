package com.arjun.SpringBootREST.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class PerformanceMonitoringAspect {

    private static final Logger LOGGER= LoggerFactory.getLogger(PerformanceMonitoringAspect.class);

    @Around("execution(* com.arjun.SpringBootREST.service.JobService.*(..))")
    public Object monitorTime(ProceedingJoinPoint pjp) throws Throwable {
        long start = System.currentTimeMillis();

        Object obj = pjp.proceed();

        long end = System.currentTimeMillis();

        LOGGER.info("Time taken by method {}: {} ms", pjp.getSignature().getName(), (end - start));

        return obj;
    }
}
