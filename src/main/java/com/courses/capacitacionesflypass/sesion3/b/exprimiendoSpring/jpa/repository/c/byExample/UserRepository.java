package com.courses.capacitacionesflypass.sesion3.b.exprimiendoSpring.jpa.repository.c.byExample;

import com.courses.capacitacionesflypass.sesion3.b.exprimiendoSpring.jpa.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

public interface UserRepository extends JpaRepository<User, Long>, QueryByExampleExecutor<User> {
}
