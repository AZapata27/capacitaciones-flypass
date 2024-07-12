package com.courses.capacitacionesflypass.sesion3.a.springIoC.senior;


import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class ExampleComponent {

    private final OtherService otherService;

    public ExampleComponent(@Qualifier("service1") OtherService otherService) {
        this.otherService = otherService;
    }

    @PostConstruct
    public void init() {
        System.out.println("PostConstruct: Bean example componente inicializado.");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("PreDestroy: Bean example componente a punto de ser destruido.");
    }
}
