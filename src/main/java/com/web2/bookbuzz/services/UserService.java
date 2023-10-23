package com.web2.bookbuzz.services;

import com.web2.bookbuzz.dto.requests.find.FindUserRequest;
import com.web2.bookbuzz.dto.responses.UserResponseDTO;
import com.web2.bookbuzz.models.UserBookSituationModel;
import com.web2.bookbuzz.models.UserModel;
import com.web2.bookbuzz.repositories.UserRepository;
import com.web2.bookbuzz.specs.UserBookSituationSpecification;
import com.web2.bookbuzz.specs.UserSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserResponseDTO> getAllUsers(FindUserRequest request) {
        Specification<UserModel> spec = Specification.where(null);
        if (request.getName() != null) {
            spec = spec.and(UserSpecification.withName(request.getName()));
        } else if (request.getEmail() != null) {
            spec = spec.and(UserSpecification.withEmail(request.getEmail()));
        }
        List<UserModel> usersModelList = userRepository.findAll(spec);
        List<UserResponseDTO> usersResponseDTOList = new ArrayList<>();
        for (UserModel userModel : usersModelList) {
            usersResponseDTOList.add(new UserResponseDTO(userModel));
        }

        return usersResponseDTOList;
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
