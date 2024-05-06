package org.example.exercice11ProxyJournalisation;

public class RealDocument implements Document{
    private String title;
    private String content;

    public RealDocument(String title, String content) {
        this.title = title;
        this.content = content;
    }

    @Override
    public void readDocument() {
        System.out.println(content);
    }

    @Override
    public void writeDocument(String content) {
        this.content = content;
        System.out.println("Changements effectués avec succès");
    }

    public String getTitle() {
        return title;
    }
}
