package org.example.exercice08CompteBancaire;

import java.util.ArrayList;
import java.util.List;

public abstract class CompteBancaire {
    protected double solde;
    protected Client client;
    protected List <Operation> listeOperations = new ArrayList<Operation>();

    public CompteBancaire(double solde, Client client) {
        this.solde = solde;
        this.client = client;
    }

    @Override
    public String toString() {
        return "CompteBancaire{" +
                "solde=" + solde +
                ", client=" + client +
                ", listeOperations=" + listeOperations +
                '}';
    }

    public double getSolde() {
        return solde;
    }

    public void setSolde(double solde) {
        this.solde = solde;
    }

    public List<Operation> getListeOperations() {
        return listeOperations;
    }
}
