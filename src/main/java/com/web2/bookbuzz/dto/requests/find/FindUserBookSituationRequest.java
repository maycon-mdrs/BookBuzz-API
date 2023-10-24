package com.web2.bookbuzz.dto.requests.find;

public record FindUserBookSituationRequest(Integer user_id, String book_id, Integer status_id) {
}
