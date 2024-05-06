package org.example.exercice12AdapterPaiement;

public class PaymentAdapter implements OldPaymentGatewayInterface{

    private String apiKey;



    @Override
    public void makePayment(String accountNumber, double amount) {
        NewPaymentProcessor paymentProcessor = new NewPaymentProcessor();
        paymentProcessor.authenticate(this.apiKey);
        paymentProcessor.sendPayment(amount);
    }

    public void login(String apiKey) {
        this.apiKey = apiKey;
    }
}
