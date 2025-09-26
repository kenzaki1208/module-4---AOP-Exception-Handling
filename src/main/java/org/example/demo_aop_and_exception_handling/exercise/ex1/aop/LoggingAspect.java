package org.example.demo_aop_and_exception_handling.exercise.ex1.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.example.demo_aop_and_exception_handling.exercise.ex1.model.Comment;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Aspect
@Component
public class LoggingAspect {
    @AfterThrowing(pointcut = "execution(* org.example.demo_aop_and_exception_handling.exercise.ex1.service.CommentService.save(..))",
            throwing = "ex")
    public void logBadWord(JoinPoint joinPoint, RuntimeException ex) {
        Object[] args = joinPoint.getArgs();
        if (args.length > 0 && args[0] instanceof Comment comment) {
            System.err.println("🚨 BAD WORD DETECTED 🚨");
            System.err.println("Author: " + comment.getAuthor());
            System.err.println("Feedback: " + comment.getFeedback());
            System.err.println("Date: " + LocalDateTime.now());
            System.err.println("Error: " + ex.getMessage());
        }
    }
}
