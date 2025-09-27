package org.example.demo_aop_and_exception_handling.exercise.ex2.controller;

import jakarta.validation.Valid;
import org.example.demo_aop_and_exception_handling.exercise.ex2.model.Book;
import org.example.demo_aop_and_exception_handling.exercise.ex2.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/exercise/ex2/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("")
    public String listBooks(Model model) {
        model.addAttribute("books", bookService.findAll());
        model.addAttribute("newBook", new Book());
        return "/exercise/ex2/list";
    }

    @PostMapping("/add")
    public String addBook(@Valid @ModelAttribute("newBook") Book newBook,
                          BindingResult result,
                          Model model) {
        if (result.hasErrors()) {
            model.addAttribute("books", bookService.findAll());
            return "/exercise/ex2/list";
        }
        bookService.save(newBook);
        return "redirect:/exercise/ex2/books";
    }

    @GetMapping("/borrow/{id}")
    public String borrowBook(@PathVariable("id") Long id) {
        bookService.borrowBook(id);
        return "redirect:/exercise/ex2/books";
    }

    @GetMapping("/return/{id}")
    public String returnBook(@PathVariable("id") Long id) {
        bookService.returnBook(id);
        return "redirect:/exercise/ex2/books";
    }
}
