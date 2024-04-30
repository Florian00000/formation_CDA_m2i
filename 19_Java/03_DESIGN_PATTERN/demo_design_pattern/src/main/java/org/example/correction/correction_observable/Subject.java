package org.example.correction.correction_observable;

public interface Subject<T> {
    void registerObserver(Observer<T> observer);
    void removeObserver(Observer<T> observer);
    void notifyObservers(T element);
}
