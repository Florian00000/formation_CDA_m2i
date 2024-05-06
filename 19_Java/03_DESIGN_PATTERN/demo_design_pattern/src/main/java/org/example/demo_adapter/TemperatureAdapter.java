package org.example.demo_adapter;

public class TemperatureAdapter implements TemperatureSensor {

    private FahrenheitSensor fahrenheitSensor;

    public TemperatureAdapter() {
        this.fahrenheitSensor = new FahrenheitSensor();
    }

    @Override
    public double getTemperature() {
        return (this.fahrenheitSensor.getTemperature() - 32) * 5.0 / 9.0;
    }
}
