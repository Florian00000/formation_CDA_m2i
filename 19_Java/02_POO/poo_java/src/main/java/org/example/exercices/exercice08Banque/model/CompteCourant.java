package org.example.exercices.exercice08Banque.model;

public class CompteCourant extends CompteBancaire{
    public CompteCourant(double solde, Client client) {
        super(solde, client);
    }

    public CompteCourant(Client client) {
        super(client);
    }
}
