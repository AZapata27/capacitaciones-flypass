package com.courses.capacitacionesflypass.sesion3.b.exprimiendoSpring.jpa.repository.aa.projections.projections;

import java.time.LocalDateTime;

public record UserDto(Long id, String username, String email, LocalDateTime createdAt, String createdBy) {
}
