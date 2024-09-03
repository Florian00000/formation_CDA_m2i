package org.example.layout;

import lombok.Data;

import javax.swing.*;
import java.awt.*;

@Data
public class GridBagLayoutDemo {

    private JPanel jPanel;

    public GridBagLayoutDemo (){
        jPanel = new JPanel();
        jPanel.setLayout(new GridBagLayout());

        for (int i = 0; i<3;i++){
            for (int j = 0; j<3;j++){
                JButton button = new JButton("i :"+i+" j :"+j);
                GridBagConstraints constraints = new GridBagConstraints();
                constraints.gridy = j;
                constraints.gridx = i;
                constraints.weightx = 1;
                constraints.weighty = 1;
                constraints.fill = GridBagConstraints.BOTH;
                if(i == 0 && j == 0){
                    constraints.gridwidth = 2;
                }
                if(i == 1 && j == 1){
                    constraints.gridwidth = 2;
                }

                jPanel.add(button,constraints);
            }
        }
    }

}
