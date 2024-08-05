package com.courses.capacitacionesflypass.sesion3.b.exprimiendoSpring.jpa.entity.compositeprimerykey.embeddable;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter

@Embeddable
public class UserRoleId implements Serializable {

    private Long userId;
    private Long roleId;

}
