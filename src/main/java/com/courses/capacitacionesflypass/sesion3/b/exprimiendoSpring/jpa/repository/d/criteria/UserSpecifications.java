package com.courses.capacitacionesflypass.sesion3.b.exprimiendoSpring.jpa.repository.d.criteria;

import java.time.LocalDateTime;

import com.courses.capacitacionesflypass.sesion3.b.exprimiendoSpring.jpa.entity.User;
import org.springframework.data.jpa.domain.Specification;

public class UserSpecifications {

    public static Specification<User> createdAfter(LocalDateTime date) {
        return (root, query, criteriaBuilder) -> 
                criteriaBuilder.greaterThan(root.get("createdAt"), date);
    }
}
