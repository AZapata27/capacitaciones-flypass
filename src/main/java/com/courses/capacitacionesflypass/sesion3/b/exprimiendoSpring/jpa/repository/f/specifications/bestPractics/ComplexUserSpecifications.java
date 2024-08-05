package com.courses.capacitacionesflypass.sesion3.b.exprimiendoSpring.jpa.repository.f.specifications.bestPractics;

import com.courses.capacitacionesflypass.sesion3.b.exprimiendoSpring.jpa.repository.f.specifications.ComplexUser;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;

import java.time.LocalDate;

public class ComplexUserSpecifications {

    public static Specification<ComplexUser> usernameOrEmailContains(String keyword) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.or(
                criteriaBuilder.like(root.get("username"), "%" + keyword + "%"),
                criteriaBuilder.like(root.get("email"), "%" + keyword + "%")
        );
    }

    public static Specification<ComplexUser> bornBetweenAndCountry(LocalDate startDate, LocalDate endDate, String country) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.and(
                criteriaBuilder.between(root.get("dateOfBirth"), startDate, endDate),
                criteriaBuilder.equal(root.get("country"), country)
        );
    }

    public static Specification<ComplexUser> hasRoleAndIsActive(String role) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.and(
                criteriaBuilder.isTrue(root.get("active")),
                criteriaBuilder.isMember(role, root.get("roles"))
        );
    }


    public static Specification<ComplexUser> multiCriteriaSearch(String firstName, String lastName, String city, Boolean emailVerified) {


        return (root, query, criteriaBuilder) -> {

            Predicate predicates = criteriaBuilder.conjunction();
            if (firstName != null && !firstName.isEmpty()) {
                predicates.getExpressions().add(criteriaBuilder.equal(root.get("firstName"), firstName));
            }
            if (lastName != null && !lastName.isEmpty()) {
                predicates.getExpressions().add(criteriaBuilder.equal(root.get("lastName"), lastName));
            }
            if (city != null && !city.isEmpty()) {
                predicates.getExpressions().add(criteriaBuilder.equal(root.get("city"), city));
            }
            if (emailVerified != null) {
                predicates.getExpressions().add(criteriaBuilder.equal(root.get("emailVerified"), emailVerified));
            }
            return predicates;
        };
    }
}
