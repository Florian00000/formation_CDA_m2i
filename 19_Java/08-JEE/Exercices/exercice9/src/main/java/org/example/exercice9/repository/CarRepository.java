package org.example.exercice9.repository;

import org.example.exercice9.entities.Car;
import org.hibernate.Session;

import java.util.List;

public class CarRepository extends Repository<Car>{

    public CarRepository(Session _session) {
        super(_session);
    }

    @Override
    public Car findById(int id) {
        return (Car) _session.get(Car.class, id);
    }

    @Override
    public List<Car> findAll() {
        return _session.createQuery("from Car", Car.class).list();
    }
}
