package com.web2.bookbuzz.services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web2.bookbuzz.dto.responses.BookStatusResponseDTO;
import com.web2.bookbuzz.models.BookStatusModel;
import com.web2.bookbuzz.repositories.BookStatusRepository;

import java.util.ArrayList;

@Service
public class BookStatusService {
    @Autowired
    private final BookStatusRepository bookStatusRepository;

    public BookStatusService(BookStatusRepository bookStatusRepository) {
        this.bookStatusRepository = bookStatusRepository;
    }

    public List<BookStatusResponseDTO> getAll() {

        List<BookStatusResponseDTO> bookStatusResponseDTOList = new ArrayList<>();
        List<BookStatusModel> bookStatusModelList = bookStatusRepository.findAll();
        
        for (BookStatusModel bookStatusModel : bookStatusModelList) {
            BookStatusResponseDTO bookStatusResponseDTO = new BookStatusResponseDTO(bookStatusModel);
            bookStatusResponseDTOList.add(bookStatusResponseDTO);
        }
        
        return bookStatusResponseDTOList;
    }
}
