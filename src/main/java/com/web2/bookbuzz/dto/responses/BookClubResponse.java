package com.web2.bookbuzz.dto.responses;

import java.util.List;

import com.web2.bookbuzz.models.BookClubModel;

public class BookClubResponse {
    int id;

    String name;

    String image_url;

    String description;

    List<BookClubMemberResponse> members;

    Integer members_total;

    

    public BookClubResponse() {
        // Construtor vazio padrão
    }

    public BookClubResponse(int id, String name, String image_url, String description) {
        this.id = id;
        this.name = name;
        this.image_url = image_url;
        this.description = description;
    }

    public BookClubResponse(BookClubModel bookClub) {
        this.id = bookClub.getId();
        this.description = bookClub.getDescription();
        this.image_url = bookClub.getImageUrl();
        this.name = bookClub.getName();

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

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<BookClubMemberResponse> getMembers() {
        return members;
    }

    public void setMembers(List<BookClubMemberResponse> members) {
        this.members = members;
    }

	public Integer getMembers_total() {
		return members_total;
	}

	public void setMembers_total(Integer members_total) {
		this.members_total = members_total;
	}

}
