package org.example.demos.demo09Exception.creationException;

public class Compte {
    private int code;
    private float solde;
    public void verser(float mt){
        solde=solde+mt;
    }
    public void retirer(float mt)throws SoldeInsuffisantException{
        if(mt>solde) throw new SoldeInsuffisantException("Solde Insuffisant");
        solde=solde-mt;
    }
    public float getSolde(){
        return solde;
    }
}
