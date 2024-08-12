package com.example.correction_exercice_2.service;

import org.springframework.stereotype.Service;

@Service
public class NotificationService {

    public void sendMessage(int taskId, String status) {
        System.out.println("Task id "+ taskId + " status "+status);
    }
}
