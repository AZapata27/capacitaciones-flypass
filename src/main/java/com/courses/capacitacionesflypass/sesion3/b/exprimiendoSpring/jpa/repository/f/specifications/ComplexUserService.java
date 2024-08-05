package com.courses.capacitacionesflypass.sesion3.b.exprimiendoSpring.jpa.repository.f.specifications;

import com.courses.capacitacionesflypass.sesion3.b.exprimiendoSpring.jpa.repository.f.specifications.bestPractics.ComplexUserSpecifications;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ComplexUserService {

    private final ComplexUserRepository complexUserRepository;

    public List<ComplexUser> findUsersByMultipleCriteria(String firstName, String lastName, String city, Boolean emailVerified) {
        Specification<ComplexUser> spec = ComplexUserSpecifications.multiCriteriaSearch(firstName, lastName, city, emailVerified);
        return complexUserRepository.findAll(spec);
    }

    public List<ComplexUser> findActiveUsersByRole(String role) {
        Specification<ComplexUser> spec = ComplexUserSpecifications.hasRoleAndIsActive(role);
        return complexUserRepository.findAll(spec);
    }

    public List<ComplexUser> findUsersByKeyword(String keyword) {
        Specification<ComplexUser> spec = ComplexUserSpecifications.usernameOrEmailContains(keyword);
        return complexUserRepository.findAll(spec);
    }

    public List<ComplexUser> findUsersBornBetweenAndCountry(LocalDate startDate, LocalDate endDate, String country) {
        Specification<ComplexUser> spec = ComplexUserSpecifications.bornBetweenAndCountry(startDate, endDate, country);
        return complexUserRepository.findAll(spec);
    }
}
