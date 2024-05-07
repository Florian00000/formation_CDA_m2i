package org.example.exerciceDesignPatternPlateform.Entity;

import lombok.Builder;
import lombok.experimental.SuperBuilder;

@SuperBuilder
public abstract class Lesson {
    protected String title;
    protected Teacher teacher;



}
