package com.courses.capacitacionesflypass.sesion3.a.springIoC.medium;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
public class BeanConfig {

    @Bean
    JustSimpleClass justSimpleClass() {
        return new JustSimpleClass();
    }

    @Bean
    OtherService otherService() {
        return new OtherServiceImpl();
    }

    /*@Bean
    OtherService otherServiceLambda() {
        return ()-> log.info("doSomething in the lambda ");
    }*/


}
