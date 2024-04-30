package org.example.demo_observable;

public class Tablette implements Observer {
    @Override
    public void update(Weather weather) {
        System.out.println("La tablette s'actualise avec la méteo "+weather.getTemperature());
    }
}
