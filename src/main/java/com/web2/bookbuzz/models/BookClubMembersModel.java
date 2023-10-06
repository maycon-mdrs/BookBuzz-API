package com.web2.bookbuzz.models;

import jakarta.persistence.*;

@Entity
@Table(name = "book_club_members")
public class BookClubMembersModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    UserModel userId;
    @OneToOne
    @JoinColumn(name = "club_id", referencedColumnName = "id")
    BookClubModel clubId;

    Boolean is_admin;

    public BookClubMembersModel(){
        // Construtor vazio padrão
    }

    public BookClubMembersModel(UserModel userId, BookClubModel clubId, Boolean isAdmin) {
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

    public UserModel getUserId() {
        return userId;
    }

    public void setUserId(UserModel user_id) {
        this.userId = user_id;
    }

    public BookClubModel getClubId() {
        return clubId;
    }

    public void setClubId(BookClubModel club_id) {
        this.clubId = club_id;
    }

    public Boolean getIs_admin() {
        return is_admin;
    }

    public void setIs_admin(Boolean is_admin) {
        this.is_admin = is_admin;
    }
}
