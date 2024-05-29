package org.example.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Commentaire {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String contenu;
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
    private int note;

    @ManyToOne
    @JoinColumn(name = "produit_id")
    private Produit produit;

    @Override
    public String toString() {
        return "Commentaire{" +
                "note = " + note +
                ", date = " + date +
                ", contenu = '" + contenu + '\'' +
                ", id = " + id +
                '}';
    }
}
