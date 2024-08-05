package com.courses.capacitacionesflypass.sesion3.b.exprimiendoSpring.jpa.repository.d.criteria;

import com.courses.capacitacionesflypass.sesion3.b.exprimiendoSpring.jpa.entity.Post;
import com.courses.capacitacionesflypass.sesion3.b.exprimiendoSpring.jpa.entity.User;
import org.springframework.data.jpa.domain.Specification;

public class PostSpecifications {

    public static Specification<Post> hasTitle(String title) {
        return (root, query, criteriaBuilder) -> 
                criteriaBuilder.equal(root.get("title"), title);
    }

    public static Specification<Post> hasAuthor(User author) {
        return (root, query, criteriaBuilder) -> 
                criteriaBuilder.equal(root.get("author"), author);
    }
}
