package org.example.correction.correction_observable;

public class Supplier implements Observer<Integer> {
    @Override
    public void update(Integer element) {
        System.out.println("The supplier got the new stock level "+ element);
    }
}
