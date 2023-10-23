package com.web2.bookbuzz.specs;

import com.web2.bookbuzz.models.BookModel;
import com.web2.bookbuzz.models.UserModel;
import org.springframework.data.jpa.domain.Specification;

public class UserSpecification {
    public static Specification<UserModel> withName(String name) {
        return (root, query, builder) -> builder.like(root.get("name"), "%" + name + "%");
    }

    public static Specification<UserModel> withEmail(String email) {
        return (root, query, builder) -> builder.like(root.get("email"), "%" + email + "%");
    }
}
