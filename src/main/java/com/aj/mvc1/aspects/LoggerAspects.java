package com.aj.mvc1.aspects;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.Instant;

@Slf4j
@Aspect
@Component
public class LoggerAspects {

    @Around(value = "execution(* com.aj.mvc1..*.*(..))")
    public Object log(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {

        log.info(">>> " + proceedingJoinPoint.getSignature().toString() + " method execution start.");
        Instant start = Instant.now();
        Object object = proceedingJoinPoint.proceed();
        Instant finish = Instant.now();
        long timeElapsed = Duration.between(start, finish).toMillis();
        log.info("--- Time took to execute " + proceedingJoinPoint.getSignature().toString() + " method is : "+timeElapsed);
        log.info("<<< " + proceedingJoinPoint.getSignature().toString() + " method execution ends.");

        return object;
    }

    @AfterThrowing(value = "execution(* com.aj.mvc1.*.*(..))",throwing = "ex")
    public void logException(JoinPoint joinPoint, Exception ex) {
        log.error(joinPoint.getSignature()+ " An exception happened due to : "+ex.getMessage());
    }
}
