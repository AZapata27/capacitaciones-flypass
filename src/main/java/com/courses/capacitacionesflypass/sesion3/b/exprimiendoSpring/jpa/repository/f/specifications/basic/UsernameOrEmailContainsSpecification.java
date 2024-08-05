package com.courses.capacitacionesflypass.sesion3.b.exprimiendoSpring.jpa.repository.f.specifications.basic;

import com.courses.capacitacionesflypass.sesion3.b.exprimiendoSpring.jpa.repository.f.specifications.ComplexUser;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;

public class UsernameOrEmailContainsSpecification implements Specification<ComplexUser> {

    private final String keyword;

    public UsernameOrEmailContainsSpecification(String keyword) {
        this.keyword = keyword;
    }

    @Override
    public Predicate toPredicate(Root<ComplexUser> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {

        Predicate usernamePredicate = criteriaBuilder.like(root.get("username"), "%" + keyword + "%");
        Predicate emailPredicate = criteriaBuilder.like(root.get("email"), "%" + keyword + "%");
        return criteriaBuilder.or(usernamePredicate, emailPredicate);
    }
}
