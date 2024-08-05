package com.courses.capacitacionesflypass.sesion3.b.exprimiendoSpring.jpa.repository;

import com.courses.capacitacionesflypass.sesion3.b.exprimiendoSpring.jpa.entity.Post;
import org.springframework.data.repository.CrudRepository;

public interface PostRepository extends CrudRepository<Post, Long> {
}