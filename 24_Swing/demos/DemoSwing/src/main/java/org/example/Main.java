package org.example;

import org.example.layout.*;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        JFrame jFrame = new JFrame("demo layout");
        jFrame.setSize(1200,500);
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jFrame.setLocationRelativeTo(null);
//        jFrame.add(new BorderLayoutDemo());
//        jFrame.add(new FlowLayoutDemo().getJPanel());
//        jFrame.add(new GridLayoutDemo().getJPanel());
//        jFrame.add(new BoxLayoutDemo().getJPanel());
            jFrame.add(new GridBagLayoutDemo().getJPanel());
        jFrame.setVisible(true);
    }
}