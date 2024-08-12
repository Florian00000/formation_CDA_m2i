package com.example.correction_exercice_2.service;

import com.example.correction_exercice_2.annotation.Notification;
import org.springframework.stereotype.Service;

@Service
public class TaskService {

    @Notification
    public void updateTask(int taskId, String status) {
        //Logique de mise à jour de la task
    }
}
