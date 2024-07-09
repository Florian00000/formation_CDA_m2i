package com.example.exercice_cinematheque_02.dto;

import com.example.exercice_cinematheque_02.entity.Movie;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DirectorDtoGet {

    private int id;
    private String firstName;
    private String lastName;
    private LocalDate birthDate;
    private String nationality;

    private List<MovieDtoGet> movies;
}
