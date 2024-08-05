package com.courses.capacitacionesflypass.sesion3.b.exprimiendoSpring.jpa.repository.aa.projections;

import com.courses.capacitacionesflypass.sesion3.b.exprimiendoSpring.jpa.entity.Post;
import com.courses.capacitacionesflypass.sesion3.b.exprimiendoSpring.jpa.repository.aa.projections.projections.PostDto;
import com.courses.capacitacionesflypass.sesion3.b.exprimiendoSpring.jpa.repository.aa.projections.projections.PostInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface PostRepository extends JpaRepository<Post, Long> {


  @Query("select p from Post p where p.author.username = :username")
  Optional<PostInfo> findByAuthor_Username(@Param("username") String username);

  @Query("select p from Post p where p.author.username = :username")
  Optional<PostDto> findByAuthor_Username_Dto(@Param("username") String username);


}