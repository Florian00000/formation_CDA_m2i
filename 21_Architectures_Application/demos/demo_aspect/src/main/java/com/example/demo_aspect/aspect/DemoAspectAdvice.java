package com.example.demo_aspect.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class DemoAspectAdvice {

    // La totalité des méthodes de chaque objet créé à partir d'une classe à l'interieur du package service
    @Before("execution(* com.example.demo_aspect.service.*.*(..))")
    public void addBeforeEachServicesMethods() {
        System.out.println("Run before each method's services");
    }
}
