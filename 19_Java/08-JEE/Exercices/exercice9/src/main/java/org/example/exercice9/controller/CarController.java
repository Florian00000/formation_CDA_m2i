package org.example.exercice9.controller;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.example.exercice9.entities.Car;
import org.example.exercice9.service.CarService;

import java.util.List;

@Path("/cars")
public class CarController {

    private final CarService carService;

    @Inject
    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Car> getAllCars() {
        List<Car> cars = carService.getAllCars();
        return cars;
    }

    @POST
    @Path("/add")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Car createCar(Car car) {
        return carService.createCar(car.getBrend(), car.getYear(), car.getModel(), car.getColor());
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Car getCarById(@PathParam("id") int id) {
        System.out.println(id);
        Car car = carService.getCar(id);
        return car;
    }

    @DELETE
    @Path("/delete/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public String deleteCar(@PathParam("id") int id) {
        boolean result = carService.deleteCar(id);
        if (result) {
            return "Voiture supprimée";
        }else {
            return "Erreur lors de la suppression";
        }
    }

    @PUT
    @Path("/update/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Car updateCar(@PathParam("id") int id, Car car) {
        Car carUpdated = carService.updateCar(id, car.getBrend(), car.getYear(), car.getModel(), car.getColor());
        return carUpdated;
    }

}
