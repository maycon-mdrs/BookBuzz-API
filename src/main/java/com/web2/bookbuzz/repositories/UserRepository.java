package com.web2.bookbuzz.repositories;

import com.web2.bookbuzz.models.UserModel;
import com.web2.bookbuzz.specs.UserSpecification;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<UserModel, Integer> {
    @Query("SELECT u FROM UserModel u WHERE u.email LIKE %:email%")
    List<UserModel> findByEmail(@Param("email") String email);

    @Query("SELECT u FROM UserModel u WHERE u.email = :email")
    UserModel findOneByEmail(@Param("email") String email);

    @Query("SELECT u FROM UserModel u WHERE u.name LIKE %:name%")
    List<UserModel> findByName(@Param("name") String name);

    @Query("SELECT u FROM UserModel u WHERE u.name LIKE %:name% AND u.email LIKE %:email%")
    List<UserModel> findByNameAndEmail(@Param("name") String name, @Param("email") String email);

    List<UserModel> findAll(Specification<UserModel> spec);
}
