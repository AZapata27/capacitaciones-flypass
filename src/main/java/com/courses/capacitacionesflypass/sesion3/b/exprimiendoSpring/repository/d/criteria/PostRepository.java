package com.courses.capacitacionesflypass.sesion3.b.exprimiendoSpring.repository.d.criteria;

import com.courses.capacitacionesflypass.sesion3.b.exprimiendoSpring.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface PostRepository extends JpaRepository<Post, Long>, JpaSpecificationExecutor<Post> {
}