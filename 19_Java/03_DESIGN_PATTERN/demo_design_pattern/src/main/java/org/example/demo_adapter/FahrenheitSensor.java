package org.example.demo_adapter;

import java.util.Random;

public class FahrenheitSensor {
    private Random random = new Random();
    public double getTemperature() {
        return random.nextDouble(-100,100);
    }
}
