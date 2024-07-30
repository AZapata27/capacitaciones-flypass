package com.courses.capacitacionesflypass.sesion3.b.exprimiendoSpring.entity;

/**
 * Projection for {@link Post}
 */
public interface PostInfo {
    Long getId();

    String getTitle();

    UserInfo getAuthor();
}