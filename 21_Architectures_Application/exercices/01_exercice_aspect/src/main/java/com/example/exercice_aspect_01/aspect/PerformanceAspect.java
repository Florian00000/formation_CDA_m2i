package com.example.exercice_aspect_01.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class PerformanceAspect {

    @Pointcut("@annotation(com.example.exercice_aspect_01.annotation.Performance)")
    public void performance(){

    }

//    @Around("execution(* com.example.exercice_aspect_01.service.*.*(..))")
@Around("performance()")
    public Object around(ProceedingJoinPoint proceedingJoinPoint)  {
        try {
            long startTime = System.nanoTime();
            Object response = proceedingJoinPoint.proceed();
            long endTime = System.nanoTime();
            long elapsedTime = endTime - startTime;
            System.out.println("Durée de l'exécution de la méthode " + elapsedTime + " ns");
            return response;
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }
}
