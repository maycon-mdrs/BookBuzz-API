package com.web2.bookbuzz.services;

import com.web2.bookbuzz.models.BookClubMembersModel;
import com.web2.bookbuzz.repositories.BookClubMembersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookClubMembersService {
    private final BookClubMembersRepository bookClubMembersRepository;

    @Autowired
    public BookClubMembersService(BookClubMembersRepository bookClubMembersRepository) {
        this.bookClubMembersRepository = bookClubMembersRepository;
    }

    public List<BookClubMembersModel> getAllBookClubMembers(){return bookClubMembersRepository.findAll();}

    public BookClubMembersModel getBookClubMembersById(int id){
        Optional<BookClubMembersModel> optionalBookClub = bookClubMembersRepository.findById(id);
        return optionalBookClub.orElse(null);
    }

    public void addBookClubMembers(BookClubMembersModel bookClubMembers){
        bookClubMembersRepository.save(bookClubMembers);
    }

    public void updateBookClubMembers(int id, BookClubMembersModel bookClubMembers){
        if(bookClubMembersRepository.existsById(id)){
            bookClubMembersRepository.save(bookClubMembers);
        }
    }

    public void deleteBookClubMembers(int id) {
        if (bookClubMembersRepository.existsById(id)) {
            bookClubMembersRepository.deleteById(id);
        }
    }
}
