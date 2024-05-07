package org.example.exerciceDesignPatternPlateform.Entity;

import lombok.Builder;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

import java.util.List;

@SuperBuilder
@Getter
public class Document extends Lesson {

    private List<String> chapters;

}
