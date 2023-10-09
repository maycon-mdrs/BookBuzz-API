package com.web2.bookbuzz.dto.requests;

public class BookRequestDTO {
    private String title;
    private String author;
    private String genre;

    // Construtor vazio
    public BookRequestDTO() {
    }

    // Construtor com parâmetros
    public BookRequestDTO(String title, String author, String genre) {
        this.title = title;
        this.author = author;
        this.genre = genre;
    }

    // Métodos getter e setter
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

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}
