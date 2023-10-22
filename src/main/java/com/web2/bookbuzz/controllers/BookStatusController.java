package com.web2.bookbuzz.controllers;

import com.web2.bookbuzz.dto.responses.BookStatusResponseDTO;
import com.web2.bookbuzz.services.BookStatusService;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/book_status")
public class BookStatusController {

    private BookStatusService bookStatusService;

    public BookStatusController(BookStatusService bookStatusService) {
        this.bookStatusService = bookStatusService;
    }

    @GetMapping("/")
    public List<BookStatusResponseDTO> getBookStatus() {
        return bookStatusService.getAll();
    }
}
