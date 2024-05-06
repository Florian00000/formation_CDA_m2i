package org.example.exercice14flyweightLocation;

public class SharedVehicleState implements VehicleFyWeight{
    private String model;
    private String brand;
    private String color;

    public SharedVehicleState(String model, String brand, String color) {
        this.model = model;
        this.brand = brand;
        this.color = color;
    }


    @Override
    public void displayVehicleInfo(int year, String customer) {
        System.out.println("client: " + customer);
        System.out.println("modèle: " + model);
        System.out.println("marque: " + brand);
        System.out.println("couleur: " + color);
        System.out.println("année: " + year);
    }
}
