package org.example.exerciceDesignPatternPlateform;

import org.example.exerciceDesignPatternPlateform.Entity.Lesson;
import org.example.exerciceDesignPatternPlateform.Entity.Observer;

import java.util.ArrayList;
import java.util.List;

public class Application implements Subject {
   private List<Lesson> lessonList ;
    private static Application INSTANCE;
    private List<Observer> observerList ;

    private Application() {
        this.lessonList = new ArrayList<>();
        this.observerList = new ArrayList<>();
    }

    public static synchronized Application getInstance() {
        if(INSTANCE == null) {
            INSTANCE = new Application();
        }
        return INSTANCE;
    }

    public void publishLesson(Lesson lesson) {
        lessonList.add(lesson);
    }

    @Override
    public void registerObserver(Observer observer) {
        observerList.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observerList.remove(observer);
    }

    @Override
    public void notifyObservers(Lesson lesson) {
        observerList.forEach(observer -> observer.receiveNotification(lesson) );

    }
}
