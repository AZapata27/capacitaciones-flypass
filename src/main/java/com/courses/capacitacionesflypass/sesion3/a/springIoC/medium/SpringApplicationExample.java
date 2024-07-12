package com.courses.capacitacionesflypass.sesion3.a.springIoC.medium;

import com.courses.capacitacionesflypass.sesion3.a.springIoC.basics.ExampleComponent;
import com.courses.capacitacionesflypass.sesion3.a.springIoC.basics.ExampleController;
import com.courses.capacitacionesflypass.sesion3.a.springIoC.basics.ExampleServicio;
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



        JustSimpleClass justSimpleClass = context.getBean(JustSimpleClass.class);
        justSimpleClass.justSimpleMethod();

        OtherService otherService = context.getBean(OtherService.class);
        otherService.otherMethod();




    }
}
