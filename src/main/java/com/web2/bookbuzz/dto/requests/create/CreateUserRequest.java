package com.web2.bookbuzz.dto.requests.create;

public record CreateUserRequest(String name, String url_photo, String email, String password) {

    public CreateUserRequest {
        if (url_photo == null) {
            url_photo = "";
        }
    }
}
