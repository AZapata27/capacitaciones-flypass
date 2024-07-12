package com.courses.capacitacionesflypass.sesion3.a.springIoC.senioradvance;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class FeatureEnabledCondition implements Condition {

    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        String featureEnabled = context.getEnvironment().getProperty("app.feature.enabled");
        return "true".equalsIgnoreCase(featureEnabled);
    }
}
