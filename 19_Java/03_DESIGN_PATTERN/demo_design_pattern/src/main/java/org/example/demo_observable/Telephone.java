package org.example.demo_observable;

public class Telephone implements Observer {

    @Override
    public void update(Weather weather) {
        System.out.println("Le téléphone s'actualise avec la température "+weather.getTemperature());
    }
}
