package org.example.exercice11ProxyJournalisation;


import java.util.ArrayList;
import java.util.List;

public class ProxyDocument implements Document{
    private RealDocument document;
    private static List<String> activity = new ArrayList<>();

    public ProxyDocument(RealDocument document) {
        this.document = document;
    }

    @Override
    public void readDocument() {
        this.document.readDocument();
        activity.add("Lecture: " + this.document.getTitle());
    }

    @Override
    public void writeDocument(String content) {
        this.document.writeDocument(content);
        activity.add("Ecriture: " + this.document.getTitle() + ", contenu: " + content);
    }

    public static void getActivy() {
        activity.forEach(System.out::println);
    }
}
