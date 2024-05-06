package org.example.exercice12AdapterPaiement;

public class OldPaymentGateway implements OldPaymentGatewayInterface {

    public void makePayment(String accountNumber, double amount){
        System.out.println("Paiement d'un montant de " + amount + " au compte n°" + accountNumber);
    }
}
