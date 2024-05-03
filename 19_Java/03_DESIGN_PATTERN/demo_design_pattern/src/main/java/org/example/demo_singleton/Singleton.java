package org.example.demo_singleton;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Singleton {

    private static Singleton instance;
    private static Lock lock = new ReentrantLock();


    private Singleton() {

    }

    /*public static Singleton getInstance() {
        lock.lock();
        if(instance == null)
            instance = new Singleton();
        lock.unlock();
        return instance;
    }*/

    public static synchronized Singleton getInstance() {
        if(instance == null)
            instance = new Singleton();
        return instance;
    }
}
