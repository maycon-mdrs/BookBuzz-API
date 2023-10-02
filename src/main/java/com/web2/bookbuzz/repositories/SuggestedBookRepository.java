package com.web2.bookbuzz.repositories;

import com.web2.bookbuzz.models.SuggestedBookModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SuggestedBookRepository extends JpaRepository<SuggestedBookModel, Integer> {
}
