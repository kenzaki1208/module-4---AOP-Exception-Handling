package org.example.demo_aop_and_exception_handling.exercise.ex1.service;

import org.example.demo_aop_and_exception_handling.exercise.ex1.model.Comment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICommentService {
    void save(Comment comment);
    List<Comment> findToDayComments();
    void likes(long id);
    Comment findById(long id);
    Page<Comment> findToDayComments(Pageable pageable);
}
