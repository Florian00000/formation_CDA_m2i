package com.example.exercice_gestionrh_03.dto.candidate;

import com.example.exercice_gestionrh_03.entity.Candidate;
import jakarta.persistence.Column;
import lombok.Data;

import java.time.LocalDate;

@Data
public class CandidateDtoGet {

    private int id;

    private String firstname;
    private String lastname;
    private String identificationNumber;
    private String address;
    private String phoneNumber;
    private String email;
    private LocalDate birthDate;
    private String observation;
    private int rating;
    private String skill;
    private String technicalArea;
    private LocalDate jobInterviewDate;

    public CandidateDtoGet(Candidate candidate) {
        this.firstname = candidate.getFirstname();
        this.lastname = candidate.getLastname();
        this.identificationNumber = candidate.getIdentificationNumber();
        this.address = candidate.getAddress();
        this.phoneNumber = candidate.getPhoneNumber();
        this.email = candidate.getEmail();
        this.birthDate = candidate.getBirthDate();
        this.observation = candidate.getObservation();
        this.rating = candidate.getRating();
        this.skill = candidate.getSkill();
        this.technicalArea = candidate.getTechnicalArea();
        this.jobInterviewDate = candidate.getJobInterviewDate();
    }
}
