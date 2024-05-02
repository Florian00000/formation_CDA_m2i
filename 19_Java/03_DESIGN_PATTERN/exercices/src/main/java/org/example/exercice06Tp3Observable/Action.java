package org.example.exercice06Tp3Observable;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Action implements Subject {

    private String nom;
    private double prix = new Random().nextDouble(1 , 100);
    private List<Observer> observers = new ArrayList<>();

    public String getNom() {
        return nom;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix() {
        this.prix = new Random().nextDouble(1 , 100);
        notifyObservers();
    }

    @Override
    public String toString() {
        return "Action{" +
                "nom= '" + nom + '\'' +
                ", prix =" + prix +
                ", observers =" + observers +
                '}';
    }

    @Override
    public void registerObserver(Observer observer) {

    }

    @Override
    public void removeObserver(Observer observer) {

    }

    @Override
    public void notifyObservers() {
        observers.forEach(o -> o.alertObserver(this));
    }
}
