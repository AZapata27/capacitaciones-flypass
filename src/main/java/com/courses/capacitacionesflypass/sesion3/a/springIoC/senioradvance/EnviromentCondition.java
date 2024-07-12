package com.courses.capacitacionesflypass.sesion3.a.springIoC.senioradvance;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class EnviromentCondition implements Condition {

    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {

        String environment = context.getEnvironment().getProperty("app.someProp");
        return "someValue".equalsIgnoreCase(environment);
    }
}
