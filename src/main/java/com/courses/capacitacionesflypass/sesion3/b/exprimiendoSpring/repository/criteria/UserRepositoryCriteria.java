package com.courses.capacitacionesflypass.sesion3.b.exprimiendoSpring.repository.criteria;

import com.courses.capacitacionesflypass.sesion3.b.exprimiendoSpring.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface UserRepositoryCriteria extends JpaRepository<User, Long>, JpaSpecificationExecutor<User> {



}