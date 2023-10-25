package com.web2.bookbuzz.repositories;

import com.web2.bookbuzz.models.BookClubMembersModel;
import com.web2.bookbuzz.models.BookClubModel;
import com.web2.bookbuzz.models.UserModel;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookClubMembersRepository extends JpaRepository<BookClubMembersModel, Integer> {

    List<BookClubMembersModel> findAll();

    List<BookClubMembersModel> findAll(Specification<BookClubMembersModel> spec);

    List<BookClubMembersModel> findByUserId(UserModel user);

    default List<BookClubMembersModel> findByUserId(int userId) {
        return findByUserId(new UserModel(userId));
    }

    List<BookClubMembersModel> findByClubId(int clubId);

}
