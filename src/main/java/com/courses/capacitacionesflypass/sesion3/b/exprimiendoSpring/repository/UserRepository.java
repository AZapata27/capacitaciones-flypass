package com.courses.capacitacionesflypass.sesion3.b.exprimiendoSpring.repository;

import com.courses.capacitacionesflypass.sesion3.b.exprimiendoSpring.entity.User;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String username);

    List<User> findByEmailContaining(String email);

    @EntityGraph(attributePaths = {"posts"})
    @Query("select u from UserLifeCycle u where u.username = :username")
    Optional<User> getByUserNameParam(@Param("username") String username);

    @Query("select u from UserLifeCycle u where u.username = ?1 and u.email = ?2")
    List<User> getByUserName(String username, String email);


    @Query("SELECT u FROM UserLifeCycle u LEFT JOIN FETCH u.posts WHERE u.id = :userId")
    Optional<User> findByIdWithPosts(@Param("userId") Long userId);
}