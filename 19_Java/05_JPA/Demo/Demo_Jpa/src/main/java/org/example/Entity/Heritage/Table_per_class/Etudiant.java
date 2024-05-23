package org.example.Entity.Heritage.Table_per_class;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.persistence.Entity;

@Entity
@Data
@AllArgsConstructor
@Builder
public class Etudiant extends Personne {

    private String classe;
    public Etudiant() {
        super();
    }

}
