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
import com.web2.bookbuzz.models.BookModel;
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
    @Autowired
    private final UserBookSituationRepository userBookSituationRepository;
    @Autowired
    private final UserRepository userRepository;

    @Autowired
    private final BookStatusRepository bookStatusRepository;

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

        if (request.getBook_id() != null) {
            spec = spec.and(UserBookSituationSpecification.withBookId(request.getBook_id()));
        }

        if (request.getUser_id() != null) {
            spec = spec.and(UserBookSituationSpecification.withUserId(request.getUser_id()));
        }

        if(request.getStatus_id() != null){
            spec = spec.and(UserBookSituationSpecification.withStatusId(request.getStatus_id()));
        }

        List<UserBookSituationResponseDTO> bookStatusResponseDTOList = new ArrayList<>();
        List<UserBookSituationModel> userBookSituationList = userBookSituationRepository.findAll();

        for (UserBookSituationModel bookStatusModel : userBookSituationList) {
            UserBookSituationResponseDTO bookStatusResponseDTO = new UserBookSituationResponseDTO(bookStatusModel);
            bookStatusResponseDTOList.add(bookStatusResponseDTO);
        }

        return bookStatusResponseDTOList;
    }

    public UserBookSituationResponseDTO create(CreateUserBookSituationRequest userBookSituationRequestDTO) {
        Optional<UserBookSituationModel> existingRecord = userBookSituationRepository.findByUserIdAndBookId(
                userBookSituationRequestDTO.getUser_id(), userBookSituationRequestDTO.getBook_id());

        if (existingRecord.isPresent()) {
            throw new DuplicatedEntityException(
                    "Record already exists for user_id " + userBookSituationRequestDTO.getUser_id()
                            + " and book_id " + userBookSituationRequestDTO.getBook_id());
        }

        UserBookSituationModel userBookSituationModel = new UserBookSituationModel();

        Optional<UserModel> user = this.userRepository.findById(userBookSituationRequestDTO.getUser_id());

        userBookSituationModel.setBookId(userBookSituationRequestDTO.getBook_id());
        if (!user.isPresent()) {
            throw new EntityNotFoundException("Usuário não encontrado");
        }
        userBookSituationModel.setUserId(user.get());

        Optional<BookStatusModel> bookStatus = this.bookStatusRepository
                .findById(userBookSituationRequestDTO.getStatus_id());

        userBookSituationModel.setBookId(userBookSituationRequestDTO.getBook_id());
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

        Optional<BookStatusModel> bookStatus = this.bookStatusRepository.findById(request.getStatus_id());
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
