package org.example.Entity.Heritage.Join;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.SuperBuilder;
import net.bytebuddy.implementation.bind.annotation.Super;

import javax.persistence.Entity;

@Entity
@Data
@AllArgsConstructor
@SuperBuilder
public class Etudiant3 extends Personne3 {

    private String classe;
    public Etudiant3() {
        super();
    }

}
