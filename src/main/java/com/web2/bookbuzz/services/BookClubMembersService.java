package com.web2.bookbuzz.services;

import com.web2.bookbuzz.dto.requests.update.BookClubMemberRequestDTO;
import com.web2.bookbuzz.models.BookClubMembersModel;
import com.web2.bookbuzz.repositories.BookClubMembersRepository;
import com.web2.bookbuzz.specs.BookClubMemberSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookClubMembersService {
    @Autowired
    private final BookClubMembersRepository bookClubMembersRepository;

    public BookClubMembersService(BookClubMembersRepository bookClubMembersRepository) {
        this.bookClubMembersRepository = bookClubMembersRepository;
    }

    public List<BookClubMembersModel> getAllBookClubMembers(BookClubMemberRequestDTO req) {
        Specification<BookClubMembersModel> spec = Specification.where(null);

        if (req.club_id() != null) {
            spec = spec.and(BookClubMemberSpecification.withClubId(req.club_id()));
        }

        if (req.user_id() != null) {
            spec = spec.and(BookClubMemberSpecification.withUserId(req.user_id()));
        }
        return bookClubMembersRepository.findAll(spec);
    }

    public BookClubMembersModel getBookClubMembersById(int id) {
        Optional<BookClubMembersModel> optionalBookClubMembersModel = bookClubMembersRepository.findById(id);
        return optionalBookClubMembersModel.orElse(null);
    }

    public BookClubMembersModel addBookClubMembers(BookClubMembersModel bookClubMembers) {
        return bookClubMembersRepository.save(bookClubMembers);
    }

    public void updateBookClubMembers(int id, BookClubMembersModel bookClubMembers) {
        if (bookClubMembersRepository.existsById(id)) {
            bookClubMembersRepository.save(bookClubMembers);
        }
    }

    public void deleteBookClubMembers(int id) {
        if (bookClubMembersRepository.existsById(id)) {
            bookClubMembersRepository.deleteById(id);
        }
    }
}
