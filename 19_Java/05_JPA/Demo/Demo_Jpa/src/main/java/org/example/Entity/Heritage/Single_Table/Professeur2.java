package org.example.Entity.Heritage.Single_Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.SuperBuilder;

import javax.persistence.Entity;

@Entity
@Data
@AllArgsConstructor
@SuperBuilder
public class Professeur2 extends Personne2 {
    private String matiere;

    public Professeur2() {
        super();
    }
}
