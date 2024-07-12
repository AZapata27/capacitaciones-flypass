package com.courses.capacitacionesflypass.sesion3.a.springIoC.utils;

import com.courses.capacitacionesflypass.sesion3.a.springIoC.medium.JustSimpleClass;
import com.courses.capacitacionesflypass.sesion3.a.springIoC.senior.OtherService;
import com.courses.capacitacionesflypass.sesion3.a.springIoC.senior.OtherServiceImplONE;
import com.courses.capacitacionesflypass.sesion3.a.springIoC.senior.OtherServiceImplTWO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

@Configuration
@Slf4j
public class BeanConfig {

    @Bean
    JustSimpleClass justSimpleClass() {
        return new JustSimpleClass();
    }

    @Bean("service1")
    @DependsOn("service2")
    OtherService otherService() {
        return new OtherServiceImplONE();
    }

    @Bean("service2")
        //@Profile("pdn")
    OtherService otherService2() {
        return new OtherServiceImplTWO();
    }

    @Bean("service3")
    OtherService otherService3() {
        return () -> log.info("Do something 3 from lambda implementation");
    }

}