package org.example.exercice05;

public class Thermometre {

    private double temperatureKelvin;

    public Thermometre(double temperature, UniteTemperature uniteTemperature){
        switch (uniteTemperature){
            case KELVIN:
                temperatureKelvin = temperature;
                break;
            case CELSIUS:
                temperatureKelvin = temperature + 273.15;
                break;
            case FAHRENHEIT:
                temperatureKelvin = (temperature + 459.67 ) * 5/9;
                break;
        }

        this.temperatureKelvin = temperature;
    }

    public double getTemperatureKelvin(){
        return temperatureKelvin;
    }

    public void setTemperatureKelvin(double temperatureKelvin) {
        this.temperatureKelvin = temperatureKelvin;
    }

    public double getTemperatureCelsius(){
        return temperatureKelvin - 273.15;
    }

    public void setTemperatureCelsius(double temperatureCelsius) {
        this.temperatureKelvin = temperatureCelsius + 273.15;
    }

    public double getTemperatureFahrenheit(){
        return temperatureKelvin * 9/5  - 459.67;
    }

    public void setTemperatureFahrenheit(double temperatureFahrenheit){
        this.temperatureKelvin = (temperatureFahrenheit + 459.67 ) * 5/9;
    }
}
