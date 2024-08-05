package com.courses.capacitacionesflypass.sesion3.a.springIoC.senioradvance.customListener;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class UserRegisteredListener {

    @EventListener
    public void handleUserRegisteredEvent(UserRegisteredEvent event) {
        // Lógica para manejar el evento, como enviar un correo de bienvenida
        System.out.println("User registered with username: " + event.getUsername());
    }
}
