package com.courses.capacitacionesflypass.sesion3.a.springIoC.senioradvance.desingpatters;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class PaymentProcessor {

    private final Map<String, PaymentService> paymentServices;
    private final List<PaymentValidator> paymentValidatorList;

    public PaymentProcessor(Map<String, PaymentService> paymentServices,
                            List<PaymentValidator> paymentValidatorList) {
        this.paymentServices = paymentServices;
        this.paymentValidatorList = paymentValidatorList;
    }

    public void processPayment(String paymentType) {
        PaymentService paymentService = paymentServices.get(paymentType);


        Payment payment;

        if (paymentService != null) {
           payment = paymentService.processPayment();
        } else {
           throw new IllegalArgumentException("Payment type not supported");
        }


        boolean isValid = paymentValidatorList.stream()
                .allMatch(paymentValidator -> paymentValidator.validatePayment(payment));


        if(isValid) {
            System.out.println("Payment is valid");
        } else {
            throw new IllegalArgumentException("Payment is not valid");
        }

    }
}
