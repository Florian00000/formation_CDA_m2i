package org.example.exercices.exercice01Chaise;

public class Main {
    public static void main(String[] args) {
        Chaise chaise1 = new Chaise(4, "grise", 15.0f, "chêne");
        Chaise chaise2 = new Chaise(3, "noir", 15.0f, "bambou");
        Chaise chaise3 = new Chaise(1, "marron", 15.0f, "métal");
        System.out.println(chaise1);
        System.out.println(chaise2);
        System.out.println(chaise3);
    }
}
