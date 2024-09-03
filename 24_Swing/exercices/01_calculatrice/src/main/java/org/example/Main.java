package org.example;

import org.example.layout.MainLayout;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        JFrame jFrame = new JFrame("Calculatrice");
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setSize(600, 1000);
        jFrame.setLocationRelativeTo(null);
        jFrame.add(new MainLayout().getJPanel());

        jFrame.setVisible(true);

    }
}