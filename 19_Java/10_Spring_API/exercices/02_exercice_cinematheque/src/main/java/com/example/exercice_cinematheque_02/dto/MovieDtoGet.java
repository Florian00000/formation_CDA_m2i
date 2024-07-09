package com.example.exercice_cinematheque_02.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MovieDtoGet {

    private int id;
    private String title;
    private LocalDate releaseDate;
    private String description;
    private int duration;
    private String genre;

    private String director;
}
