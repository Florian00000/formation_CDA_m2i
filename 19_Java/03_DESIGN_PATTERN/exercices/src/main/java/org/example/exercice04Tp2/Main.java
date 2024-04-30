package org.example.exercice04Tp2;

import org.example.exercice04Tp2.Entity.CarteMere;
import org.example.exercice04Tp2.Factory.OrdinateurFactory;

public class Main {
    public static void main(String[] args) {
        OrdinateurFactory ordinateurFactory = new OrdinateurFactory();
        ordinateurFactory.avecCarteMere((CarteMere) new CarteMere.CarteMereBuilder().build());

        //TODO a tester
        //exemple
        //ComputerFactory computerFactory = new ComputerFactory();
        //        computerFactory.withRAM(RAM.builder().taille(10000).type("DDR4").build());
        //        computerFactory.withProcessor(new ProcessorBuilder().type("intel").nbCoeur(4).build());
        //        Computer computer = computerFactory.createComputer();
    }
}
