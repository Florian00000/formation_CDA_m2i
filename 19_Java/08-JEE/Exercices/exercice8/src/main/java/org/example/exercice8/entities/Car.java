package org.example.exercice8.entities;

public class Car {
    private int id;
    private String brend;
    private int year;
    private String model;
    private String color;

    public Car() {
    }

    public Car(int id, String brend, int year, String model, String color) {
        this.id = id;
        this.brend = brend;
        this.year = year;
        this.model = model;
        this.color = color;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBrend() {
        return brend;
    }

    public void setBrend(String brend) {
        this.brend = brend;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
