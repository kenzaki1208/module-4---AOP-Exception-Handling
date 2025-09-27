package org.example.demo_aop_and_exception_handling.exercise.ex2.service;

import org.example.demo_aop_and_exception_handling.exercise.ex2.exception.BookNotAvailableException;
import org.example.demo_aop_and_exception_handling.exercise.ex2.model.Book;
import org.example.demo_aop_and_exception_handling.exercise.ex2.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    public Book save(Book book) {
        return bookRepository.save(book);
    }

    public void borrowBook(Long id) {
        Book book = bookRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Không tìm thấy sách")
        );
        if (book.getQuantity() <= 0) {
            throw new BookNotAvailableException("Sách '" + book.getTitle() + "' đã hết!");
        }
        book.setQuantity(book.getQuantity() - 1);
        bookRepository.save(book);
    }

    public void returnBook(Long id) {
        Book book = bookRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Không tìm thấy sách")
        );
        book.setQuantity(book.getQuantity() + 1);
        bookRepository.save(book);
    }
}