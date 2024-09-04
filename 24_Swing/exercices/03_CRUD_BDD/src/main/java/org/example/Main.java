package org.example;

import org.example.layout.MainFrame;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {

        JFrame frame = new JFrame("Crud BDD Swing");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1200, 800);
        frame.setLocationRelativeTo(null);

        frame.add(new MainFrame().getMainFrame());


        frame.setVisible(true);
    }
}