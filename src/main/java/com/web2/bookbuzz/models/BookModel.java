package com.web2.bookbuzz.models;

import jakarta.persistence.*;

@Entity
@Table(name = "books")
public class BookModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    @Column(name = "title")
    String title;
    @Column(name = "author")
    String author;
    @Column(name = "genre")
    String genre;
    @Column(name = "description")
    String description;
    @Column(name = "cover_url")
    String coverUrl;

    public BookModel() {
        // Construtor vazio padrão
    }
    public BookModel(String title, String author, String genre, String description, String coverUrl) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.description = description;
        this.coverUrl = coverUrl;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getCoverUrl() {
        return coverUrl;
    }

    public void setCoverUrl(String cover_url) {
        this.coverUrl = cover_url;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "BookModel{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", genre='" + genre + '\'' +
                ", cover_url='" + coverUrl + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
