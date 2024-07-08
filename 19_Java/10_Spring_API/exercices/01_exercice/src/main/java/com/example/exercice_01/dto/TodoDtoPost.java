package com.example.exercice_01.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TodoDtoPost {

    private String title;
    private String description;
    private String dueDate;
    private boolean isValidate;
}
