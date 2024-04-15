package org.example.demos.demos05Genrique;

import org.example.demos.demo01Base.Chat;
import org.example.demos.demos05Genrique.model.Boite;

public class Main {

    public static void main(String[] args) {
        /*
        Boite boite = new Boite("Bonjour");
        Boite boite1 = new Boite(45);
        Boite boite2 = new Boite(new Chat());

         */
        Boite<String> boite = new Boite<>("Bonjour");
        Boite<Integer> boite1 = new Boite<>(45);
        Boite<Chat> boite2 = new Boite<>(new Chat());


    }
}
