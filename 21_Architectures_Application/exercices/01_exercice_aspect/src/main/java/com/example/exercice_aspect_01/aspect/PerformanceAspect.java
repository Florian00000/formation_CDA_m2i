package com.example.exercice_aspect_01.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class PerformanceAspect {

    @Around("execution(* com.example.exercice_aspect_01.service.*.*(..))")
    public Object around(ProceedingJoinPoint proceedingJoinPoint)  {
        try {
            long startTime = System.currentTimeMillis();
            Object response = proceedingJoinPoint.proceed();
            long endTime = System.currentTimeMillis();
            long elapsedTime = endTime - startTime;
            System.out.println("Durée de l'exécution de la méthode " + elapsedTime);
            return response;
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }
}
