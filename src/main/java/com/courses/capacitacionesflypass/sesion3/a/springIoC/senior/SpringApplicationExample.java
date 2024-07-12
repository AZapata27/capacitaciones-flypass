package com.courses.capacitacionesflypass.sesion3.a.springIoC.senior;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.context.event.ApplicationFailedEvent;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.boot.context.event.ApplicationStartingEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.ContextStartedEvent;
import org.springframework.context.event.ContextStoppedEvent;
import org.springframework.stereotype.Component;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@Slf4j
public class SpringApplicationExample {

    public static void main(String[] args) {

        ConfigurableApplicationContext context = SpringApplication.run(SpringApplicationExample.class, args);

        String[] nombreDeBeanEnIoCcontainer  = context.getBeanDefinitionNames();
        int cuentaDeBeansEnIoCcontainer = context.getBeanDefinitionCount();

        log.info("Cuenta de beans -Z {}", cuentaDeBeansEnIoCcontainer);
        for (String nombreBeanEnIoCcontainer : nombreDeBeanEnIoCcontainer) {
            log.info("Bean -> {} ",nombreBeanEnIoCcontainer);
        }


        OtherService otherService1 = context.getBean("service1",OtherService.class);
        otherService1.doSomething();

        OtherService otherService2 = context.getBean("service2",OtherService.class);
        otherService2.doSomething();

        OtherService otherService3 = context.getBean("service3",OtherService.class);
        otherService3.doSomething();


        context.stop();

        context.close();


    }
}

@Component
class ContextRefreshedListener implements ApplicationListener<ContextRefreshedEvent> {

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        System.out.println("ContextRefreshedEvent: El contexto se ha refrescado o iniciado");
    }
}

@Component
class ContextStoppedListener implements ApplicationListener<ContextStoppedEvent> {

    @Override
    public void onApplicationEvent(ContextStoppedEvent event) {
        System.out.println("ContextStoppedEvent: El contexto se ha detenido.");
    }
}

@Component
class ContextClosedListener implements ApplicationListener<ContextClosedEvent> {

    @Override
    public void onApplicationEvent(ContextClosedEvent event) {
        System.out.println("ContextClosedEvent: El contexto se ha cerrado.");
    }
}

@Component
class ApplicationReadyListener implements ApplicationListener<ApplicationReadyEvent> {

    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        System.out.println("ApplicationReadyEvent: La aplicación está lista para recibir solicitudes.");
    }
}

@Component
class ApplicationFailedListener implements ApplicationListener<ApplicationFailedEvent> {

    @Override
    public void onApplicationEvent(ApplicationFailedEvent event) {
        System.out.println("ApplicationFailedEvent: La aplicación ha fallado.");
    }
}
