package com.courses.capacitacionesflypass.sesion3.a.springIoC.senior;

import com.courses.capacitacionesflypass.sesion3.a.springIoC.medium.JustSimpleClass;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

@Configuration
@Slf4j
public class BeanConfig {

    @Bean
    JustSimpleClass justSimpleClass() {
        return new JustSimpleClass();
    }

    @Bean("service1")
    //@Primary
    OtherService otherService() {
        return new OtherServiceImplONE();
    }

    @Bean("service2")
    OtherService otherService2() {
        return new OtherServiceImplTWO();
    }

    @Bean("service3")
    OtherService otherService3() {
        return () -> log.info("Do something 3 from lambda implementation");
    }

}
