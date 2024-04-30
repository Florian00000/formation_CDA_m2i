package org.example.exercice05Observable;

public class StockManager implements Observer{
    @Override
    public void update(Product product) {
        System.out.println("Stock mis à jour");
    }
}
