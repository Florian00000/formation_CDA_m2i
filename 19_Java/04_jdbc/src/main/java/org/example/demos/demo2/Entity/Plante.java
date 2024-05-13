package org.example.demos.demo2.Entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Plante {
    private int id;
    private String name;
    private int age;
    private String color;

    @Override
    public String toString() {
        return "Plante{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", color='" + color + '\'' +
                '}';
    }
}
