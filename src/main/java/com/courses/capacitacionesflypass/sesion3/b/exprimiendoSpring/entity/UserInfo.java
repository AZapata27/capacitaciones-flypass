package com.courses.capacitacionesflypass.sesion3.b.exprimiendoSpring.entity;

import java.time.LocalDateTime;

/**
 * Projection for {@link User}
 */
public interface UserInfo {
    Long getId();

    String getUsername();

    String getEmail();

    LocalDateTime getCreatedAt();

    String getCreatedBy();
}