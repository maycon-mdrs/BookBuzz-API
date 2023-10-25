package com.web2.bookbuzz.controllers;

import com.web2.bookbuzz.dto.requests.BookClubMemberRequestDTO;
import com.web2.bookbuzz.models.BookClubMembersModel;
import com.web2.bookbuzz.services.BookClubMembersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bookclubmembers")
public class BookClubMembersController {
    @Autowired
    private final BookClubMembersService bookClubMembersService;

    public BookClubMembersController(BookClubMembersService bookClubMembersService) {
        this.bookClubMembersService = bookClubMembersService;
    }

    @GetMapping("/")
    public List<BookClubMembersModel> getAllBookClubMembers(
            @RequestParam(required = false) Integer clubId,
            @RequestParam(required = false) Integer userId
    ){
        BookClubMemberRequestDTO requestDTO = new BookClubMemberRequestDTO(userId, clubId);
        return bookClubMembersService.getAllBookClubMembers(requestDTO);
    }

    @GetMapping("/{id}")
    public BookClubMembersModel getBookClubById(@PathVariable int id){
        return bookClubMembersService.getBookClubMembersById(id);
    }

    @PostMapping("/")
    public void addBookClubMembers(@RequestBody BookClubMembersModel bookClubMembersModel){
        bookClubMembersService.addBookClubMembers(bookClubMembersModel);
    }

    @PutMapping("/{id}")
    public void updateBookClubMembers(@PathVariable int id, @RequestBody BookClubMembersModel bookClubMembersModel) {
        bookClubMembersService.updateBookClubMembers(id, bookClubMembersModel);
    }

    @DeleteMapping("/{id}")
    public void deleteBookClubMembers(@PathVariable int id) {
        bookClubMembersService.deleteBookClubMembers(id);
    }
}
