package com.courses.capacitacionesflypass.sesion3.b.exprimiendoSpring.entity.projections;

import java.time.LocalDateTime;

public record UserRecord(Long id, String username, String email, LocalDateTime createdAt, String createdBy) {
}
