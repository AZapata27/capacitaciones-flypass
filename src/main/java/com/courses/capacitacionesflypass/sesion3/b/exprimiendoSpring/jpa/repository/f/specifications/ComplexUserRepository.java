package com.courses.capacitacionesflypass.sesion3.b.exprimiendoSpring.jpa.repository.f.specifications;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ComplexUserRepository extends JpaRepository<ComplexUser, Long>, JpaSpecificationExecutor<ComplexUser> {
}