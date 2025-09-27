package org.example.demo_aop_and_exception_handling.exercise.ex2.repository;

import org.example.demo_aop_and_exception_handling.exercise.ex2.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
}
