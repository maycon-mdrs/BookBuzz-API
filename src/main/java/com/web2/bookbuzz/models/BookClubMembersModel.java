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
    UserModel user_id;
    @OneToOne
    @JoinColumn(name = "club_id", referencedColumnName = "id")
    BookClubModel club_id;

    Boolean is_admin;

    public BookClubMembersModel(){
        // Construtor vazio padrão
    }

    public BookClubMembersModel(int id, UserModel userId, BookClubModel clubId, Boolean isAdmin) {
        this.id = id;
        this.user_id = userId;
        this.club_id = clubId;
        this.is_admin = isAdmin;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public UserModel getUser_id() {
        return user_id;
    }

    public void setUser_id(UserModel user_id) {
        this.user_id = user_id;
    }

    public BookClubModel getClub_id() {
        return club_id;
    }

    public void setClub_id(BookClubModel club_id) {
        this.club_id = club_id;
    }

    public Boolean getIs_admin() {
        return is_admin;
    }

    public void setIs_admin(Boolean is_admin) {
        this.is_admin = is_admin;
    }
}
