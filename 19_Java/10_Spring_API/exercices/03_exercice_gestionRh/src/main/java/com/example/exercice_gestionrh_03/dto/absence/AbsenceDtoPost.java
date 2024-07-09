package com.example.exercice_gestionrh_03.dto.absence;

import com.example.exercice_gestionrh_03.entity.Absence;
import com.example.exercice_gestionrh_03.exception.AbsenceException;
import lombok.Data;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Data
public class AbsenceDtoPost {

    private String absenceDate;
    private String startVacation;
    private String endVacation;

    public Absence toAbsence() {
        if (absenceDate != null ) {
            return Absence.builder().absenceDate(LocalDate.parse(absenceDate, DateTimeFormatter.ofPattern("dd/MM/yyyy") )).build();
        } else if ( startVacation != null && endVacation != null) {
            return Absence.builder()
                    .startVacation(LocalDate.parse(startVacation, DateTimeFormatter.ofPattern("dd/MM/yyyy")))
                    .endVacation(LocalDate.parse(endVacation, DateTimeFormatter.ofPattern("dd/MM/yyyy")))
                    .build();
        }else throw new AbsenceException();
    }

}
