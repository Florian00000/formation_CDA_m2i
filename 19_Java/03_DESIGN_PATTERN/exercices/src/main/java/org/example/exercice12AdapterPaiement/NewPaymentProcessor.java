package org.example.exercice12AdapterPaiement;

public class NewPaymentProcessor {
    private boolean isAuthenticate = false;


    public void authenticate(String apiKey){
        isAuthenticate = true;
    }

    public void sendPayment(double amount){
        if(isAuthenticate){
            System.out.println("Paiement de " + amount + " €");
        }else {
            System.out.println("Connectez vous");
        }
    }

}
