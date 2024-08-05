package com.courses.capacitacionesflypass.sesion3.b.exprimiendoSpring.jpa.entity.compositeprimerykey.embeddable;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "user_roles")
public class UserRole {

    @EmbeddedId
    private UserRoleId id;

    private String description;

    private String status;


}
