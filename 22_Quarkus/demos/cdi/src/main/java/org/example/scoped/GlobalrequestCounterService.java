package org.example.scoped;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class GlobalrequestCounterService {

    private int globalCounter = 0;

    public void increment(){
        globalCounter++;
    }

    public int getCount(){
        return globalCounter;
    }

}
