package com.web2.bookbuzz.controllers;

import com.web2.bookbuzz.dto.requests.BookRequestDTO;
import com.web2.bookbuzz.models.BookModel;
import com.web2.bookbuzz.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/books")
public class BookController {

    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/")
    @ResponseBody
    public List<BookModel> getAllBooks(
            @RequestParam(required = false) String title,
            @RequestParam(required = false) String author,
            @RequestParam(required = false) String genre) {
        BookRequestDTO requestDTO = new BookRequestDTO(title, author, genre);
        return bookService.getAllBooks(requestDTO);
    }

    @GetMapping("/genres")
    public List<String> getAllGenres() {
        return bookService.findAllGenres();
    }

    @GetMapping("/{id}")
    public BookModel getBookById(@PathVariable int id) {
        return bookService.getBookById(id);
    }

    @PostMapping("/")
    public BookModel addBook(@RequestBody BookModel bookModel) {
        return bookService.addBook(bookModel);
    }

    @PutMapping("/{id}")
    public BookModel updateBook(@PathVariable int id, @RequestBody BookModel bookModel) {
        return bookService.updateBook(id, bookModel);
    }

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable int id) {
        bookService.deleteBook(id);
    }
}
