package org.example;

import org.example.layout.MainLayout;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Formulaire Ajout");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 1200);
        frame.setLocationRelativeTo(null);

        frame.add(new MainLayout().getPanel());


        frame.setVisible(true);
    }
}