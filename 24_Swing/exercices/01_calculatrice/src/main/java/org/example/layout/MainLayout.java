package org.example.layout;


import lombok.Data;

import javax.swing.*;
import java.awt.*;

@Data
public class MainLayout {

    private JPanel jPanel;
    private JLabel result;
    private float number2;
    private float number1;
    private String operator;

    public MainLayout() {
        jPanel = new JPanel();
        jPanel.setLayout(new GridBagLayout());
        number1 = 0;
        number2 = 0;
        operator = "";

        String[] numbersButton = { "C", "+/-", "%", "/",
                "7", "8", "9", "*",
                "4" , "5", "6", "-",
                "1", "2", "3", "+",
                "0", ",", "=",
        };


        //Resultat affiché
        result = new JLabel("0");
        result.setOpaque(true);
        result.setForeground(Color.WHITE);
        result.setBackground(Color.BLACK);
        result.setVerticalAlignment(SwingConstants.BOTTOM);
        result.setHorizontalAlignment(SwingConstants.SOUTH_EAST);
        result.setFont(new Font("Arial", Font.PLAIN, 100));
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.weightx = 2;
        constraints.weighty = 2;
        constraints.fill = GridBagConstraints.BOTH;
        constraints.gridwidth = 4;
        constraints.gridheight = 2;
        jPanel.add(result, constraints);



        //Boutons
        int count = 0;
        JButton button;
        for (int y = 0; y < 5; y++) {
            for (int x = 0; x < 4; x++) {
                constraints.gridx = x;
                constraints.gridy = y+2;
                constraints.weightx = 1.0;
                constraints.weighty = 1.0;
                constraints.gridwidth = 1;
                constraints.gridheight = 1;
                constraints.fill = GridBagConstraints.BOTH;

                if (count < numbersButton.length) {
                    button = new JButton(numbersButton[count++]);
                    button.setBackground(Color.LIGHT_GRAY);
                    button.setFont(new Font("Arial", Font.PLAIN, 25));
                    button.addActionListener(e -> actionButtonPressed((JButton) e.getSource()));
                    if (y == 0){
                        button.setBackground(Color.GRAY);
                    }
                    if (x == 3){
                        button.setBackground(Color.getHSBColor(255, 133, 16));
                    }

                    if (button.getText().equals("0")) {
                        constraints.gridwidth = 2;
                        x++;
                    }

                    jPanel.add(button, constraints);
                }

            }

        }

    }

    private void actionButtonPressed(JButton jButton) {
        switch (jButton.getText()) {
            case "C":
                result.setText("0");
                number1 = 0;
                number2 = 0;
                break;
            case "+":
                number1 = number1 + Float.parseFloat(result.getText());
                result.setText("0");
                operator = "+";
                break;
            case "=":
                switch (operator){
                    case "+":
                        float operated = number1 + Float.parseFloat(result.getText());
                        result.setText(String.valueOf(operated));
                        operator = "";
                        number1 = 0;
                    break;
                }

                break;
            default:
                if ( result.getText().equals("0")) {
                    result.setText(jButton.getText());
                } else result.setText(result.getText() + jButton.getText());
                break;
        }
        updateResult();
    }

    private void updateResult() {
        result.revalidate();
        result.repaint();
    }


}
