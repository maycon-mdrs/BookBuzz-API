package com.web2.bookbuzz.repositories;

import com.web2.bookbuzz.models.BookClubMembersModel;
import com.web2.bookbuzz.models.BookModel;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookClubMembersRepository extends JpaRepository<BookClubMembersModel, Integer> {

    List<BookClubMembersModel> findAll();

    List<BookClubMembersModel> findAll(Specification<BookClubMembersModel> spec);
}
