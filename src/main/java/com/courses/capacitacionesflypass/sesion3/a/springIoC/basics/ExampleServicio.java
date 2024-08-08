package com.courses.capacitacionesflypass.sesion3.a.springIoC.basics;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ExampleServicio {

    private ExampleRepository exampleRepository;

    public void doSomething() {
        log.info("Servicio doSomething");
    }



    public void setExampleRepository(ExampleRepository exampleRepository) {
        this.exampleRepository = exampleRepository;
    }
}
