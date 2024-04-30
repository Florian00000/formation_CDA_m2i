package org.example.exercice06Tp3Observable;

public class Investisseur implements Observer<Action> {
    @Override
    public void alertObserver(Action subject) {
        System.out.println("Changements de prix sur l'action " + subject.getNom() + ": " + subject.getPrix());
    }

    public void suivreAction(Action action) {
        action.registerObserver(this);
    }
}
