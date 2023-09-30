package com.web2.bookbuzz.repositories;

import com.web2.bookbuzz.models.BookModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<BookModel, Integer> {
    // Você pode adicionar métodos personalizados de consulta aqui, se necessário
}
