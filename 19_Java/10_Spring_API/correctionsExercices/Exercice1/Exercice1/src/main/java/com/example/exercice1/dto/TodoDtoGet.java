package com.example.exercice1.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TodoDtoGet {
    private int id;
    private String title;
    private String description;
    private LocalDate date;
    private boolean isValidate;
}
