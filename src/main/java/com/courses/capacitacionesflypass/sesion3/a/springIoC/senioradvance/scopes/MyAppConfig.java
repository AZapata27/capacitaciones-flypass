package com.courses.capacitacionesflypass.sesion3.a.springIoC.senioradvance.scopes;

import lombok.Getter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.web.context.request.RequestContextListener;

@Configuration
public class MyAppConfig {

    @Bean
    @Scope("singleton")
    public CounterBean singletonBean() {
        return new CounterBean("Singleton Bean");
    }

    @Bean
    @Scope("prototype")
    public CounterBean prototypeBean() {
        return new CounterBean("Prototype Bean");
    }

    @Bean
    @Scope("request")
    public CounterBean requestBean() {
        return new CounterBean("Request Bean");
    }

    @Bean
    @Scope("session")
    public CounterBean sessionBean() {
        return new CounterBean("Session Bean");
    }

    @Bean
    @Scope("application")
    public CounterBean applicationBean() {
        return new CounterBean("Application Bean");
    }

    @Bean
    @Scope("websocket")
    public CounterBean websocketBean() {
        return new CounterBean("WebSocket Bean");
    }


}


