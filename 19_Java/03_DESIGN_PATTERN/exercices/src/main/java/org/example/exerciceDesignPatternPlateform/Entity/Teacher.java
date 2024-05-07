package org.example.exerciceDesignPatternPlateform.Entity;

import lombok.Builder;
import lombok.Getter;
import org.example.exerciceDesignPatternPlateform.Application;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Builder
@Getter
public class Teacher extends Person {

    private String subject;

    public void createVideo(String title , String format){
        Video video = Video.builder().title(title).teacher(this).format(format).build();
        publishLesson(video);
    }

    public void createDocument(String title, List chapters){
        Document document = Document.builder().title(title).teacher(this).chapters(chapters).build();
        publishLesson(document);
    }

    //TODO
    public void createQuiz(String title, HashMap questionsResponses){
        //Document document = Document.builder().title(title).teacher(this).
    }


    public void publishLesson(Lesson lesson){
        Application application = Application.getInstance();
        application.publishLesson(lesson);
    }
}
