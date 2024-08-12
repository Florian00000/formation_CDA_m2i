package com.example.correction_exercice_1.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class PerformanceAspect {

    @Pointcut("@annotation(com.example.correction_exercice_1.annotation.Performance)")
    public void performancePointCut() {

    }
    //@Around("execution(* com.example.correction_exercice_1.service.BookService.*(..))")
    @Around("performancePointCut()")
    public Object performanceAspect(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();
        Object result = joinPoint.proceed();
        long endTime = System.currentTimeMillis();
        System.out.println("Temps d'execution : "+(endTime - startTime) + " ms");
        return result;
    }
}
