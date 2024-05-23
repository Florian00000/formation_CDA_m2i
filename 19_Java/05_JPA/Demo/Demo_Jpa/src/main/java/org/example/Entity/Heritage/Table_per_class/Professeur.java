package org.example.Entity.Heritage.Table_per_class;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.persistence.Entity;

@Entity
@Data
@Builder
@AllArgsConstructor
public class Professeur extends Personne{
    private String matiere;

    public Professeur() {
        super();
    }
}
