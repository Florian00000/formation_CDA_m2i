package org.example.demo_strategy;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Order {
    private double amount;

    public void pay(PaymentStrategy paymentStrategy) {
        paymentStrategy.pay(amount);
    }
}
