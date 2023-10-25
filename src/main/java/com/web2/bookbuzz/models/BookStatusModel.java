package com.web2.bookbuzz.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "book_status")

public class BookStatusModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @Column(name = "description")
    String description;

    public BookStatusModel() {
    }
    

    public BookStatusModel(int id, String description) {
        this.id = id;
        this.description = description;
    }

    @Override
    public String toString() {
        return "BookStatus{" +
                "id=" + id +
                ", description='" + description + '\'' +
                '}';
    }


    public int getId() {
        return id;
    }


    public void setId(int id) {
        this.id = id;
    }


    public String getDescription() {
        return description;
    }


    public void setDescription(String description) {
        this.description = description;
    }

}
