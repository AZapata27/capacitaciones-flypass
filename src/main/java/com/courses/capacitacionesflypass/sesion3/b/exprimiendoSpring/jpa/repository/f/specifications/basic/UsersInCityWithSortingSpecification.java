package com.courses.capacitacionesflypass.sesion3.b.exprimiendoSpring.jpa.repository.f.specifications.basic;

import com.courses.capacitacionesflypass.sesion3.b.exprimiendoSpring.jpa.repository.f.specifications.ComplexUser;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;

public class UsersInCityWithSortingSpecification implements Specification<ComplexUser> {

    private final String city;

    public UsersInCityWithSortingSpecification(String city) {
        this.city = city;
    }

    @Override
    public Predicate toPredicate(Root<ComplexUser> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {

        Predicate cityPredicate = criteriaBuilder.equal(root.get("city"), city);

        query.orderBy(criteriaBuilder.desc(root.get("createdAt")));

        query.multiselect(root.get("username"), root.get("email"));

        return cityPredicate;
    }
}
