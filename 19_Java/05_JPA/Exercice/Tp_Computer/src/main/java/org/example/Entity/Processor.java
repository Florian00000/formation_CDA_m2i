package org.example.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Processor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int processorSpeed;

    @OneToMany(mappedBy = "processor")
    private List<Computer> computers;

    @Override
    public String toString() {
        return "Processor{" +
                "processorSpeed=" + processorSpeed +
                ", id=" + id +
                '}';
    }
}
