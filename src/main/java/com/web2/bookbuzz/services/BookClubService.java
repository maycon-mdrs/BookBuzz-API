package com.web2.bookbuzz.services;

import com.web2.bookbuzz.models.BookClubModel;
import com.web2.bookbuzz.repositories.BookClubRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookClubService {

    private final BookClubRepository bookClubRepository;

    @Autowired
    public BookClubService(BookClubRepository bookClubRepository) {
        this.bookClubRepository = bookClubRepository;
    }

    public List<BookClubModel> getAllBookClubs(){return bookClubRepository.findAll();}

    public BookClubModel getBookClubById(int id){
        Optional<BookClubModel>  optionalBookClub = bookClubRepository.findById(id);
        return optionalBookClub.orElse(null);
    }

    public void addBookClub(BookClubModel bookClub){
        bookClubRepository.save(bookClub);
    }

    public void updateBookClub(int id, BookClubModel bookClub){
        if(bookClubRepository.existsById(id)){
            bookClubRepository.save(bookClub);
        }
    }

    public void deleteBookClub(int id){
        if(bookClubRepository.existsById(id)){
            bookClubRepository.deleteById(id);
        }
    }
}
