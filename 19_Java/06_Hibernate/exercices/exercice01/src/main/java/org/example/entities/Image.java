package org.example.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String url;

    @ManyToOne
    @JoinColumn(name = "produit_id")
    private Produit produit;


    @Override
    public String toString() {
        return "Image{" +
                "id = " + id +
                ", url = '" + url + '\'' +
                '}';
    }
}
