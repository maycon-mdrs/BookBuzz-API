package com.web2.bookbuzz.services;

import com.web2.bookbuzz.models.BookModel;
import com.web2.bookbuzz.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
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

    public List<BookModel> getAllBooks(String title, String genre) {
        if (title != null && genre != null) {
            return BookRepository.findByTitleAndGenre(title, genre);
        } else if (title != null) {
            return BookRepository.findByTitle(title);
        } else if (genre != null) {
            return BookRepository.findByGenre(genre);
        }
        return BookRepository.findAll();
    }

    public BookModel getBookById(int id) {
        Optional<BookModel> optionalBook = bookRepository.findById(id);
        return optionalBook.orElse(null);
    }

    public BookModel addBook(BookModel bookModel) {
        return bookRepository.save(bookModel);
    }

    public BookModel updateBook(int id, BookModel bookModel) {
        // Verifica se o livro com o ID especificado existe antes de atualizar
        if (bookRepository.existsById(id)) {
            bookRepository.save(bookModel);
        }
        return bookModel;
    }

    public void deleteBook(int id) {
        // Verifica se o livro com o ID especificado existe antes de excluir
        if (bookRepository.existsById(id)) {
            bookRepository.deleteById(id);
        }
    }
}

