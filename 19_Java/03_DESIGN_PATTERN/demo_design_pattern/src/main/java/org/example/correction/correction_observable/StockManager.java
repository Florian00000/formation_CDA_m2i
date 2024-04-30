package org.example.correction.correction_observable;

public class StockManager implements Observer<Integer> {
    @Override
    public void update(Integer element) {
        System.out.println("The stock manager got the new stock level "+ element);
    }
}
