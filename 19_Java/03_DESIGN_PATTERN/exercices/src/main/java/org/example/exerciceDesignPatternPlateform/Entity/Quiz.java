package org.example.exerciceDesignPatternPlateform.Entity;

import lombok.Builder;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

import java.util.Map;

@SuperBuilder
@Getter
public class Quiz extends Lesson{
    private Map<String, String> questionsResponses;

}
