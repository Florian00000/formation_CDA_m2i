package com.example.exercice_gestionrh_03.dto.employee;

import com.example.exercice_gestionrh_03.entity.Employee;
import lombok.Data;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Data
public class EmployeeDtoPost {

    private String firstname;
    private String lastname;
    private String identificationNumber;
    private String address;
    private String phoneNumber;
    private String email;
    private String birthDate;
    private String observation;
    private String contractStart;
    private String contractEnd;
    private String occupation;
    private String password;
    private boolean admin;
    private double salary;

    public Employee toEmployee() {
        return Employee.builder()
                .firstname(this.firstname)
                .lastname(this.lastname)
                .identificationNumber(this.identificationNumber)
                .address(this.address)
                .phoneNumber(this.phoneNumber)
                .email(this.email)
                .birthDate(LocalDate.parse(this.birthDate, DateTimeFormatter.ofPattern("dd/MM/yyyy")))
                .observation(this.observation)
                .contractStart(LocalDate.parse(this.contractStart, DateTimeFormatter.ofPattern("dd/MM/yyyy")))
                .contractEnd(LocalDate.parse(this.contractEnd, DateTimeFormatter.ofPattern("dd/MM/yyyy")))
                .occupation(this.occupation)
                .password(this.password)
                .admin(this.admin)
                .salary(this.salary)
                .build();
    }
}
