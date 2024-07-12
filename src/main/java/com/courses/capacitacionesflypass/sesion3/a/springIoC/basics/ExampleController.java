package com.courses.capacitacionesflypass.sesion3.a.springIoC.basics;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;

@Controller
@Slf4j
public class ExampleController {

    public void doSomething() {
        log.info("Controller doSomething");
    }
}
