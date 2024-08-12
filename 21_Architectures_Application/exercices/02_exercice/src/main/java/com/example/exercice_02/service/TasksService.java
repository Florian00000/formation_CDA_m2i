package com.example.exercice_02.service;

import com.example.exercice_02.annotation.Notification;
import com.example.exercice_02.model.Task;
import com.example.exercice_02.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TasksService {

    private List<User> userList = new ArrayList<>(List.of(
            new User("user 1"),
            new User("user 2 "),
            new User("user 3")
    ));

    private List<Task> taskList = new ArrayList<>(List.of(
            new Task("task 1", List.of(userList.get(0), userList.get(2))),
            new Task("task 2", List.of(userList.get(1)))
    ));

    @Notification
    public Task updateTask(int id) {
        taskList.get(id).setCompleted(true);
        return taskList.get(id);
    }
}
