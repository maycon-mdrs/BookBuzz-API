package com.web2.bookbuzz.services;

import com.web2.bookbuzz.dto.requests.create.CreateUserRequest;
import com.web2.bookbuzz.dto.requests.find.FindUserRequest;
import com.web2.bookbuzz.dto.requests.update.UpdateUserRequest;
import com.web2.bookbuzz.dto.responses.UserResponseDTO;
import com.web2.bookbuzz.error.DuplicatedEntityException;
import com.web2.bookbuzz.error.EntityNotFoundException;
import com.web2.bookbuzz.models.UserBookSituationModel;
import com.web2.bookbuzz.models.UserModel;
import com.web2.bookbuzz.repositories.UserRepository;
import com.web2.bookbuzz.specs.UserSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserResponseDTO> getAllUsers(FindUserRequest request) {
        Specification<UserModel> spec = Specification.where(null);
        if (request.name() != null) {
            spec = spec.and(UserSpecification.withName(request.name()));
        } else if (request.email() != null) {
            spec = spec.and(UserSpecification.withEmail(request.email()));
        }
        List<UserModel> usersModelList = userRepository.findAll(spec);
        List<UserResponseDTO> usersResponseDTOList = new ArrayList<>();
        for (UserModel userModel : usersModelList) {
            usersResponseDTOList.add(new UserResponseDTO(userModel));
        }

        return usersResponseDTOList;
    }

    public UserResponseDTO getUserById(int id) {

        Optional<UserModel> optionalUser = userRepository.findById(id);
        if (optionalUser.isPresent()) {
            return new UserResponseDTO(userRepository.findById(id).get());
        }
        throw new EntityNotFoundException("Usuário não encontrado");
    }

    public UserModel getOneUserByEmail(String email) {
        UserModel optionalUser = userRepository.findOneByEmail(email);
        return optionalUser;
    }

    public UserResponseDTO addUser(CreateUserRequest request) throws NoSuchAlgorithmException {

        List<UserModel> existingRecord = userRepository.findByEmail(request.email());

        if (!existingRecord.isEmpty()) {
            throw new DuplicatedEntityException("Record already exists for email " + request.email());
        }
        UserModel user = userRepository.save(new UserModel(request));
        return new UserResponseDTO(user);
    }

    public UserResponseDTO updateUser(int id, UpdateUserRequest request) throws NoSuchAlgorithmException {
        Optional<UserModel> optionalUser = userRepository.findById(id);
        if (optionalUser.isPresent()) {
            UserModel user = optionalUser.get();
            user.updateFields(request);
            UserModel updatedUser = userRepository.save(user);
            return new UserResponseDTO(updatedUser);
        }
        throw new EntityNotFoundException("Usuário não encontrado");
    }

    public void deleteUser(int id) {

        Optional<UserModel> optionalUser = userRepository.findById(id);
        if (optionalUser.isPresent()) {
            userRepository.deleteById(id);
        } else {
            throw new EntityNotFoundException("Usuário não encontrado");
        }

    }
}
