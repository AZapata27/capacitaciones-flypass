package com.courses.capacitacionesflypass.sesion3.b.exprimiendoSpring.jpa.repository.d.criteria;

import com.courses.capacitacionesflypass.sesion3.b.exprimiendoSpring.jpa.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface UserRepositoryCriteria extends JpaRepository<User, Long>, JpaSpecificationExecutor<User> {



}