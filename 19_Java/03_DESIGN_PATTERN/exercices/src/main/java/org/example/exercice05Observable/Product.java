package org.example.exercice05Observable;

import java.util.ArrayList;
import java.util.List;

public class Product implements Subject {

    private int stockLevel;

    private List<Observer> observers = new ArrayList<>();


    public void setStockLevel(int stockLevel) {
        this.stockLevel = stockLevel;
        notifyObservers();
    }


    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        observers.forEach(o -> o.update(this));
    }
}
