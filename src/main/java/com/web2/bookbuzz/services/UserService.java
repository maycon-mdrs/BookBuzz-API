package com.web2.bookbuzz.services;

import com.web2.bookbuzz.models.UserModel;
import com.web2.bookbuzz.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserModel> getAllUsers(String name, String email) {
        if (name != null && email != null) {
            return userRepository.findByNameAndEmail(name, email);
        } else if (name != null) {
            return userRepository.findByName(name);
        } else if (email != null) {
            return userRepository.findByEmail(email);
        }
        return userRepository.findAll();
    }

    public UserModel getUserById(int id) {
        Optional<UserModel> optionalUser = userRepository.findById(id);
        return optionalUser.orElse(null);
    }

    public List<UserModel> getUserByEmail(String email) {
        List<UserModel> optionalUser = userRepository.findByEmail(email);
        return optionalUser;
    }

    public UserModel getOneUserByEmail(String email) {
        UserModel optionalUser = userRepository.findOneByEmail(email);
        return optionalUser;
    }

    public UserModel addUser(UserModel userModel) {
        return userRepository.save(userModel);
    }

    public UserModel updateUser(int id, UserModel userModel) {
        return userRepository.save(userModel);
    }

    public void deleteUser(int id) {
        userRepository.deleteById(id);
    }
}
