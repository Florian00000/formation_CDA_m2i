package org.example.exerciceDesignPatternPlateform.Entity;

import lombok.Builder;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

import java.util.List;

@SuperBuilder
@Getter
public class Video extends Lesson{

    private String format;

}
