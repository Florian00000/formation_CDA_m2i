package org.example.exercice01;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
       Chaise chaise1 = new Chaise();
       Chaise chaise2 = new Chaise(3, "métal", "gris");

        System.out.println(chaise1);
        System.out.println(chaise2);
    }
}