package com.example.exercice_gestionrh_03.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public abstract class Person {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    protected int id;

    protected String firstname;
    protected String lastname;
    protected String identificationNumber;
    protected String address;
    protected String phoneNumber;
    protected String email;
    protected LocalDate birthDate;

    @Column(columnDefinition = "text")
    protected String observation;
}
