package com.courses.capacitacionesflypass.sesion3.b.exprimiendoSpring.jpa.entity.compositeprimerykey.clasid;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
public class UserRoleId implements Serializable {

    private Long userId;
    private Long roleId;
    private String description;

    private String status;
}
