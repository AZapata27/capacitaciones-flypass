package com.courses.capacitacionesflypass.sesion3.b.exprimiendoSpring.repository;

import com.courses.capacitacionesflypass.sesion3.b.exprimiendoSpring.entity.Post;
import org.springframework.data.repository.CrudRepository;

public interface PostRepository extends CrudRepository<Post, Long> {
}