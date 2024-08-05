package com.courses.capacitacionesflypass.sesion3.b.exprimiendoSpring.jpa.repository;

import com.courses.capacitacionesflypass.sesion3.b.exprimiendoSpring.jpa.entity.User;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String username);

    List<User> findByEmailContaining(String email);

    @Query("select u from User u where u.email = :email")
    Optional<User> findByEmail(@Param("email") String email);

    @EntityGraph(attributePaths = {"posts"})
    @Query("select u from User u where u.username = :username")
    Optional<User> getByUserNameParam(@Param("username") String username);

    @Query("select u from User u where u.username = ?1 and u.email = ?2")
    List<User> getByUserName(String username, String email);


    @Query("SELECT u FROM User u LEFT JOIN FETCH u.posts WHERE u.id = :userId")
    Optional<User> findByIdWithPosts(@Param("userId") Long userId);



}