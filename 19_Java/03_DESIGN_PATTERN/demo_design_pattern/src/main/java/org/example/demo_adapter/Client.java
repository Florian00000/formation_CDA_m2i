package org.example.demo_adapter;

public class Client {
    public static void main(String[] args) {
        TemperatureSensor sensor = new TemperatureAdapter();
        System.out.println(sensor.getTemperature() + "°C");
    }
}
