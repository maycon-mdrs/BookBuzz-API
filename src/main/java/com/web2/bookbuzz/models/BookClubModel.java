package com.web2.bookbuzz.models;


import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "book_club")
public class BookClubModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String name;

    public BookClubModel(){
        // Construtor vazio padrão
    }

    public BookClubModel(int id, String name, List<Integer> members, List<Integer> admins) {
        this.id = id;
        this.name = name;
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
}
