package com.web2.bookbuzz.dto.responses;

import com.web2.bookbuzz.models.BookStatusModel;

public class BookStatusResponseDTO {
    private int id;
    private String description;

    public BookStatusResponseDTO(BookStatusModel bookStatus) {
        this.id = bookStatus.getId();
        this.description = bookStatus.getDescription();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
