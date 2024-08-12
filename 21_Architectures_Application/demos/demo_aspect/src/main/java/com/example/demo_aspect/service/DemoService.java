package com.example.demo_aspect.service;


import com.example.demo_aspect.annotation.DemoAspectAnnotation;
import org.springframework.stereotype.Service;

@Service
public class DemoService {

    public void method() {

        // Logique métier de notre méthode
        System.out.println("Log application metier method dans demoService");
    }

    public void method2() {
        // Logique
    }

    public String methodWithResult() {
        return "result";
    }

    //@DemoAspectAnnotation
    public void methodWithTryCatch() {
//        try {
//            System.out.println("Logique métier");
//        }catch (Exception ex) {
//            System.out.println("Logique exception");
//        }
        System.out.println("Logique métier");
    }
}
