package com.example.__exercice_spring.model;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Todo {
    private String name;
    private String description;
    private boolean isDone;
}
