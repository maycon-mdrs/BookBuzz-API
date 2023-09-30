package com.web2.bookbuzz.controllers;

import com.web2.bookbuzz.models.BookModel;
import com.web2.bookbuzz.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {

    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/")
    public List<BookModel> getAllBooks() {
        return bookService.getAllBooks();
    }

    @GetMapping("/{id}")
    public BookModel getBookById(@PathVariable int id) {
        return bookService.getBookById(id);
    }

    @PostMapping("/")
    public void addBook(@RequestBody BookModel bookModel) {
        bookService.addBook(bookModel);
    }

    @PutMapping("/{id}")
    public void updateBook(@PathVariable int id, @RequestBody BookModel bookModel) {
        bookService.updateBook(id, bookModel);
    }

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable int id) {
        bookService.deleteBook(id);
    }
}
