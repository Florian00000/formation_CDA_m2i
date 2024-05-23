package org.example.Entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OS {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "os_id")
    private int id;

    private String name;
    private String Version;

    @OneToMany(mappedBy = "os")
    private List<Computer> computers ;

    @Override
    public String toString() {
        return "OS{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", Version='" + Version + '\'' +
                ", computers=" + computers +
                '}';
    }
}
