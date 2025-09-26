package org.example.demo_aop_and_exception_handling.exercise.ex1.service;

import org.example.demo_aop_and_exception_handling.exercise.ex1.model.Comment;
import org.example.demo_aop_and_exception_handling.exercise.ex1.repository.CommentRepository;
import org.example.demo_aop_and_exception_handling.exercise.ex1.util.BadWordFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class CommentService implements ICommentService {
    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private BadWordFilter badWordFilter;

    @Override
    public void save(Comment comment) {
        badWordFilter.validate(comment.getFeedback());
        commentRepository.save(comment);
    }

    @Override
    public List<Comment> findToDayComments() {
        return commentRepository.findByDate(LocalDate.now());
    }

    @Override
    public void likes(long id) {
        Comment commentJPA = commentRepository.findById(id).orElse(null);
        if (commentJPA != null) {
            commentJPA.setLikes(commentJPA.getLikes() + 1);
            commentRepository.save(commentJPA);
        }
    }

    @Override
    public Comment findById(long id) {
        return commentRepository.findById(id).orElse(null);
    }

    @Override
    public Page<Comment> findToDayComments(Pageable pageable) {
        return commentRepository.findByDate(LocalDate.now(), pageable);
    }
}
