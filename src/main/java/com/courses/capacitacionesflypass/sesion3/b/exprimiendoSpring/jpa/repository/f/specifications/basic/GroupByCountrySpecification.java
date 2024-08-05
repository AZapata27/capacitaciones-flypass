package com.courses.capacitacionesflypass.sesion3.b.exprimiendoSpring.jpa.repository.f.specifications.basic;

import com.courses.capacitacionesflypass.sesion3.b.exprimiendoSpring.jpa.repository.f.specifications.ComplexUser;
import jakarta.persistence.criteria.*;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

public class GroupByCountrySpecification implements Specification<ComplexUser> {

    @Override
    public Predicate toPredicate(Root<ComplexUser> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        // Campo por el que vamos a agrupar
        Expression<String> countryExpression = root.get("country");

        // Campos de agregación
        Expression<Long> countExpression = criteriaBuilder.count(root);
        Expression<Double> avgAgeExpression = criteriaBuilder.avg(root.get("age"));

        // Campos a seleccionar
        List<Selection<?>> selections = new ArrayList<>();
        selections.add(countryExpression);
        selections.add(countExpression);
        selections.add(avgAgeExpression);

        // Agregamos las selecciones y agrupamientos a la query
        query.multiselect(selections);
        query.groupBy(countryExpression);

        return null; // No hay filtros adicionales
    }
}
