package com.courses.capacitacionesflypass.sesion3.a.springIoC.basics;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ExampleServicio {

    public void doSomething() {
        log.info("Servicio doSomething");
    }
}
