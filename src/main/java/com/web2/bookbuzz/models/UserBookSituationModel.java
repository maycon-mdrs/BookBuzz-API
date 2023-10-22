package com.web2.bookbuzz.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "user_book_situtation")

public class UserBookSituationModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    UserModel userId;

    @Column(name = "book_id")
    String bookId;

    @ManyToOne
    @JoinColumn(name = "status_id", referencedColumnName = "id")
    BookStatusModel statusId;

    public UserBookSituationModel() {
    }

    public UserBookSituationModel(int id, UserModel userId, String bookId, BookStatusModel status_id) {
        this.id = id;
        this.userId = userId;
        this.bookId = bookId;
        this.statusId = status_id;
    }

    public UserBookSituationModel(UserModel userId, String bookId, BookStatusModel status_id) {
        this.userId = userId;
        this.bookId = bookId;
        this.statusId = status_id;
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

    public void setUserId(UserModel userId) {
        this.userId = userId;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public BookStatusModel getStatusId() {
        return statusId;
    }

    public void setStatusId(BookStatusModel status_id) {
        this.statusId = status_id;
    }

}
