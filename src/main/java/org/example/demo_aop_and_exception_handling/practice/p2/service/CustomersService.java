package org.example.demo_aop_and_exception_handling.practice.p2.service;

import org.example.demo_aop_and_exception_handling.practice.p2.exception.DuplicateEmailException;
import org.example.demo_aop_and_exception_handling.practice.p2.model.Customers;
import org.example.demo_aop_and_exception_handling.practice.p2.repository.ICustomersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomersService implements ICustomersService {
    @Autowired
    private ICustomersRepository iCustomersRepository;


    @Override
    public List<Customers> findAll() {
        return iCustomersRepository.findAll();
    }

    @Override
    public void save(Customers customer) throws DuplicateEmailException {
        try {
            if (iCustomersRepository.existsByEmail(customer.getEmail())) {
                throw new DuplicateEmailException();
            }
            iCustomersRepository.save(customer);
        } catch (DataIntegrityViolationException e) {
            throw new RuntimeException();
        }
    }

    @Override
    public Customers findById(Long id) {
        return iCustomersRepository.findById(id).get();
    }

    @Override
    public void remove(Long id) {
        iCustomersRepository.deleteById(id);
    }
}
