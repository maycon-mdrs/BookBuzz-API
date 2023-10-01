package com.web2.bookbuzz.repositories;

import com.web2.bookbuzz.models.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserModel, Integer> {
    // Você pode adicionar métodos personalizados de consulta aqui, se necessário
}
