package com.web2.bookbuzz.models;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "club_votaiton")
public class VotationModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    @ManyToOne
    @JoinColumn(name = "club_id", referencedColumnName = "id")
    BookClubModel clubId;
    @Column(name = "initial_date")
    Date initialDate;
    @Column(name = "final_date")
    Date finalDate;

    public VotationModel(){
        //Construtor vazio padrão
    }

    public VotationModel(BookClubModel clubId, Date initialDate, Date finalDate) {
        this.clubId = clubId;
        this.initialDate = initialDate;
        this.finalDate = finalDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public BookClubModel getClubId() {
        return clubId;
    }

    public void setClubId(BookClubModel club_id) {
        this.clubId = club_id;
    }

    public Date getInitialDate() {
        return initialDate;
    }

    public void setInitialDate(Date initial_date) {
        this.initialDate = initial_date;
    }

    public Date getFinalDate() {
        return finalDate;
    }

    public void setFinalDate(Date final_date) {
        this.finalDate = final_date;
    }
}
