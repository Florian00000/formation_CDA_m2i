package org.example.Entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

//@Embeddable
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Identifiant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_identifiant")
    private int id;
    private String iMac;
    private String ip;

    @OneToOne(mappedBy = "identifiant", fetch = FetchType.LAZY)
    private Computer computer;

    @Override
    public String toString() {
        return "Identifiant{" +
                "id=" + id +
                ", iMac='" + iMac + '\'' +
                ", ip='" + ip + '\'' +
                '}';
    }
}
