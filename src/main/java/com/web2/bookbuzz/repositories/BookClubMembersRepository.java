package com.web2.bookbuzz.repositories;

import com.web2.bookbuzz.models.BookClubMembersModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookClubMembersRepository extends JpaRepository<BookClubMembersModel, Integer> {
}
