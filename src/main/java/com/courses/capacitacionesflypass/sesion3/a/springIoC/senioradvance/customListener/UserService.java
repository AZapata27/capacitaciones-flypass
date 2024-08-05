package com.courses.capacitacionesflypass.sesion3.a.springIoC.senioradvance.customListener;

import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final ApplicationEventPublisher eventPublisher;

    public void registerUser(String username) {
        // Lógica para registrar al usuario
        // ...

        // Publicar evento de usuario registrado si nada fallo
        UserRegisteredEvent event = new UserRegisteredEvent(this, username);
        eventPublisher.publishEvent(event);
    }
}
