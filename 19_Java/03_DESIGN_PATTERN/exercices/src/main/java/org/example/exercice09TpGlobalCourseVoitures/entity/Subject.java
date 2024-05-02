package org.example.exercice09TpGlobalCourseVoitures.entity;

public interface Subject<T> {
    void addObserver(Observer<T> observer);
    void removeObserver(Observer<T> observer);
    void notifyObservers();
}
