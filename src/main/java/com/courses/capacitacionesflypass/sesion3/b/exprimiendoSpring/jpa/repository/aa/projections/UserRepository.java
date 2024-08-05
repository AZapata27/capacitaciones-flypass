package com.courses.capacitacionesflypass.sesion3.b.exprimiendoSpring.jpa.repository.aa.projections;

import com.courses.capacitacionesflypass.sesion3.b.exprimiendoSpring.jpa.entity.User;
import com.courses.capacitacionesflypass.sesion3.b.exprimiendoSpring.jpa.repository.aa.projections.projections.UserDto;
import com.courses.capacitacionesflypass.sesion3.b.exprimiendoSpring.jpa.repository.aa.projections.projections.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {


    @Query("select u from User u where u.username = :username")
    Optional<UserInfo> findByUsername(@Param("username") String username);


    @Query("select u from User u where u.username = :username")
    Optional<UserDto> findByUsername_Dto(@Param("username") String username);

    @Query("select u from User u where u.active = :active")
    List<UserDto> findByActive(@Param("active") boolean active);



    @Query("select u from User u")
    <T> List<T> findAllProjectedBy(Class<T> type);

}