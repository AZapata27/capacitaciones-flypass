package com.courses.capacitacionesflypass.sesion3.a.springIoC.senioradvance.desingpatters;

import com.courses.capacitacionesflypass.sesion3.a.springIoC.senior.OtherService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.FilterType;


//@SpringBootApplication

@SpringBootConfiguration
@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class})
@Slf4j
public class SpringApplicationExample {

    public static void main(String[] args) {

        SpringApplication app = new SpringApplication(SpringApplicationExample.class);
        app.setLogStartupInfo(true);  //default TRUE
        app.setLazyInitialization(true); //default false

        app.setAdditionalProfiles("dev"); // Establece el perfil activo puede ser de forma muy programatica por diferentes condiciones

        ConfigurableApplicationContext context = app.run(args);


        OtherService otherServicePROFILE = context.getBean(OtherService.class);
        otherServicePROFILE.doSomething();

        OtherService otherService1 = context.getBean("service1", OtherService.class);
        otherService1.doSomething();

        OtherService otherService2 = context.getBean("service2", OtherService.class);  // NO LO ENCUENTRA POR QUE NO ESTA EN EL PROFILE DESIGNADO
        otherService2.doSomething();

        OtherService otherService3 = context.getBean("service3", OtherService.class);
        otherService3.doSomething();


        if (context.containsBean("justSimpleClass")) {
            System.out.println("El bean 'justSimpleClass' fue creado porque estamos en un entorno de desarrollo y la característica está habilitada.");
        } else {
            System.out.println("El bean 'justSimpleClass' no fue creado porque no se cumplieron todas las condiciones.");
        }


    }
}