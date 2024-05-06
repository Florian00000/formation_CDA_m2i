package org.example.exercice14flyweightLocation;

public class Main {
    public static void main(String[] args) {
        VehicleFactory factory = new VehicleFactory();
        Vehicle car = new Vehicle( 2014, "Georges" ,
                factory.getFlyweight("modus", "renault", "bleu"));
        car.display();
    }
}
