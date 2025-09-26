package org.example.demo_aop_and_exception_handling.practice.p2.service;

import org.example.demo_aop_and_exception_handling.practice.p2.exception.DuplicateEmailException;

import java.util.List;

public interface IGenerateService<T> {
    List<T> findAll();
    void save(T t) throws DuplicateEmailException;
    T findById(Long id);
    void remove(Long id);
}
