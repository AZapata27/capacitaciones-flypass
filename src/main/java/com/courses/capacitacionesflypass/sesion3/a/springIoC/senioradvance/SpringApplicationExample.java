package com.courses.capacitacionesflypass.sesion3.a.springIoC.senioradvance;

import com.courses.capacitacionesflypass.sesion3.a.springIoC.senioradvance.desingpatters.PaymentProcessor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.ConfigurableApplicationContext;


@SpringBootConfiguration
@Slf4j
public class SpringApplicationExample {

    public static void main(String[] args) {

        SpringApplication app = new SpringApplication(SpringApplicationExample.class);
        ConfigurableApplicationContext context = app.run(args);


        PaymentProcessor paymentProcessor = context.getBean(PaymentProcessor.class);

        paymentProcessor.processPayment("creditCardPaymentService");
        paymentProcessor.processPayment("bankTransferPaymentService");
        paymentProcessor.processPayment("cashPaymentService");
        paymentProcessor.processPayment("cryptoPaymentService");


    }
}