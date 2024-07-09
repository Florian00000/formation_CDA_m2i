package com.example.exercice_gestionrh_03.dto.candidate;

import com.example.exercice_gestionrh_03.entity.Candidate;
import lombok.Data;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Data
public class CandidateDtoPost {

    private String firstname;
    private String lastname;
    private String identificationNumber;
    private String address;
    private String phoneNumber;
    private String email;
    private String birthDate;
    private String observation;
    private int rating;
    private String skill;
    private String technicalArea;
    private String jobInterviewDate;

   public Candidate toCandidate() {
       return Candidate.builder()
               .firstname(this.firstname)
               .lastname(this.lastname)
               .identificationNumber(this.identificationNumber)
               .address(this.address)
               .phoneNumber(this.phoneNumber)
               .email(this.email)
               .birthDate(LocalDate.parse(this.birthDate, DateTimeFormatter.ofPattern("dd/MM/yyyy")))
               .observation(this.observation)
               .rating(this.rating)
               .skill(this.skill)
               .technicalArea(this.technicalArea)
               .jobInterviewDate(LocalDate.parse(this.birthDate, DateTimeFormatter.ofPattern("dd/MM/yyyy")))
               .build();
   }
}
