package org.example.exercice8;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.example.exercice8.entities.Car;

import java.util.ArrayList;
import java.util.List;

@Path("/cars")
public class CarRessource {

    @GET
    @Path("/single")
    @Produces(MediaType.APPLICATION_JSON)
    //@Produces("application/json")
    public Car getOneCar(){
        return new Car(1, "Renault", 2005, "Modus", "Bleu Céruléen");
    }

    @GET
    @Path("/getAll")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Car> getAllCars(){
        List<Car> cars = new ArrayList<Car>();
        cars.add(new Car(1, "Renault", 2005, "Modus", "Bleu Céruléen"));
        cars.add(new Car(2, "Renault", 1968, "R6", "Chartreuse"));
        return cars;
    }
}
