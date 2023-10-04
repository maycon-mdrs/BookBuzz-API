package com.web2.bookbuzz.repositories;

import com.web2.bookbuzz.models.BookModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<BookModel, Integer> {
    @Query("SELECT u FROM BookModel u WHERE u.genre LIKE %:genre%")
    List<BookModel> findByGenre(@Param("genre") String genre);

    @Query("SELECT u FROM BookModel u WHERE u.title LIKE %:title%")
    List<BookModel> findByTitle(@Param("title") String title);

    @Query("SELECT u FROM BookModel u WHERE u.title LIKE %:title% AND u.genre LIKE %:genre%")
    List<BookModel> findByTitleAndGenre(@Param("title") String title, @Param("genre") String genre);
}
