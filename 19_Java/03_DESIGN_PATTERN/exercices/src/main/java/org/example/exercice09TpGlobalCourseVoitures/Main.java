package org.example.exercice09TpGlobalCourseVoitures;

import org.example.exercice09TpGlobalCourseVoitures.entity.impl.*;


public class Main {
    public static void main(String[] args)  {
        Race race = Race.getInstance();
        race.addCar(new Tractor(race));
        race.addCar(new PickupToyota(race));
        race.addCar(new PickupToyota(race));
        race.addCar(new PoneyTODO(race));
        race.addCar(new Ambulance(race));

        race.start();


    }
}
