package com.web2.bookbuzz.specs;

import org.springframework.data.jpa.domain.Specification;

import com.web2.bookbuzz.models.UserBookSituationModel;
import com.web2.bookbuzz.models.UserModel;

public class UserBookSituationSpecification {
    public static Specification<UserBookSituationModel> withBookId(String bookId) {
        return (root, query, builder) -> builder.equal(root.get("bookId"), bookId);
    }

    public static Specification<UserBookSituationModel> withStatusId(Integer statusId) {
        return (root, query, builder) -> builder.equal(root.get("statusId"), statusId);
    }

    public static Specification<UserBookSituationModel> withUserId(UserModel userId) {
        return (root, query, builder) -> builder.equal(root.get("userId"), userId);
    }
}
