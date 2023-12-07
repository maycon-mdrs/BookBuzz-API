package com.web2.bookbuzz.services;

import com.web2.bookbuzz.dto.requests.create.CreateBookClubRequest;
import com.web2.bookbuzz.dto.responses.BookClubMemberResponse;
import com.web2.bookbuzz.dto.responses.BookClubResponse;
import com.web2.bookbuzz.dto.responses.UserResponseDTO;
import com.web2.bookbuzz.error.EntityNotFoundException;
import com.web2.bookbuzz.models.BookClubMembersModel;
import com.web2.bookbuzz.models.BookClubModel;
import com.web2.bookbuzz.models.UserModel;
import com.web2.bookbuzz.repositories.BookClubMembersRepository;
import com.web2.bookbuzz.repositories.BookClubRepository;
import com.web2.bookbuzz.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BookClubService {

    @Autowired
    private final BookClubRepository bookClubRepository;
    private final BookClubMembersRepository bookClubMembersRepository;
    private final UserRepository userRepository;

    public BookClubService(BookClubRepository bookClubRepository, BookClubMembersRepository bookClubMembersRepository,
            UserRepository userRepository) {
        this.bookClubRepository = bookClubRepository;
        this.bookClubMembersRepository = bookClubMembersRepository;
        this.userRepository = userRepository;
    }

    public List<BookClubResponse> getAllBookClubs() {
        return bookClubRepository.findAll().stream()
                .map(bookClubModel -> {
                    BookClubResponse response = new BookClubResponse(bookClubModel);
                    List<BookClubMembersModel> membersModels = bookClubMembersRepository.findByClubId(response.getId());
                    List<BookClubMemberResponse> memberResponses = membersModels.stream()
                            .map(BookClubMemberResponse::new) // Assuming you have a constructor in BookClubMemberResponse that accepts BookClubMembersModel
                            .collect(Collectors.toList());
                    response.setMembers(memberResponses);
                    response.setMembers_total(memberResponses.size());
                    return response;
                })
                .collect(Collectors.toList());
    }


    public BookClubResponse getBookClubById(int id) {
        Optional<BookClubModel> optionalBookClub = bookClubRepository.findById(id);
        return optionalBookClub.map(BookClubResponse::new)
                .map(response -> {
                    List<BookClubMembersModel> members = bookClubMembersRepository.findByClubId(response.getId());
                    List<BookClubMemberResponse> memberResponses = members.stream()
                            .map(BookClubMemberResponse::new)
                            .collect(Collectors.toList());
                    response.setMembers(memberResponses);
                    response.setMembers_total(memberResponses.size());
                    return response;
                })
                .orElse(null);
    }

    public BookClubResponse addBookClub(CreateBookClubRequest request) {
        Optional<UserModel> existingRecord = userRepository.findById(request.user_id());
        UserModel user = existingRecord
                .orElseThrow(() -> new EntityNotFoundException("user_id " + request.user_id() + " not found"));

        BookClubModel bookClubModel = bookClubRepository
                .save(new BookClubModel(request.name(), request.imageUrl(), request.description()));

        BookClubMembersModel bookClubMembersModel = bookClubMembersRepository
                .save(new BookClubMembersModel(user, bookClubModel.getId(), true));

        BookClubResponse response = new BookClubResponse(bookClubModel);

        List<BookClubMembersModel> members = bookClubMembersRepository.findByClubId(response.getId());

        List<BookClubMemberResponse> memberResponses = members.stream()
                .map(BookClubMemberResponse::new)
                .collect(Collectors.toList());
        response.setMembers(memberResponses);
        response.setMembers_total(1);

        return response;
    }

    public BookClubModel updateBookClub(int id, BookClubModel bookClub) {
        return bookClubRepository.existsById(id) ? bookClubRepository.save(bookClub) : null;
    }

    public void deleteBookClub(int id) {
        if (bookClubRepository.existsById(id)) {
            bookClubRepository.deleteById(id);
        }
    }
}
