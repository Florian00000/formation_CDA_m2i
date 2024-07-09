package com.example.exercice_gestionrh_03.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Absence {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private LocalDate absenceDate;
    private LocalDate startVacation;
    private LocalDate endVacation;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    @JsonIgnore
    private Employee employeeId;
}
