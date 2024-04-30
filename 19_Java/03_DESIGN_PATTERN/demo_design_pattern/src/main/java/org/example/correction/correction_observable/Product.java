package org.example.correction.correction_observable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Builder
@Getter

public class Product implements Subject<Integer> {

    private int stockLevel;

    private String name;

    List<Observer<Integer>> observers;



    public void decreaseStock() {
        this.stockLevel--;
        notifyObservers(this.stockLevel);
    }

    @Override
    public void registerObserver(Observer<Integer> observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer<Integer> observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(Integer element) {
        observers.forEach(o->o.update(element));
    }
}
