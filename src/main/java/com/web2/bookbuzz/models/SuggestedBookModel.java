package com.web2.bookbuzz.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "suggested_book")
public class SuggestedBookModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    @OneToOne
    @JoinColumn(name = "book_id", referencedColumnName = "id")
    private BookModel book_id;
   // @OneToOne
    //@JoinColumn(name = "votation_id", referencedColumnName = "id")
    int votation_id;
    @ManyToOne
    @JoinColumn(name = "suggested_by_user_id", referencedColumnName = "id")
    UserModel suggested_by_user_id;
    @ElementCollection
    private List<Integer> votes;

    public SuggestedBookModel(){
        // Construtor vazio padrão
    }

    public SuggestedBookModel(int id, BookModel bookId, UserModel suggestedByUserId, List<Integer> votes) {
        this.id = id;
        this.book_id = bookId;
        this.suggested_by_user_id = suggestedByUserId;
        this.votes = votes;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public BookModel getBookId() {
        return book_id;
    }

    public void setBookId(BookModel bookId) {
        this.book_id = bookId;
    }

    public UserModel getSuggestedByUserId() {
        return suggested_by_user_id;
    }

    public void setSuggestedByUserId(UserModel suggestedBy) {
        this.suggested_by_user_id = suggestedBy;
    }

    public List<Integer> getVotes() {
        return votes;
    }

    public void setVotes(List<Integer> votes) {
        this.votes = votes;
    }

    @Override
    public String toString() {
        return "UserModel{" +
                "id=" + id +
                ", bookId='" + book_id + '\'' +
                ", suggestedBy='" + suggested_by_user_id + '\'' +
                ", votes='" + votes + '\'' +
                '}';
    }
}
