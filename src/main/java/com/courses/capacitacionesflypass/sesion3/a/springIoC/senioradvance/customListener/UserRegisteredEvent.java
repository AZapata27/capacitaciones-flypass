package com.courses.capacitacionesflypass.sesion3.a.springIoC.senioradvance.customListener;

import org.springframework.context.ApplicationEvent;

public class UserRegisteredEvent extends ApplicationEvent {

    private String username;

    public UserRegisteredEvent(Object source, String username) {
        super(source);
        this.username = username;
    }

    public String getUsername() {
        return username;
    }
}