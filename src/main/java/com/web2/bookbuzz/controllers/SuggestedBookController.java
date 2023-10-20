package com.web2.bookbuzz.controllers;

import com.web2.bookbuzz.services.SuggestedBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT,
        RequestMethod.DELETE })
@RequestMapping("/api/suggestedbook")
public class SuggestedBookController {
    private final SuggestedBookService suggestedBookService;


    @Autowired
    public SuggestedBookController(SuggestedBookService suggestedBookService) {
        this.suggestedBookService = suggestedBookService;
    }
}
