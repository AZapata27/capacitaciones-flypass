package com.courses.capacitacionesflypass.sesion3.a.springIoC.utils;

import com.courses.capacitacionesflypass.sesion3.a.springIoC.senioradvance.RandomCondition;
import org.springframework.boot.autoconfigure.condition.*;
import org.springframework.boot.cloud.CloudPlatform;
import org.springframework.boot.system.JavaVersion;
import org.springframework.context.annotation.*;
import org.springframework.stereotype.Component;

@Component("qualifierName")
@DependsOn
@ConditionalOnProperty("app.datasource.enabled")
@Profile("dev")
@Conditional(RandomCondition.class)
@ConditionalOnExpression("${notifications.enabled} && ${notifications.email}")
@ConditionalOnCloudPlatform(CloudPlatform.KUBERNETES)
@ConditionalOnJava(JavaVersion.TWENTY_ONE)
public class ExampleComponent {

}






















/*
@Configuration
public class AppConfig {

    @Bean
    @ConditionalOnProperty(name = "feature.enabled", havingValue = "true")
    public FeatureBean featureBean() {
        return new FeatureBean();
    }

    @Bean
    @Profile("dev")
    public DevBean devBean() {
        return new DevBean();
    }

    @Bean
    @Conditional(MyCondition.class)
    public MyBean myBean() {
        return new MyBean();
    }

    @Bean
    @ConditionalOnExpression("${notifications.enabled} && ${notifications.email}")
    public NotificationBean notificationBean() {
        return new NotificationBean();
    }

    @Bean
    @ConditionalOnCloudPlatform(CloudPlatform.KUBERNETES)
    public KubernetesBean kubernetesBean() {
        return new KubernetesBean();
    }

    @Bean
    @ConditionalOnJava(JavaVersion.TWENTY_ONE)
    public Java21Bean java21Bean() {
        return new Java21Bean();
    }
}*/
