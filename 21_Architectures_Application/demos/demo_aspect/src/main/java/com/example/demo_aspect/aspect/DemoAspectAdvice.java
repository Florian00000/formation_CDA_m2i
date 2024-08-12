package com.example.demo_aspect.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class DemoAspectAdvice {

    // La totalité des méthodes de chaque objet créé à partir d'une classe à l'interieur du package service
//    @Before("execution(* com.example.demo_aspect.service.*.*(..))")
//    public void addBeforeEachServicesMethods() {
//        System.out.println("Run before each method's services");
//    }
//
//    @After("execution(* com.example.demo_aspect.service.*.*(..))")
//    public void addAfterEachServicesMethods() {
//        System.out.println("Run After each method's services");
//    }
//
//    @AfterReturning(value = "execution(* com.example.demo_aspect.service.DemoService.methodWithResult(..))", returning = "result")
//    public void addAfterReturningEachServicesMethods(Object result) {
//        System.out.println("Run After Returning each method's services "+result);
//    }
//
//    @AfterThrowing("execution(* com.example.demo_aspect.service.*.*(..))")
//    public void addAfterThrowingServicesMethods() {
//        System.out.println("Run After Throwing each method's services");
//    }

    @Pointcut("@annotation(com.example.demo_aspect.annotation.DemoAspectAnnotation)")
    public void customPointCut() {

    }

    //@Around("execution(* com.example.demo_aspect.service.*.*(..))")
    @Around("customPointCut()")
    public Object around(ProceedingJoinPoint proceedingJoinPoint) {
        try {
            System.out.println("Around cut");
            //Récuéper les arguments
            Object[] args = proceedingJoinPoint.getArgs();
            System.out.println(args);
            //Démarrer la méthode avec proceed
            Object result = proceedingJoinPoint.proceed();
            return result;
        }catch (Exception ex) {
            System.out.println("Catch exception with around cut");
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }finally {
            return null;
        }

    }
}
