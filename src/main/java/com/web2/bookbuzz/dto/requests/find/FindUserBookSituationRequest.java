package com.web2.bookbuzz.dto.requests.find;

public class FindUserBookSituationRequest {
    Integer user_id;

    String book_id;

    Integer status_id;

    public FindUserBookSituationRequest() {
    }

    public FindUserBookSituationRequest(Integer user_id, String book_id, Integer status_id) {
        this.user_id = user_id;
        this.book_id = book_id;
        this.status_id = status_id;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public String getBook_id() {
        return book_id;
    }

    public void setBook_id(String book_id) {
        this.book_id = book_id;
    }

    public Integer getStatus_id() {
        return status_id;
    }

    public void setStatus_id(Integer status_id) {
        this.status_id = status_id;
    }

}
