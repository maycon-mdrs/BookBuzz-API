package com.web2.bookbuzz.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.web2.bookbuzz.dto.requests.create.CreateUserBookSituationRequest;
import com.web2.bookbuzz.dto.requests.find.FindUserBookSituationRequest;
import com.web2.bookbuzz.dto.requests.update.UpdateUserBookSituationRequest;
import com.web2.bookbuzz.dto.responses.UserBookSituationResponseDTO;
import com.web2.bookbuzz.error.DuplicatedEntityException;
import com.web2.bookbuzz.error.EntityNotFoundException;
import com.web2.bookbuzz.models.BookStatusModel;
import com.web2.bookbuzz.models.UserBookSituationModel;
import com.web2.bookbuzz.models.UserModel;
import com.web2.bookbuzz.repositories.BookStatusRepository;
import com.web2.bookbuzz.repositories.UserBookSituationRepository;
import com.web2.bookbuzz.repositories.UserRepository;
import com.web2.bookbuzz.specs.UserBookSituationSpecification;

import java.util.ArrayList;

@Service
public class UserBookSituationService {
    private final UserBookSituationRepository userBookSituationRepository;
    private final UserRepository userRepository;
    private final BookStatusRepository bookStatusRepository;

    @Autowired
    public UserBookSituationService(
            UserBookSituationRepository userBookSituationRepository,
            UserRepository userService,
            BookStatusRepository bookStatusRepository) {
        this.userBookSituationRepository = userBookSituationRepository;
        this.userRepository = userService;
        this.bookStatusRepository = bookStatusRepository;
    }

    public List<UserBookSituationResponseDTO> getAll(FindUserBookSituationRequest request) {

        Specification<UserBookSituationModel> spec = Specification.where(null);

        if (request.book_id() != null) {
            spec = spec.and(UserBookSituationSpecification.withBookId(request.book_id()));
        }

        if (request.user_id() != null) {
            Optional<UserModel> existingRecord = userRepository.findById(request.user_id());

            if (!existingRecord.isPresent()) {
                throw new EntityNotFoundException("user_id " + request.user_id() + " not found");
            }
            spec = spec.and(UserBookSituationSpecification.withUserId(existingRecord.get()));
        }

        if (request.status_id() != null) {
            Optional<BookStatusModel> existingRecord = bookStatusRepository.findById(request.status_id());

            if (!existingRecord.isPresent()) {
                throw new EntityNotFoundException("status_id " + request.status_id() + " not found");
            }
            spec = spec.and(UserBookSituationSpecification.withStatusId(existingRecord.get()));
        }

        List<UserBookSituationResponseDTO> bookStatusResponseDTOList = new ArrayList<>();
        List<UserBookSituationModel> userBookSituationList = userBookSituationRepository.findAll(spec);

        for (UserBookSituationModel bookStatusModel : userBookSituationList) {
            UserBookSituationResponseDTO bookStatusResponseDTO = new UserBookSituationResponseDTO(bookStatusModel);
            bookStatusResponseDTOList.add(bookStatusResponseDTO);
        }

        return bookStatusResponseDTOList;
    }

    public UserBookSituationResponseDTO create(CreateUserBookSituationRequest userBookSituationRequestDTO) {
        Optional<UserBookSituationModel> existingRecord = userBookSituationRepository.findByUserIdAndBookId(
                userBookSituationRequestDTO.user_id(), userBookSituationRequestDTO.book_id());

        if (existingRecord.isPresent()) {
            throw new DuplicatedEntityException(
                    "Record already exists for user_id " + userBookSituationRequestDTO.user_id()
                            + " and book_id " + userBookSituationRequestDTO.book_id());
        }

        UserBookSituationModel userBookSituationModel = new UserBookSituationModel();

        Optional<UserModel> user = this.userRepository.findById(userBookSituationRequestDTO.user_id());

        userBookSituationModel.setBookId(userBookSituationRequestDTO.book_id());
        if (!user.isPresent()) {
            throw new EntityNotFoundException("Usuário não encontrado");
        }
        userBookSituationModel.setUserId(user.get());

        Optional<BookStatusModel> bookStatus = this.bookStatusRepository
                .findById(userBookSituationRequestDTO.status_id());

        userBookSituationModel.setBookId(userBookSituationRequestDTO.book_id());
        if (!bookStatus.isPresent()) {
            throw new EntityNotFoundException("Status não encontrado");
        }
        userBookSituationModel.setStatusId(bookStatus.get());

        UserBookSituationModel savedUserBookSituation = userBookSituationRepository.save(userBookSituationModel);

        UserBookSituationResponseDTO responseDTO = new UserBookSituationResponseDTO(savedUserBookSituation);
        return responseDTO;
    }

    public UserBookSituationResponseDTO update(int id, UpdateUserBookSituationRequest request) {

        if (!userBookSituationRepository.existsById(id)) {
            throw new EntityNotFoundException("UserBookSituation não encontrado");

        }
        Optional<UserBookSituationModel> existingRecord = userBookSituationRepository.findById(id);

        Optional<BookStatusModel> bookStatus = this.bookStatusRepository.findById(request.status_id());
        if (!bookStatus.isPresent()) {
            throw new EntityNotFoundException("Status não encontrado");
        }

        UserBookSituationModel record = existingRecord.get();
        record.setStatusId(bookStatus.get());
        UserBookSituationModel savedUserBookSituation = userBookSituationRepository.save(record);

        UserBookSituationResponseDTO responseDTO = new UserBookSituationResponseDTO(savedUserBookSituation);
        return responseDTO;
    }

    public void delete(int id) {
        if (!userBookSituationRepository.existsById(id)) {
            throw new EntityNotFoundException("UserBookSituation não encontrado");
        }
        userBookSituationRepository.deleteById(id);
    }

}
