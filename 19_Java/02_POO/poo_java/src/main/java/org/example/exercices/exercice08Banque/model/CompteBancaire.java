package org.example.exercices.exercice08Banque.model;

import org.example.exercices.exercice08Banque.enums.Statut;

import java.util.ArrayList;
import java.util.List;

public abstract class CompteBancaire {

    private double solde;

    private Client client;

    private List<Operation> operationList;

    public CompteBancaire(double solde, Client client) {
        this.solde = solde;
        this.client = client;
        this.operationList = new ArrayList<>();
    }

    public CompteBancaire(Client client) {
        this.solde = 0;
        this.client = client;
        this.operationList = new ArrayList<>();
    }

    public boolean depot(double mt){
        if(mt <= 0){
            return  false;
        }
        Operation operation = new Operation(mt, Statut.DEPOT);
        operationList.add(operation);
        solde += mt;
        return true;
    }

    public boolean retrait(double mt){
        if(mt <= 0 || solde < mt){
            return false;
        }
        Operation operation = new Operation(mt,Statut.RETRAIT);
        operationList.add(operation);
        solde -= mt;
        return true;
    }

    public double getSolde() {
        return solde;
    }

    public void setSolde(double solde) {
        this.solde = solde;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<Operation> getOperationList() {
        return operationList;
    }

    public void setOperationList(List<Operation> operationList) {
        this.operationList = operationList;
    }

    @Override
    public String toString() {
        String operationsString = "\n";
        for (Operation operation : operationList){
            operationsString += operation.toString() + "\n";
        }

        return "CompteBancaire : " +
                "solde = " + solde +
                ", client = " + client.getNom() + client.getPrenom() +
                ", liste des opérations =" + operationsString +
                '.';
    }
}
