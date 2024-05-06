package org.example.exercice11ProxyJournalisation;

public class Main {
    public static void main(String[] args) {
        ProxyDocument document1 = new ProxyDocument(new RealDocument("contenue test1"));
        ProxyDocument document2 = new ProxyDocument(new RealDocument("contenue test2"));

        document1.readDocument();
        document2.writeDocument("modif contenu");
        document2.readDocument();

        System.out.println(ProxyDocument.getNumberActivy());

    }
}
