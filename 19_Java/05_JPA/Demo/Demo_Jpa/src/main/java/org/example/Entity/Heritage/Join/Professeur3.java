package org.example.Entity.Heritage.Join;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.SuperBuilder;

import javax.persistence.Entity;

@Entity
@Data
@AllArgsConstructor
@SuperBuilder
public class Professeur3 extends Personne3 {
    private String matiere;

    public Professeur3() {
        super();
    }
}
