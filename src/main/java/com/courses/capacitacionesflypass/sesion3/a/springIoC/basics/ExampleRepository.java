package com.courses.capacitacionesflypass.sesion3.a.springIoC.basics;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

@Repository
@Slf4j
public class ExampleRepository {

    public void doSomething() {
        log.info("Repository doSomething");
    }
}
