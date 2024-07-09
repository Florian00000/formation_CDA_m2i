package com.example.exercice_gestionrh_03.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Entity
@SuperBuilder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee extends Person {

    private LocalDate contractStart;
    private LocalDate contractEnd;
    private String occupation;
    private String password;
    private boolean admin;
    private double salary;

    @OneToMany(mappedBy = "employeeId")
    private List<Absence> absences;
}
