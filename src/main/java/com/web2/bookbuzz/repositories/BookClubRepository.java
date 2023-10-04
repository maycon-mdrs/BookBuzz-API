package com.web2.bookbuzz.repositories;

import com.web2.bookbuzz.models.BookClubModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookClubRepository extends JpaRepository<BookClubModel, Integer> {
}
