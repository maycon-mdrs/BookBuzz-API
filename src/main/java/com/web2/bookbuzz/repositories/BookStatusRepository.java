package com.web2.bookbuzz.repositories;

import com.web2.bookbuzz.models.BookStatusModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookStatusRepository extends JpaRepository<BookStatusModel, Integer> {
}
