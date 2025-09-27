package org.example.demo_aop_and_exception_handling.exercise.ex2.exception;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

//@Component("ex2GlobalExceptionHandler")
@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice(basePackages = "org.example.demo_aop_and_exception_handling.exercise.ex2.controller")
public class GlobalExceptionHandlerEx2 {

    @ExceptionHandler(BookNotAvailableException.class)
    public String handleBookNotAvailable(BookNotAvailableException ex, Model model) {
        model.addAttribute("errorMessage", ex.getMessage());
        return "exercise/ex2/error123";
    }

    @ExceptionHandler(Exception.class)
    public String handleGeneral(Exception ex, Model model) {
        model.addAttribute("errorMessage", "Có lỗi xảy ra: " + ex.getMessage());
        return "exercise/ex2/error123";
    }
}
