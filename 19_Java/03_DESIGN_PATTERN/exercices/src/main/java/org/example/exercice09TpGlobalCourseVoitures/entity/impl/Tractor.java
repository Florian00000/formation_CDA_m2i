package org.example.exercice09TpGlobalCourseVoitures.entity.impl;

import org.example.exercice09TpGlobalCourseVoitures.entity.Car;

public class Tractor extends Car {

    public Tractor(Race race) {
        super(race);
    }

    @Override
    public String toString() {
        return super.toString() + " Gros wheeling" + " \uD83D\uDE9C";
    }
}
