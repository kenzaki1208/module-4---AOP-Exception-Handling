package org.example.demo_aop_and_exception_handling.practice.p2.repository;

import org.example.demo_aop_and_exception_handling.practice.p2.model.Customers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICustomersRepository extends JpaRepository<Customers, Long> {
    boolean findByEmail(String email);

    boolean existsByEmail(String email);
}
