package com.example.exercice_cinematheque_02.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DirectorDtoGet {

    private int id;
    private String firstName;
    private String lastName;
    private LocalDate birthDate;
    private String nationality;
}
