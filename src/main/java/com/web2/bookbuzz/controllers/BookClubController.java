package com.web2.bookbuzz.controllers;

import com.web2.bookbuzz.dto.requests.create.CreateBookClubRequest;
import com.web2.bookbuzz.dto.responses.BookClubResponse;
import com.web2.bookbuzz.error.EntityNotFoundException;
import com.web2.bookbuzz.models.BookClubModel;
import com.web2.bookbuzz.services.BookClubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import javax.swing.text.html.parser.Entity;

@RestController
@RequestMapping("/api/bookclub")
public class BookClubController {
    @Autowired
    private final BookClubService bookClubService;

    public BookClubController(BookClubService bookClubService) {
        this.bookClubService = bookClubService;
    }

    @GetMapping("/")
    public List<BookClubResponse> getAllBookClubs() {
        return bookClubService.getAllBookClubs();
    }

    @GetMapping("/{id}")
    public BookClubResponse getBookClubById(@PathVariable int id) {
        return bookClubService.getBookClubById(id);
    }

    @PostMapping("/")
    public ResponseEntity<?> addBookClub(@RequestBody CreateBookClubRequest bookClubModel) {
        try {
            return ResponseEntity.ok().body(bookClubService.addBookClub(bookClubModel));
        } catch (EntityNotFoundException e) {
            return e.getError();
        } catch (Exception e) {
            throw e;
        }
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
