package com.web2.bookbuzz.services;


import com.web2.bookbuzz.repositories.SuggestedBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SuggestedBookService {
    private final SuggestedBookRepository suggestedBookRepository;

    @Autowired
    public SuggestedBookService(SuggestedBookRepository suggestedBookRepository){
        this.suggestedBookRepository = suggestedBookRepository;

    }
}
