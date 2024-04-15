package org.example.demos.demo04Interface;

import org.example.demos.demo04Interface.model.Calculable;
import org.example.demos.demo04Interface.model.Cercle;
import org.example.demos.demo04Interface.model.Forme;
import org.example.demos.demo04Interface.model.Rectangle;

public class Main {
    public static void main(String[] args) {
        Cercle cercle = new Cercle("Cercle 1",5.0);
        Rectangle rectangle = new Rectangle("Rectangle 1",4.0,6.0);

        System.out.println(cercle);
        System.out.println(rectangle);

        System.out.println(cercle.calculerAire());
        System.out.println(rectangle.calculerAire());

        // Utilisation du polymorphisme avec un tableau de formes :
        Forme[] formes = new Forme[]{cercle,rectangle};


        // Instanciation d'un interface impossible
       // Calculable calculable = new Calculable();

        // Création d'un tableau de formes Calculables
        Calculable[] formes2 = new Calculable[]{cercle,rectangle};
        Calculable forme3 = new Cercle("Cercle 2",5.0);

        System.out.println(forme3);


    }
}
