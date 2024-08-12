package com.example.correction_exercice_2.aspect;

import com.example.correction_exercice_2.service.NotificationService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class NotificationAspect {

    private final NotificationService notificationService;

    public NotificationAspect(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @Pointcut("@annotation(com.example.correction_exercice_2.annotation.Notification)")
    public void notificationPointCut() {

    }

    @Before("notificationPointCut()")
    public void notificationAdvice(JoinPoint joinPoint) {
        int taskId = (int)joinPoint.getArgs()[0];
        String status = (String) joinPoint.getArgs()[1];
        notificationService.sendMessage(taskId, status);
    }

}
