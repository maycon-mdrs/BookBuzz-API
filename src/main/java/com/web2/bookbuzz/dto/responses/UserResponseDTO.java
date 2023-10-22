package com.web2.bookbuzz.dto.responses;

import com.web2.bookbuzz.models.UserModel;

public class UserResponseDTO {
    private int id;
    private String name;
    private String url_photo;
    private String email;

    public UserResponseDTO(UserModel user) {
        this.id = user.getId();
        this.name = user.getName();
        this.url_photo = user.getUrlPhoto();
        this.email = user.getEmail();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl_photo() {
        return url_photo;
    }

    public void setUrl_photo(String url_photo) {
        this.url_photo = url_photo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
