package com.web2.bookbuzz.repositories;

import com.web2.bookbuzz.models.BookModel;

import java.util.List;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<BookModel, Integer> {
    // Você pode adicionar métodos personalizados de consulta aqui, se necessário

    List<BookModel> findAll();

    List<BookModel> findAll(Specification<BookModel> spec);
}
    