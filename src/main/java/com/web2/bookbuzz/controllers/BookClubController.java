package com.web2.bookbuzz.controllers;

import com.web2.bookbuzz.models.BookClubModel;
import com.web2.bookbuzz.services.BookClubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bookclub")
public class BookClubController {
    private final BookClubService bookClubService;

    @Autowired
    public BookClubController(BookClubService bookClubService) {
        this.bookClubService = bookClubService;
    }

    @GetMapping("/")
    public List<BookClubModel> getAllBookClubs() {
        return bookClubService.getAllBookClubs();
    }

    @GetMapping("/{id}")
    public BookClubModel getBookClubById(@PathVariable int id) {
        return bookClubService.getBookClubById(id);
    }

    @PostMapping("/")
    public void addBookClub(@RequestBody BookClubModel bookClubModel) {
        bookClubService.addBookClub(bookClubModel);
    }

    @PutMapping("/{id}")
    public void updateBook(@PathVariable int id, @RequestBody BookClubModel bookClubModel) {
        bookClubService.updateBookClub(id, bookClubModel);
    }

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable int id) {
        bookClubService.deleteBookClub(id);
    }
}

/* teste */
