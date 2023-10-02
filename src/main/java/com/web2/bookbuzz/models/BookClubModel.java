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
    @ElementCollection
    List<Integer> members;
    @ElementCollection
    List<Integer> admins;

    public BookClubModel(){
        // Construtor vazio padrão
    }

    public BookClubModel(int id, String name, List<Integer> members, List<Integer> admins) {
        this.id = id;
        this.name = name;
        this.members = members;
        this.admins = admins;
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

    public List<Integer> getMembers() {
        return members;
    }

    public void setMembers(List<Integer> members) {
        this.members = members;
    }

    public List<Integer> getAdmins() {
        return admins;
    }

    public void setAdmins(List<Integer> admins) {
        this.admins = admins;
    }
}
