package org.example.exercice11ProxyJournalisation;


import java.util.ArrayList;
import java.util.List;

public class ProxyDocument implements Document{
    private RealDocument document;
    private static int numberActivy = 0;

    public ProxyDocument(RealDocument document) {
        this.document = document;
    }

    @Override
    public void readDocument() {
        this.document.readDocument();
        numberActivy++;
    }

    @Override
    public void writeDocument(String content) {
        this.document.writeDocument(content);
        numberActivy++;
    }

    public static int getNumberActivy() {
        return numberActivy;
    }
}
