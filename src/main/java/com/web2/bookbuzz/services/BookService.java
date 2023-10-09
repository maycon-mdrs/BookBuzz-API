package com.web2.bookbuzz.services;

import com.web2.bookbuzz.dto.requests.BookRequestDTO;
import com.web2.bookbuzz.models.BookModel;
import com.web2.bookbuzz.repositories.BookRepository;
import com.web2.bookbuzz.specs.BookSpecification;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    private final BookRepository BookRepository;

    @Autowired
    public BookService(BookRepository BookRepository) {
        this.BookRepository = BookRepository;
    }

    public List<BookModel> getAllBooks(BookRequestDTO req) {

        Specification<BookModel> spec = Specification.where(null);

        if (req.getTitle() != null) {
            spec = spec.and(BookSpecification.withTitle(req.getTitle()));
        }

        if (req.getAuthor() != null) {
            spec = spec.and(BookSpecification.withAuthor(req.getAuthor()));
        }

        if (req.getGenre() != null) {
            spec = spec.and(BookSpecification.withGenre(req.getGenre()));
        }

        return bookRepository.findAll(spec);
    }

    public BookModel getBookById(int id) {
        Optional<BookModel> optionalBook = BookRepository.findById(id);
        return optionalBook.orElse(null);
    }

    public BookModel addBook(BookModel bookModel) {
        return BookRepository.save(bookModel);
    }

    public BookModel updateBook(int id, BookModel bookModel) {
        // Verifica se o livro com o ID especificado existe antes de atualizar
        if (BookRepository.existsById(id)) {
            BookRepository.save(bookModel);
        }
        return bookModel;
    }

    public void deleteBook(int id) {
        // Verifica se o livro com o ID especificado existe antes de excluir
        if (BookRepository.existsById(id)) {
            BookRepository.deleteById(id);
        }
    }
}
