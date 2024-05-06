package org.example.exercice14flyweightLocation;

public class Vehicle {
    private int year;
    private String customer;
    private VehicleFlyWeight flyweight;

    public Vehicle(int year, String customer, VehicleFlyWeight flyweight) {
        this.year = year;
        this.customer = customer;
        this.flyweight = flyweight;
    }

    public void display(){
        this.flyweight.displayVehicleInfo(year, customer);
    }
}
