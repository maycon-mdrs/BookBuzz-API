package com.web2.bookbuzz.services;

import com.web2.bookbuzz.models.UserModel;
import com.web2.bookbuzz.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository UserRepository;

    @Autowired
    public UserService(UserRepository UserRepository) {
        this.UserRepository = UserRepository;
    }

    public List<UserModel> getAllUsers() {
        return UserRepository.findAll();
    }

    public UserModel getUserById(int id) {
        Optional<UserModel> optionalBook = UserRepository.findById(id);
        return optionalBook.orElse(null);
    }

    public void addUser(UserModel bookModel) {
        UserRepository.save(bookModel);
    }

    public void updateUser(int id, UserModel bookModel) {
        // Verifica se o livro com o ID especificado existe antes de atualizar
        if (UserRepository.existsById(id)) {
            UserRepository.save(bookModel);
        }
    }

    public void deleteUser(int id) {
        // Verifica se o livro com o ID especificado existe antes de excluir
        if (UserRepository.existsById(id)) {
            UserRepository.deleteById(id);
        }
    }
}
