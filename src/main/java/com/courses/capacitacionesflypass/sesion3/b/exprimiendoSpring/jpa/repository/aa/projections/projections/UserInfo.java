package com.courses.capacitacionesflypass.sesion3.b.exprimiendoSpring.jpa.repository.aa.projections.projections;

import com.courses.capacitacionesflypass.sesion3.b.exprimiendoSpring.jpa.entity.User;

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