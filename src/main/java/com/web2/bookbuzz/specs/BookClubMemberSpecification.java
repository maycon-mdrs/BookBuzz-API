package com.web2.bookbuzz.specs;

import com.web2.bookbuzz.models.BookClubMembersModel;
import com.web2.bookbuzz.models.BookClubModel;
import com.web2.bookbuzz.models.BookModel;
import com.web2.bookbuzz.models.UserModel;
import org.springframework.data.jpa.domain.Specification;

public class BookClubMemberSpecification {
    public static Specification<BookClubMembersModel> withClubId(Integer clubId) {
        return (root, query, builder) -> builder.equal(root.get("clubId"),clubId);
    }

    public static Specification<BookClubMembersModel> withUserId(Integer userId) {
        return (root, query, builder) -> builder.equal(root.get("userId"),userId);
    }
}
