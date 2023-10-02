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
    BookClubModel club_id;
    Date initial_date;
    Date final_date;

    public VotationModel(){
        //Construtor vazio padrão
    }

    public VotationModel(int id, BookClubModel club_id, Date initial_date, Date final_date) {
        this.id = id;
        this.club_id = club_id;
        this.initial_date = initial_date;
        this.final_date = final_date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public BookClubModel getClub_id() {
        return club_id;
    }

    public void setClub_id(BookClubModel club_id) {
        this.club_id = club_id;
    }

    public Date getInitial_date() {
        return initial_date;
    }

    public void setInitial_date(Date initial_date) {
        this.initial_date = initial_date;
    }

    public Date getFinal_date() {
        return final_date;
    }

    public void setFinal_date(Date final_date) {
        this.final_date = final_date;
    }
}
