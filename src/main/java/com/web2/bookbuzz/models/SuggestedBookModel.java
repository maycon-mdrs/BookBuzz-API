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
    @OneToOne
    @JoinColumn(name = "votation_id", referencedColumnName = "id")
    VotationModel votation_id;
    @ManyToOne
    @JoinColumn(name = "suggested_by_user_id", referencedColumnName = "id")
    UserModel suggested_by_user_id;
    @ElementCollection
    private List<Integer> votes;

    public SuggestedBookModel(){
        // Construtor vazio padrão
    }

    public SuggestedBookModel(int id, BookModel bookId, VotationModel votationId, UserModel suggestedByUserId, List<Integer> votes) {
        this.id = id;
        this.book_id = bookId;
        this.votation_id = votationId;
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

    public VotationModel getVotation_id() {
        return votation_id;
    }

    public void setVotation_id(VotationModel votation_id) {
        this.votation_id = votation_id;
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
                ", votationId='" + votation_id + '\'' +
                ", suggestedBy='" + suggested_by_user_id + '\'' +
                ", votes='" + votes + '\'' +
                '}';
    }
}
