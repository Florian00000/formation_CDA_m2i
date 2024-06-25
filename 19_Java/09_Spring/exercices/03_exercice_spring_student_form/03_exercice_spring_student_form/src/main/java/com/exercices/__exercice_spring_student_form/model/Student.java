package com.exercices.__exercice_spring_student_form.model;

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
    private String firstname;
    private String lastname;
    private String email;
    private int age;
}
