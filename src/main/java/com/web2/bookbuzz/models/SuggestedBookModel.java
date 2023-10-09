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
    private BookModel bookId;
    @OneToOne
    @JoinColumn(name = "votation_id", referencedColumnName = "id")
    VotationModel votationId;
    @ManyToOne
    @JoinColumn(name = "suggested_by_user_id", referencedColumnName = "id")
    UserModel suggestedByUserId;
    @ElementCollection
    @Column(name = "votes")
    private List<Integer> votes;

    public SuggestedBookModel(){
        // Construtor vazio padrão
    }

    public SuggestedBookModel(BookModel bookId, VotationModel votationId, UserModel suggestedByUserId, List<Integer> votes) {
        this.bookId = bookId;
        this.votationId = votationId;
        this.suggestedByUserId = suggestedByUserId;
        this.votes = votes;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public BookModel getBookId() {
        return bookId;
    }

    public void setBookId(BookModel bookId) {
        this.bookId = bookId;
    }

    public VotationModel getVotationId() {
        return votationId;
    }

    public void setVotationId(VotationModel votation_id) {
        this.votationId = votation_id;
    }

    public UserModel getSuggestedByUserId() {
        return suggestedByUserId;
    }

    public void setSuggestedByUserId(UserModel suggestedBy) {
        this.suggestedByUserId = suggestedBy;
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
                ", bookId='" + bookId + '\'' +
                ", votationId='" + votationId + '\'' +
                ", suggestedBy='" + suggestedByUserId + '\'' +
                ", votes='" + votes + '\'' +
                '}';
    }
}
