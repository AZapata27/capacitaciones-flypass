package com.courses.capacitacionesflypass.sesion3.a.springIoC.senior;

import org.springframework.boot.context.event.ApplicationFailedEvent;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class MyEventListener {

    @EventListener
    public void handleReadyEvent(ApplicationReadyEvent event) {
        System.out.println("APLICACION READY PARA HACER COSAS CUANDO ESTE LISTA!");
    }
}

@Component
class MyEventListener2 {

    @EventListener
    public void handleContextInit(ApplicationFailedEvent event) {
        System.out.println("APLICACION FAILED ZZZ si se debe reportar que se hace?!");
    }
}
