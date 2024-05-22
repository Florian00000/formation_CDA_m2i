package org.example.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Plante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private int age;
    private String color;
//    @OneToOne
//    @JoinColumn(name="id_pot")
//    private Pot pot;
    @Embedded
    private Pot pot;

    @ManyToOne
    @JoinColumn(name = "id_fleuriste")
    private Fleuriste fleuriste;

    @OneToMany
    @JoinColumn(name = "id")
    private List<Fleure> fleures;

    @ManyToMany(mappedBy = "plantes")
    private List<Serre> serres ;

    public void add (Fleure fleure){
        fleures.add(fleure);
    }

    @Override
    public String toString() {
        return "Plante{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", color='" + color + '\'' +
                ", pot=" + pot +
                ", fleures=" + fleures +
                '}';
    }


}
