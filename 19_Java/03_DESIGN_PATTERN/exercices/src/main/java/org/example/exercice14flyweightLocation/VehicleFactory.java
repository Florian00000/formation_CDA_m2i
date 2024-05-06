package org.example.exercice14flyweightLocation;

import java.util.HashMap;
import java.util.Map;

public class VehicleFactory {
    private Map<String, SharedVehicleState> flyweight = new HashMap<>();

    public SharedVehicleState getFlyweight(String model, String brand, String color) {
        String key = model + "_" + brand + "_" + color;
        if (!flyweight.containsKey(key)) {
            flyweight.put(key, new SharedVehicleState(model, brand, color));
        }
        return flyweight.get(key);
    }
}
