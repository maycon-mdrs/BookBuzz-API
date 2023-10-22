package com.web2.bookbuzz.dto.responses;

import com.web2.bookbuzz.models.UserBookSituationModel;

public class UserBookSituationResponseDTO {
    int id;

    UserResponseDTO user_id;

    String book_id;

    BookStatusResponseDTO book_status_id;

    public UserBookSituationResponseDTO(UserBookSituationModel userBookSituation) {
        this.id = userBookSituation.getId();
        this.user_id = new UserResponseDTO(userBookSituation.getUserId());
        this.book_id = userBookSituation.getBookId();
        this.book_status_id = new BookStatusResponseDTO(userBookSituation.getStatusId());
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public UserResponseDTO getUser_id() {
        return user_id;
    }

    public void setUser_id(UserResponseDTO user_id) {
        this.user_id = user_id;
    }

    public String getBook_id() {
        return book_id;
    }

    public void setBook_id(String book_id) {
        this.book_id = book_id;
    }

    public BookStatusResponseDTO getBook_status_id() {
        return book_status_id;
    }

    public void setBook_status_id(BookStatusResponseDTO book_status_id) {
        this.book_status_id = book_status_id;
    }

}
