package com.example.exercice_gestionrh_03.dto.absence;

import com.example.exercice_gestionrh_03.entity.Absence;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.time.LocalDate;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AbsenceDtoGet {

    private int id;

    private LocalDate absenceDate;
    private LocalDate startVacation;
    private LocalDate endVacation;

    public AbsenceDtoGet(Absence absence) {
        this.id = absence.getId();
        if (absence.getAbsenceDate() != null) {
            this.absenceDate = absence.getAbsenceDate();
        }
        if (absence.getStartVacation() != null) {
            this.startVacation = absence.getStartVacation();
        }
        if (absence.getEndVacation() != null) {
            this.endVacation = absence.getEndVacation();
        }
    }

}
