package com.web2.bookbuzz.dto.requests.create;

public record CreateBookClubRequest(String name, String imageUrl, String description, int user_id) {
}
