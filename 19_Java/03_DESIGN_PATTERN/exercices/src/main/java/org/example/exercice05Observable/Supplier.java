package org.example.exercice05Observable;

public class Supplier implements Observer{
    @Override
    public void update(Product product) {
        System.out.println("le fournisseur fournit");
    }
}
