package org.example.exercice09TpGlobalCourseVoitures.entity.impl;

import org.example.exercice09TpGlobalCourseVoitures.entity.Car;

public class Ambulance extends Car {


    public Ambulance(Race race) {
        super(race);
    }

    @Override
    public String toString() {
        return super.toString() + " pouloulou " + " \uD83D\uDE91";
    }
}
