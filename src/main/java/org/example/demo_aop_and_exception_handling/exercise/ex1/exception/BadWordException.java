package org.example.demo_aop_and_exception_handling.exercise.ex1.exception;

public class BadWordException extends RuntimeException{
    public BadWordException(String message) {
        super(message);
    }
}
