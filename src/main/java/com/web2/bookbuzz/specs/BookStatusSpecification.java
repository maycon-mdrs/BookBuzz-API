package com.web2.bookbuzz.specs;

import org.springframework.data.jpa.domain.Specification;

import com.web2.bookbuzz.models.BookStatusModel;

public class BookStatusSpecification {
    public static Specification<BookStatusModel> withDescription(String description) {
        return (root, query, builder) -> builder.like(root.get("description"), "%" + description + "%");
    }
}