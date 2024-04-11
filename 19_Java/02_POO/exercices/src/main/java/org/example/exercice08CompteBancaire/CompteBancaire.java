package org.example.exercice08CompteBancaire;

import java.util.ArrayList;
import java.util.List;

public abstract class CompteBancaire {
    protected double solde;
    protected String client;
    //TODO à changer en objet opérations
    List <String> listeOperations = new ArrayList<String>();

    public CompteBancaire(double solde, String client) {
        this.solde = solde;
        this.client = client;
    }
}
