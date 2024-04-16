package org.example.exercices.exercice08Banque.model;

public class CompteEpargne extends CompteBancaire{

    private double taux;
    public CompteEpargne(double solde, Client client, double taux) {
        super(solde, client);
        this.taux = taux;
    }

    public CompteEpargne(Client client, double taux) {
        super(client);
        this.taux = taux;
    }

    public void calculerLesInterets(int anneesPlacement){
        double newSolde = this.getSolde();
        for (int i = 0; i < anneesPlacement; i++){
           newSolde +=  newSolde * (taux/100);
        }
        this.setSolde(newSolde);
    }
}
