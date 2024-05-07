package org.example.exerciceDesignPatternPlateform.Entity;

public class Student extends Person implements Observer{
    @Override
    public void receiveNotification(Lesson lesson) {
        System.out.println("changement sur " + lesson);
    }
}
