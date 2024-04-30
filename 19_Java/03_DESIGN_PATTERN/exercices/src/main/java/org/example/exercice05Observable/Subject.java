package org.example.exercice05Observable;

public interface Subject {
    void registerObserver(Observer observer);
    void removeObserver(Observer observer);

    public void notifyObservers();
}
