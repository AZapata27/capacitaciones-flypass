package com.courses.capacitacionesflypass.sesion3.b.exprimiendoSpring.jpa.repository.aa.projections.projections;

import com.courses.capacitacionesflypass.sesion3.b.exprimiendoSpring.jpa.entity.Post;

/**
 * Projection for {@link Post}
 */
public interface PostInfo {
    Long getId();

    String getTitle();

    UserInfo getAuthor();
}