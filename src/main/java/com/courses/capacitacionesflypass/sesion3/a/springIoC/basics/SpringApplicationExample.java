package com.courses.capacitacionesflypass.sesion3.a.springIoC.basics;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.MutablePropertySources;

import java.util.Map;

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



        ExampleServicio exampleServicio = context.getBean(ExampleServicio.class);
        exampleServicio.doSomething();

        ExampleComponent exampleComponent = context.getBean(ExampleComponent.class);
        exampleComponent.doSomething();

        ExampleController exampleController = context.getBean(ExampleController.class);
        exampleController.doSomething();





        String[] activeProfiles = context.getEnvironment().getActiveProfiles();

        String[] defaultProfiles = context.getEnvironment().getDefaultProfiles();

        Map<String, Object> systemEnvironment = context.getEnvironment().getSystemEnvironment();

        MutablePropertySources propertySources = context.getEnvironment().getPropertySources();







        log.info("Active Profiles:");
        for (String profile : activeProfiles) {
            log.info("-  {}", profile);
        }
        log.info("Default Profiles:");
        for (String profile : defaultProfiles) {

            log.info("-  {}", profile);
        }

        log.info("System Environment:");
        for (Map.Entry<String, Object> entry : systemEnvironment.entrySet()) {
            log.info("-   {}: {}", entry.getKey(), entry.getValue());
        }

        log.info("Property Sources:");
        propertySources.forEach(propertySource -> log.info("-  {}: {}", propertySource.getName(), propertySource.getSource()));




    }
}
