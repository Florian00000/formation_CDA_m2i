package org.example.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Produit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String marque;
    private String reference;
    @Temporal(TemporalType.DATE)
    private Date dateAchat;
    private double prix;
    private int stock;

    @OneToMany(mappedBy = "produit")
    private List<Image> images;

    @OneToMany(mappedBy = "produit")
    private List<Commentaire> commentaires;

    @Override
    public String toString() {
        return "Produit{" +
                "id=" + id +
                ", marque = '" + marque + '\'' +
                ", reference = '" + reference + '\'' +
                ", dateAchat = " + dateAchat +
                ", prix = " + prix +
                ", stock = " + stock +
                '}';
    }
}
