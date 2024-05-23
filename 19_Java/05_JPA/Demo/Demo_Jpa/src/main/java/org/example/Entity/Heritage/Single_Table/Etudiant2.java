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
public class Etudiant2 extends Personne2 {

    private String classe;
    public Etudiant2() {
        super();
    }

}
