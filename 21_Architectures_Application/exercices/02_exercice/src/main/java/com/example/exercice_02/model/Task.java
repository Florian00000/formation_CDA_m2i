package com.example.exercice_02.model;

import java.util.List;

public class Task {

    private String name;
    private boolean completed;
    private List<User> users;

    public Task(String name, List<User> users) {
        this.name = name;
        this.completed = false;
        this.users = users;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
