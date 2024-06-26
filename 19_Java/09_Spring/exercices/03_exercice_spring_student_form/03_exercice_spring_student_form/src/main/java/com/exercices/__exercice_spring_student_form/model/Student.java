package com.exercices.__exercice_spring_student_form.model;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {

    private UUID id;

    @NotNull(message = "Indiquez votre prénom!!")
    @NotBlank(message = "Indiquez votre prénom!!")
    private String firstname;

    @NotNull(message = "Indiquez votre nom!!")
    @NotBlank(message = "Indiquez votre nom!!")
    private String lastname;

    @NotNull(message = "Indiquez votre email!!")
    @NotBlank(message = "Indiquez votre email!!")
    @Pattern(regexp = "^[\\w-.+]+@([\\w-]+\\.)+[\\w-]{2,4}$", message = "un vrai mail stp")
    private String email;

    @Min(value = 18, message = "Tu fais quoi là?")
    @Max(value = 125, message = "Abuse pas!")
    private int age;
}
