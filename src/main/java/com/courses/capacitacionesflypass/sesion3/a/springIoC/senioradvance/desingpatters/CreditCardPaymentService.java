package com.courses.capacitacionesflypass.sesion3.a.springIoC.senioradvance.desingpatters;

import org.springframework.stereotype.Service;

@Service("creditCardPaymentService")
public class CreditCardPaymentService implements PaymentService {
    @Override
    public Payment processPayment() {
        System.out.println("Processing payment with credit card.");
        return new Payment();
    }
}


@Service("bankTransferPaymentService")
class BankTransferPaymentService implements PaymentService {
    @Override
    public Payment processPayment() {
        System.out.println("Processing payment with bank transfer.");
        return new Payment();
    }
}

@Service("cashPaymentService")
class CashPaymentService implements PaymentService {
    @Override
    public Payment processPayment() {
        System.out.println("Processing payment with cash.");
        return new Payment();
    }
}

@Service("cryptoPaymentService")
class CryptoPaymentService implements PaymentService {
    @Override
    public Payment processPayment() {
        System.out.println("Processing payment with cryptocurrency.");

        return new Payment();
    }
}
