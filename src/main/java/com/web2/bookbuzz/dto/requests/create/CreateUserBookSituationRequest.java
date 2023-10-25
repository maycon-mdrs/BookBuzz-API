package com.web2.bookbuzz.dto.requests.create;

public record CreateUserBookSituationRequest(int user_id, String book_id, int status_id) {
}
