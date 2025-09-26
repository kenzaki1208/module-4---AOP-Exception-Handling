package org.example.demo_aop_and_exception_handling.exercise.ex1.exception;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(RuntimeException.class)
    public String handleBadWordException(RuntimeException ex, Model model) {
        model.addAttribute("message", ex.getMessage());
        return "/exercise/ex1/error";
    }
}