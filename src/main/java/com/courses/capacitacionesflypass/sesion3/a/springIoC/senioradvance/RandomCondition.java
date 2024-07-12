package com.courses.capacitacionesflypass.sesion3.a.springIoC.senioradvance;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

import java.util.Random;

public class RandomCondition implements Condition {

    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        Random random = new Random();
        return random.nextDouble() > 0.5;
    }
}
