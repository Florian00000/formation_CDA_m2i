package org.example.demo_strategy;

public class Main {
    public static void main(String[] args) {
        Order o = Order.builder().amount(300).build();
        o.pay(new CardPaymentStrategy());
        Order o2 = Order.builder().amount(500).build();
        o2.pay(new WirePaymentStrategy());
    }
}
