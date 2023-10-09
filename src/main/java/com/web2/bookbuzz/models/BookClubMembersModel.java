package com.web2.bookbuzz.models;

import jakarta.persistence.*;

@Entity
@Table(name = "book_club_members")
public class BookClubMembersModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    @Column(name = "user_id")
    Integer userId;
    @Column(name = "club_id")
    Integer clubId;

    Boolean is_admin;

    public BookClubMembersModel(){
        // Construtor vazio padrão
    }

    public BookClubMembersModel(Integer userId, Integer clubId, Boolean isAdmin) {
        this.userId = userId;
        this.clubId = clubId;
        this.is_admin = isAdmin;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer user_id) {
        this.userId = user_id;
    }

    public Integer getClubId() {
        return clubId;
    }

    public void setClubId(Integer club_id) {
        this.clubId = club_id;
    }

    public Boolean getIs_admin() {
        return is_admin;
    }

    public void setIs_admin(Boolean is_admin) {
        this.is_admin = is_admin;
    }
}
