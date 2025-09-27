package org.example.demo_aop_and_exception_handling.exercise.ex2.exception;

public class BookNotAvailableException extends RuntimeException {
    public BookNotAvailableException(String msg) {
        super(msg);
    }
}
