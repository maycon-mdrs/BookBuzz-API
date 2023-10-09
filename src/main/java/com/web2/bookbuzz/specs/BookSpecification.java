package com.web2.bookbuzz.specs;

import org.springframework.data.jpa.domain.Specification;

import com.web2.bookbuzz.models.BookModel;

public class BookSpecification {
    public static Specification<BookModel> withTitle(String title) {
        return (root, query, builder) -> builder.like(root.get("title"), "%" + title + "%");
    }

    public static Specification<BookModel> withAuthor(String author) {
        return (root, query, builder) -> builder.like(root.get("author"), "%" + author + "%");
    }

    public static Specification<BookModel> withGenre(String genre) {
        return (root, query, builder) -> builder.equal(root.get("genre"), genre);
    }
}