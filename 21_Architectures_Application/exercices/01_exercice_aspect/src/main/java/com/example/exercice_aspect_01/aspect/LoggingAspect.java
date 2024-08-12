package com.example.exercice_aspect_01.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@Aspect
public class LoggingAspect {

    @Pointcut("@annotation(com.example.exercice_aspect_01.annotation.Log)")
    public void log(){

    }

//    @After("execution(* com.example.exercice_aspect_01.service.*.*(..))")
    @After("log()")
    public void LoggingBookMethods(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        System.out.println("Nom de la méthode: "+ joinPoint.getSignature().getName());
        System.out.println("Arguments méthodes: "+ Arrays.toString(args));
    }

//    @AfterReturning(value = "execution(* com.example.exercice_aspect_01.service.*.*(..))", returning = "result")
    @AfterReturning(value = "log()", returning = "result")
    public void LoggingBookMethodsReturns(Object result) {
        System.out.println("Résultat méthode : " + result);
    }


}
