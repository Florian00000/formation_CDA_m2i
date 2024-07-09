package com.example.exercice_gestionrh_03.dto.employee;

import com.example.exercice_gestionrh_03.entity.Absence;
import com.example.exercice_gestionrh_03.entity.Employee;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class EmployeeDtoGet {
    
    private int id;
    private String firstname;
    private String lastname;
    private String identificationNumber;
    private String address;
    private String email;
    private String phoneNumber;
    private LocalDate birthDate;
    private LocalDate contractStart;
    private LocalDate contractEnd;
    private String occupation;

    private boolean admin;
    private double salary;
    private String observation;
    private List<Absence> absences;

    public EmployeeDtoGet(Employee employee) {
        this.id = employee.getId();
        this.firstname = employee.getFirstname();
        this.identificationNumber = employee.getIdentificationNumber();
        this.lastname = employee.getLastname();
        this.address = employee.getAddress();
        this.email = employee.getEmail();
        this.phoneNumber = employee.getPhoneNumber();
        this.contractStart = employee.getContractStart();
        this.birthDate = employee.getBirthDate();
        this.contractEnd = employee.getContractEnd();
        this.occupation = employee.getOccupation();
        this.admin = employee.isAdmin();
        this.salary = employee.getSalary();
        this.observation = employee.getObservation();
        this.absences = employee.getAbsences();
    }
}
