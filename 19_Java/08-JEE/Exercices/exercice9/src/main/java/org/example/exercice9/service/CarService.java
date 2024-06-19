package org.example.exercice9.service;

import jakarta.enterprise.context.ApplicationScoped;
import org.example.exercice9.entities.Car;
import org.example.exercice9.repository.CarRepository;
import org.example.exercice9.util.HibernateSession;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

@ApplicationScoped
public class CarService {

    private CarRepository carRepository;
    private SessionFactory sessionFactory;
    private Session session;

    public CarService() {
        this.sessionFactory = HibernateSession.getSessionFactory();
    }

    public Car createCar(String brend, int year, String model, String color) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        carRepository = new CarRepository(session);
        Car car = new Car(brend, year, model, color);
        carRepository.create(car);
        session.getTransaction().commit();
        session.close();
        return car;
    }

    public Car getCar(int id) {
        session = sessionFactory.openSession();
        carRepository = new CarRepository(session);
        Car car = carRepository.findById(id);
        System.out.println("carService" + car);
        session.close();
        return car;
    }

    public List<Car> getAllCars() {
        session = sessionFactory.openSession();
        carRepository = new CarRepository(session);
        List<Car> carList = carRepository.findAll();
        session.close();
        return carList;
    }

    public boolean deleteCar(int id) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        carRepository = new CarRepository(session);
        Car car = carRepository.findById(id);
        carRepository.delete(car);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    public Car updateCar(int id, String brend, int year, String model, String color) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        carRepository = new CarRepository(session);
        Car carUpdated = carRepository.findById(id);
        carUpdated.setBrend(brend);
        carUpdated.setYear(year);
        carUpdated.setModel(model);
        carUpdated.setColor(color);
        carRepository.update(carUpdated);
        session.getTransaction().commit();
        session.close();
        return carUpdated;
    }
}
