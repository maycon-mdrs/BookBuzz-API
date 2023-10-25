package com.web2.bookbuzz.dto.responses;

import com.web2.bookbuzz.models.BookClubMembersModel;
import com.web2.bookbuzz.models.BookClubModel;
import com.web2.bookbuzz.models.UserModel;

public class BookClubMemberResponse {
    int id;

    UserResponseDTO user_id;

    Integer club_id;

    boolean is_admin;

    public BookClubMemberResponse(BookClubMembersModel bookClubMembersModel) {
        this.id = bookClubMembersModel.getId();
        this.user_id = new UserResponseDTO(bookClubMembersModel.getUserId());
        this.club_id = bookClubMembersModel.getClubId();
        this.is_admin = bookClubMembersModel.getIs_admin();
    }

    public BookClubMemberResponse(int id, UserModel user_id, BookClubModel club_id, boolean is_admin) {
        this.id = id;
        this.user_id = new UserResponseDTO(user_id);
        this.club_id = club_id.getId();
        this.is_admin = is_admin;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public UserResponseDTO getUser_id() {
        return user_id;
    }

    public void setUser_id(UserModel user_id) {
        this.user_id = new UserResponseDTO(user_id);
    }

    public Integer getClub_id() {
        return club_id;
    }

    public void setClub_id(Integer club_id) {
        this.club_id = club_id;
    }

    public boolean isIs_admin() {
        return is_admin;
    }

    public void setIs_admin(boolean is_admin) {
        this.is_admin = is_admin;
    }

}
