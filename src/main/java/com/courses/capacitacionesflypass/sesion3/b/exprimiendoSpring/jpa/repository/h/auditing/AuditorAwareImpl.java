package com.courses.capacitacionesflypass.sesion3.b.exprimiendoSpring.jpa.repository.h.auditing;

import org.springframework.data.domain.AuditorAware;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class AuditorAwareImpl implements AuditorAware<String> {

    @Override
    public Optional<String> getCurrentAuditor() {
        // Aquí debes implementar la lógica para obtener el nombre del usuario actual.
        // Por ejemplo, puedes obtenerlo desde el contexto de seguridad.
        return Optional.of("defaultUser"); // Retorna el nombre de usuario actual
    }
}
