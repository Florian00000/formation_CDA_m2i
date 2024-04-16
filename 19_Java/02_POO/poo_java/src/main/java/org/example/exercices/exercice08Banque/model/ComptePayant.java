package org.example.exercices.exercice08Banque.model;

public class ComptePayant extends CompteBancaire{

    private double coutOperation = 0.5;
    public ComptePayant(double solde, Client client) {
        super(solde, client);
    }

    public ComptePayant(Client client) {
        super(client);
    }

    @Override
    public boolean depot(double mt){
        if(mt <= coutOperation || this.getSolde() >= coutOperation){
            return  false;
        }
        super.depot(mt);
      return  super.retrait(coutOperation);
    }

    public boolean retrait(double mt){
        if(mt <= coutOperation || this.getSolde() < (mt + coutOperation)){
            return false;
        }
        super.retrait(mt);
        return super.retrait(coutOperation);
    }
}
