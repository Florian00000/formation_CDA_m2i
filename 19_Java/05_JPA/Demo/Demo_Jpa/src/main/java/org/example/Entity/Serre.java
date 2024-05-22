package org.example.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.bytebuddy.dynamic.loading.InjectionClassLoader;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Serre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="serre_id")
    private int id;

    private int surface;

    @ManyToMany
    @JoinTable(name = "serre_plante",joinColumns = @JoinColumn(name = "serre_id")
    ,inverseJoinColumns = @JoinColumn(name = "id"))
    private List<Plante> plantes;

    public void add (Plante plante){
        plantes.add(plante);
    }

}
