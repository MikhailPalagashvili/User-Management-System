package com.grantcs.usermanagementsystem.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class LogAspect {
    /**
     * Log output before executing the service.
     * Target:[UserService] is included in the class name.
     */
    @Before("execution(* *..*.*UserService.*(..))")
    public void startLog(JoinPoint joinPoint) {
        log.info("Method start: " + joinPoint.getSignature());
    }

    /**
     * Log output after executing the service.
     * Target:[UserService] is included in the class name.
     */
    @After("execution(* *..*.*UserService.*(..))")
    public void endLog(JoinPoint joinpoint) {
        log.info("Method end: " + joinpoint.getSignature());
    }

    /**
     * Log output before and after the controller is executed
     */
    @Around("bean(*Controller)")
    public Object startLog(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        // Output start log
        log.info("Method start: " + proceedingJoinPoint.getSignature());

        try {
            // Method execution
            Object result = proceedingJoinPoint.proceed();

            // Output end log
            log.info("Method end: " + proceedingJoinPoint.getSignature());

            // Return the execution result to the caller
            return result;
        } catch (Exception exception) {
            // Output error log
            log.error("Method abend: " + proceedingJoinPoint.getSignature());

            // Rethrow the error
            throw exception;
        }
    }
}
