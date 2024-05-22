package org.example.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Computer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    private String name;
    private float price;

//    @Embedded
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_identifiant")
    private Identifiant identifiant;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_processor")
    private Processor processor;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_exploitationSystem")
    private ExploitationSystem exploitationSystem;

}
