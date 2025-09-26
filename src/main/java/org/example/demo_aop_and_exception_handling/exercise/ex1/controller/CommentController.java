package org.example.demo_aop_and_exception_handling.exercise.ex1.controller;

import org.example.demo_aop_and_exception_handling.exercise.ex1.model.Comment;
import org.example.demo_aop_and_exception_handling.exercise.ex1.service.ICommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@Controller
@RequestMapping("/exercise/ex1/commentBlogs")
public class CommentController {
    @Autowired
    private ICommentService commentService;

    @GetMapping("/page")
    public String home(@RequestParam(name = "page", defaultValue = "0") int page, Model model) {
        Pageable pageable = PageRequest.of(page, 3, Sort.by("id").descending());
        Page<Comment> comments = commentService.findToDayComments(pageable);
        model.addAttribute("comments", comments);
        model.addAttribute("newComment", new Comment());
        model.addAttribute("currentPage", page);
        return "/exercise/ex1/index";
    }

    @PostMapping("/comment")
    public String addComment(@ModelAttribute("newComment") Comment newComment) {
        newComment.setDate(LocalDate.now());
        commentService.save(newComment);
        return "redirect:/exercise/ex1/commentBlogs/page";
    }

    @PostMapping("/like/{id}")
    public String likeComment(@PathVariable("id") long id) {
        commentService.likes(id);
        return "redirect:/exercise/ex1/commentBlogs/page";
    }
}
