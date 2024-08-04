package com.courses.capacitacionesflypass.sesion3.a.springIoC.senioradvance;

import com.courses.capacitacionesflypass.sesion3.a.springIoC.medium.JustSimpleClass;
import com.courses.capacitacionesflypass.sesion3.a.springIoC.senior.OtherService;
import com.courses.capacitacionesflypass.sesion3.a.springIoC.senior.OtherServiceImplONE;
import com.courses.capacitacionesflypass.sesion3.a.springIoC.senior.OtherServiceImplTWO;
import jakarta.servlet.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Configuration
@Slf4j
public class BeanConfig {

    @Bean
    @Conditional({RandomCondition.class, FeatureEnabledCondition.class, EnviromentCondition.class})
    JustSimpleClass justSimpleClass() {
        return new JustSimpleClass();
    }

    @Bean("service1")
    @Profile("dev")
    OtherService otherService() {
        return new OtherServiceImplONE();
    }

    @Bean("service2")
    @Profile("cert")
    OtherService otherService2() {
        return new OtherServiceImplTWO();
    }

    @Bean("service3")
    @Profile("pdn")
    @Lazy
    OtherService otherService3() {
        return () -> log.info("Do something 3 from lambda implementation");
    }

}


@Component
@Order(1)
class FirstFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        System.out.println("First filter is executed.");
        chain.doFilter(request, response);
    }
}

@Component
@Order(2)
class SecondFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        System.out.println("Second filter is executed.");
        chain.doFilter(request, response);
    }
}
