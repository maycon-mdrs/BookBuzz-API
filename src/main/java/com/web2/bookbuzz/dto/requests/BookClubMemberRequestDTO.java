package com.web2.bookbuzz.dto.requests;

import com.web2.bookbuzz.models.BookClubModel;
import com.web2.bookbuzz.models.UserModel;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

public class BookClubMemberRequestDTO {
    private Integer userId;
    private Integer clubId;

    public BookClubMemberRequestDTO() {

    }

    public BookClubMemberRequestDTO(Integer userId, Integer clubId) {
        this.userId = userId;
        this.clubId = clubId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getClubId() {
        return clubId;
    }

    public void setClubId(Integer clubId) {
        this.clubId = clubId;
    }
}
