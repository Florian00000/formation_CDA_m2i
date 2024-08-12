package com.example.exercice_02.aspect;

import com.example.exercice_02.model.Task;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class NotificationAspect {

    @Pointcut("@annotation(com.example.exercice_02.annotation.Notification)")
    public void notificationUser() {}

    @AfterReturning(value = "notificationUser()", returning = "result")
    public void afterReturning( Object result) {
        Task task =  (Task) result;
        System.out.println("task: " + task.getName());
        task.getUsers().forEach(user -> {
            System.out.println("Notification de l'user: "+ user.getUsername());
        });
    }
}
