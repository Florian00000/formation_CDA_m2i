package com.exercices.__exercice_spring_recette.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Category {
    private UUID id;

    @NotNull(message = "Entrez un nom pour la catégorie")
    @NotBlank(message = "Entrez un nom pour la catégorie")
    private String name;

    private String description;
}
