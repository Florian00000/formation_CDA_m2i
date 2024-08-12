package com.example.correction_exercice_1.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@Aspect
public class LoggingAspect {

    @Pointcut("@annotation(com.example.correction_exercice_1.annotation.Log)")
    public void logPointCut() {

    }

//    @After("execution(* com.example.correction_exercice_1.service.BookService.*(..))")
//    public void logAfterBookService(JoinPoint joinPoint) {
//        String methodName = joinPoint.getSignature().getName();
//        Object[] args = joinPoint.getArgs();
//        System.out.println("Nom méthode "+ methodName);
//        System.out.println("Arguments : ");
//        Arrays.stream(args).toList().forEach(System.out::println);
//    }

    @Before("logPointCut()")
    public void logGetMethodsInformationsBookService(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();
        System.out.println("Nom méthode "+ methodName);
        System.out.println("Arguments : ");
        Arrays.stream(args).toList().forEach(System.out::println);
    }

    @AfterReturning(value = "logPointCut()", returning = "result")
    public void logAfterReturningResultBookService(JoinPoint joinPoint, Object result) {
        System.out.println("Retour de la méthode "+ result);
    }


    @AfterThrowing(value = "logPointCut()", throwing = "ex")
    public void logAfterReturningResultBookService(JoinPoint joinPoint, Exception ex) {
        System.out.println("Exception "+ ex);
    }
}
