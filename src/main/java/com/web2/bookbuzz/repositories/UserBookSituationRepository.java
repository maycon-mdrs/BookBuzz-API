package com.web2.bookbuzz.repositories;

import com.web2.bookbuzz.models.BookModel;
import com.web2.bookbuzz.models.UserBookSituationModel;

import jakarta.transaction.Transactional;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserBookSituationRepository extends JpaRepository<UserBookSituationModel, Integer> {

    List<UserBookSituationModel> findAll();

    List<UserBookSituationModel> findAll(Specification<UserBookSituationModel> spec);

    @Query("SELECT ubsm FROM UserBookSituationModel ubsm WHERE ubsm.userId.id = :user_id AND ubsm.bookId = :book_id")
    Optional<UserBookSituationModel> findByUserIdAndBookId(@Param("user_id") int user_id,
            @Param("book_id") String book_id);

    @Modifying
    @Transactional
    @Query("UPDATE UserBookSituationModel u SET u.statusId.id = ?2 WHERE u.id = ?1")
    void updateStatusId(int id, int statusId);
}
