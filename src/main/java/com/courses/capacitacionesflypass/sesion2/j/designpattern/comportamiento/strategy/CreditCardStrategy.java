package com.courses.capacitacionesflypass.sesion2.j.designpattern.comportamiento.strategy;

class CreditCardStrategy implements PaymentStrategy {
    private String cardNumber;

    public CreditCardStrategy(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    @Override
    public void pay(int amount) {
        System.out.println("Paid " + amount + " using Credit Card ending with " + cardNumber.substring(cardNumber.length() - 4));
    }
}

class PayPalStrategy implements PaymentStrategy {
    private String email;

    public PayPalStrategy(String email) {
        this.email = email;
    }

    @Override
    public void pay(int amount) {
        System.out.println("Paid " + amount + " using PayPal account " + email);
    }
}

class GooglePayStrategy implements PaymentStrategy {
    private String username;

    public GooglePayStrategy(String username) {
        this.username = username;
    }

    @Override
    public void pay(int amount) {
        System.out.println("Paid " + amount + " using Google Pay account " + username);
    }
}
