package org.example.exercice09TpGlobalCourseVoitures.entity.impl;

import org.example.exercice09TpGlobalCourseVoitures.entity.Car;
import org.example.exercice09TpGlobalCourseVoitures.entity.Observer;

import java.util.ArrayList;
import java.util.Comparator;

public class Race extends Thread implements Observer<Car> {
    private ArrayList<Car> carList;
    private static Race INSTANCE;

    private Race() {
        carList = new ArrayList<>();
    }

    public static synchronized Race getInstance() {
        if(INSTANCE == null) INSTANCE = new Race();
        return INSTANCE;
    }

    public ArrayList<Car> getCarList() {
        return carList;
    }

    public void setCarList(ArrayList<Car> carList) {
        this.carList = carList;
    }

    public void addCar(Car car) {
        carList.add(car);
    }


    @Override
    public void run() {
        while (true) {
            System.out.println(" _____________ ");
            carList.forEach(Car::move);
            carList.sort(Comparator.comparing(Car::getDistance).reversed());
            carList.forEach(c -> c.setPosition(carList.indexOf(c)+1));



            try {
                sleep(3000);
                for ( Car car : carList ) {
                    if ( car.getDistance() > 50)
                    {
                        wait();
                    }
                }
            } catch (Exception e) {
                System.out.println("victoire de " + carList.get(0));
                break;
                //throw new RuntimeException(e);
            }

        }
    }

    @Override
    public void update(Car car) {
        System.out.println(car);
    }
}
