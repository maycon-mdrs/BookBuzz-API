package com.web2.bookbuzz.dto.requests.create;

public class CreateUserBookSituationRequest {

    int user_id;

    String book_id;

    int status_id;

    public CreateUserBookSituationRequest(int i) {
    }

    public CreateUserBookSituationRequest(int user_id, String book_id, int status_id) {
        this.user_id = user_id;
        this.book_id = book_id;
        this.status_id = status_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getBook_id() {
        return book_id;
    }

    public void setBook_id(String book_id) {
        this.book_id = book_id;
    }

    public int getStatus_id() {
        return status_id;
    }

    public void setStatus_id(int status_id) {
        this.status_id = status_id;
    }

}
