package com.courses.capacitacionesflypass.sesion3.b.exprimiendoSpring.entity.projections;

import com.courses.capacitacionesflypass.sesion3.b.exprimiendoSpring.entity.Post;

/**
 * Projection for {@link Post}
 */
public interface PostInfo {
    Long getId();

    String getTitle();

    UserInfo getAuthor();
}