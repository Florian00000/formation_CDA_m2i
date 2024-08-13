package com.example.tp_hexagonal_03.domain.entity;

public class Event {

    private int id;
    private String name;
    private String type;
    private final int availablePlaces;
    private int reservedPlaces;

    public Event(int id, String name, String type, int availablePlaces, int reservedPlaces) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.availablePlaces = availablePlaces;
        this.reservedPlaces = reservedPlaces;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getAvailablePlaces() {
        return availablePlaces;
    }

    public int getReservedPlaces() {
        return reservedPlaces;
    }

    public void setReservedPlaces(int reservedPlaces) {
        this.reservedPlaces = reservedPlaces;
    }
}
