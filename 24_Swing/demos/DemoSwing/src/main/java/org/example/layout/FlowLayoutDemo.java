package org.example.layout;

import lombok.Data;

import javax.swing.*;
import java.awt.*;

@Data
public class FlowLayoutDemo {

    private JPanel jPanel;
    private JLabel jLabel;
    private JComboBox<String> comboBox;

    public FlowLayoutDemo(){
        jPanel = new JPanel(new FlowLayout(FlowLayout.LEFT,5,30));

        JButton jButton = new JButton("button1");
        jButton.setBackground(Color.black);
        jButton.setForeground(Color.WHITE);
        jButton.addActionListener( e -> System.out.println(("button click")));
        jPanel.add(jButton);

        jPanel.add(new JButton("button2"));
        jPanel.add(new JButton("button3"));

        JTextField input = new JTextField(20);
        jPanel.add(input);

        comboBox = new JComboBox<>(new String[]{"option 1","option 2","option 3"});
        jPanel.add(comboBox);

        jLabel = new JLabel("Resultat et selection s'afficheront ici");
        jPanel.add(jLabel);

        JButton validateButton = new JButton("validate");

        validateButton.addActionListener(e ->{
            String selected = (String) comboBox.getSelectedItem();
            String inputText = input.getText();

            jLabel.setText("Input data : "+inputText+" Selected data : "+selected);
        });

        jPanel.add(validateButton);
    }
}
