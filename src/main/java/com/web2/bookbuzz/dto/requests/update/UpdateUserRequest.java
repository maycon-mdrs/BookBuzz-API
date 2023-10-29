package com.web2.bookbuzz.dto.requests.update;

public record UpdateUserRequest(String name, String url_photo, String email, String password) {
}
