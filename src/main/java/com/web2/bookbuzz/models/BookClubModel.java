package com.web2.bookbuzz.models;


import jakarta.persistence.*;
import org.springframework.boot.json.JsonParser;
import org.springframework.boot.json.JsonParserFactory;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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

    List<Integer> convertStringToListOfIntegers(String input) {
        List<Integer> integers = Arrays.stream(input.split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        return integers;
    }

    @Override
    public String toString() {
        return "UserModel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", members='" + members + '\'' +
                ", admins='" + admins + '\'' +
                '}';
    }
}
