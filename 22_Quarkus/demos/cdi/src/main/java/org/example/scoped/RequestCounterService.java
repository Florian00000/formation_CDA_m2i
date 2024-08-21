package org.example.scoped;

import jakarta.enterprise.context.RequestScoped;

@RequestScoped
public class RequestCounterService {

    private int requestCounter = 0;

    public void increment(){
        requestCounter++;
    }

    public int getCount(){
        return requestCounter;
    }


}
