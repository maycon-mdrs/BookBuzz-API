package com.web2.bookbuzz.dto.requests.find;

public class FindUserRequest {
    String name;

    String email;

    public FindUserRequest() {
    }

    public FindUserRequest(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public String getName() {
        return this.name;
    }

    public String getEmail() {
        return this.email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
