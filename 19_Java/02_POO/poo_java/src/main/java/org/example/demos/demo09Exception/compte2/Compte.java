package org.example.demos.demo09Exception.compte2;

public class Compte {
    private int code;
    private float solde;
    public void verser(float mt){
        solde=solde+mt;
    }
    public void retirer(float mt){
        if(mt>solde) throw new RuntimeException("Solde Insuffisant");
        solde=solde-mt;
    }
    public float getSolde(){
        return solde;
    }
}
