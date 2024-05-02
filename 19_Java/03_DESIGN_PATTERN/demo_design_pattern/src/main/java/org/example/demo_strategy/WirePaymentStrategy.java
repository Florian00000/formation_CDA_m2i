package org.example.demo_strategy;

public class WirePaymentStrategy implements PaymentStrategy {
    @Override
    public boolean pay(double amount) {
        System.out.println("Wire payment "+ amount);
        return true;
    }
}
