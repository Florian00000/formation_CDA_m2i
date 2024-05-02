package org.example.exercice09TpGlobalCourseVoitures.entity.impl;

import org.example.exercice09TpGlobalCourseVoitures.entity.Car;

public class PickupToyota extends Car {

    public PickupToyota(Race race) {
        super(race);
    }


    @Override
    public String toString() {
        return super.toString() + " tatatatata " + "\uD83D\uDE9A";
    }
}
