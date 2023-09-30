package com.web2.bookbuzz.services;

import com.web2.bookbuzz.models.BookModel;
import com.web2.bookbuzz.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    private final BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<BookModel> getAllBooks() {
        return bookRepository.findAll();
    }

    public BookModel getBookById(int id) {
        Optional<BookModel> optionalBook = bookRepository.findById(id);
        return optionalBook.orElse(null);
    }

    public void addBook(BookModel bookModel) {
        bookRepository.save(bookModel);
    }

    public void updateBook(int id, BookModel bookModel) {
        // Verifica se o livro com o ID especificado existe antes de atualizar
        if (bookRepository.existsById(id)) {
            bookRepository.save(bookModel);
        }
    }

    public void deleteBook(int id) {
        // Verifica se o livro com o ID especificado existe antes de excluir
        if (bookRepository.existsById(id)) {
            bookRepository.deleteById(id);
        }
    }
}

