package org.example.layout;

import javax.swing.*;
import java.awt.*;

public class BorderLayoutDemo extends JPanel {

    public BorderLayoutDemo (){
        setLayout(new BorderLayout());
        JButton jButton = new JButton("NORTH");
        JButton jButton1 = new JButton("CENTER");
        JButton jButton2 = new JButton("SOUTH");
        JButton jButton3 = new JButton("WEST");
        JButton jButton4 = new JButton("EAST");

        jButton.setForeground(Color.black);
        jButton1.setForeground(Color.blue);
        jButton2.setForeground(Color.yellow);
        jButton3.setForeground(Color.magenta);
        jButton4.setForeground(Color.green);

        add(jButton,BorderLayout.NORTH);
        add(jButton1,BorderLayout.CENTER);
        add(jButton2,BorderLayout.SOUTH);
        add(jButton3,BorderLayout.WEST);
        add(jButton4,BorderLayout.EAST);

    }


}
