package org.example.exercice06Tp3Observable;

public interface Subject {
    void registerObserver(Observer observer);
    void removeObserver(Observer observer);

    void notifyObservers();
}
