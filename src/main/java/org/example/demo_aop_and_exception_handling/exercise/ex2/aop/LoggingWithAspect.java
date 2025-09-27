package org.example.demo_aop_and_exception_handling.exercise.ex2.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingWithAspect {

    private int visitCount = 0;

    @Before("execution(* org.example.demo_aop_and_exception_handling.exercise.ex2.controller.*.*(..))")
    public void logVisit(JoinPoint joinPoint) {
        visitCount++;
        System.out.println("👤 Visit #" + visitCount + " | Method: " + joinPoint.getSignature().getName());
    }

    @After("execution(* org.example.demo_aop_and_exception_handling.exercise.ex2.service.BookService.*(..))")
    public void logServiceAction(JoinPoint joinPoint) {
        System.out.println("📚 Service executed: " + joinPoint.getSignature().getName());
    }

    @AfterThrowing(pointcut = "execution(* org.example.demo_aop_and_exception_handling.exercise.ex2.service.*.*(..))", throwing = "ex")
    public void logException(JoinPoint joinPoint, Exception ex) {
        System.err.println("❌ Exception in " + joinPoint.getSignature().getName() + " | " + ex.getMessage());
    }
}
