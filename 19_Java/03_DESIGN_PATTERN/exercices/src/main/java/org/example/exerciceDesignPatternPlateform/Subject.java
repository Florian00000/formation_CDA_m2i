package org.example.exerciceDesignPatternPlateform;

import org.example.exerciceDesignPatternPlateform.Entity.Lesson;
import org.example.exerciceDesignPatternPlateform.Entity.Observer;

public interface Subject {
    void registerObserver(Observer observer);
    void removeObserver(Observer observer);


    void notifyObservers(Lesson lesson);
}
