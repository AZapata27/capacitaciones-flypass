package com.courses.capacitacionesflypass.sesion3.b.exprimiendoSpring.jpa.entity.compositeprimerykey.clasid;

import com.courses.capacitacionesflypass.sesion3.b.exprimiendoSpring.jpa.entity.compositeprimerykey.embeddable.UserRoleId;
import jakarta.persistence.*;

@Entity
@Table(name = "user_roles")
@IdClass(UserRoleId.class)
public class UserRole {

    @Id
    private Long userId;

    @Id
    private Long roleId;

    private String description;
    private String status;
}
