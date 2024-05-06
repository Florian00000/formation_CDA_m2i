package org.example.exercice12AdapterPaiement;

public class Client {
    public static void main(String[] args) {
        OldPaymentGatewayInterface payment = new PaymentAdapter();
        payment.makePayment("eveve", 125.25);
    }
}
