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

    public List<UserModel> getAllUsers(String name, String email) {
        if (name != null && email != null) {
            return UserRepository.findByNameAndEmail(name, email);
        } else if (name != null) {
            return UserRepository.findByName(name);
        } else if (email != null) {
            return UserRepository.findByEmail(email);
        }
        return UserRepository.findAll();
    }

    public UserModel getUserById(int id) {
        Optional<UserModel> optionalUser = UserRepository.findById(id);
        return optionalUser.orElse(null);
    }

    public UserModel addUser(UserModel userModel) {
        return UserRepository.save(userModel);
    }

    public UserModel updateUser(int id, UserModel userModel) {
        // Verifica se o livro com o ID especificado existe antes de atualizar
        if (UserRepository.existsById(id)) {
            UserRepository.save(userModel);
        }
        return userModel;
    }

    public String deleteUser(int id) {
        // Verifica se o livro com o ID especificado existe antes de excluir
        if (UserRepository.existsById(id)) {
            UserRepository.deleteById(id);
            return "Usuário deletado com sucesso";
        }
        return "Ocorreu um erro ao deletar o usuário";
    }
}
