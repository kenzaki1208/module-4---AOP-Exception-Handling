package org.example.demo_aop_and_exception_handling.exercise.ex1.repository;

import org.example.demo_aop_and_exception_handling.exercise.ex1.model.Comment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findByDate(LocalDate date);
    Page<Comment> findByDate(LocalDate date, Pageable pageable);
}
