package org.example.layout;

import lombok.Data;

import javax.swing.*;
import java.awt.*;

@Data
public class BoxLayoutDemo {
    private JPanel jPanel;

    private JPanel messagePanel;

    public BoxLayoutDemo (){
        jPanel = new JPanel();
        jPanel.setLayout(new BoxLayout(jPanel,BoxLayout.Y_AXIS));

        messagePanel = new JPanel();
        messagePanel.setLayout(new BoxLayout(messagePanel,BoxLayout.Y_AXIS));

        JButton addButton = new JButton("Ajouter un message");
        addButton.setBackground(Color.green);
        addButton.addActionListener(e -> addMessage("nouveau message ajouté"));

        JButton removeLastMessageButton = new JButton("Supprimer le dernier message");
        removeLastMessageButton.setBackground(Color.red);
        removeLastMessageButton.addActionListener(e -> removeLastMessage());

        JButton removeallMessageButton = new JButton("Supprimer tout les messages");
        removeallMessageButton.setBackground(Color.BLACK);
        removeallMessageButton.setForeground(Color.WHITE);
        removeallMessageButton.addActionListener(e -> removeAll());

        jPanel.add(addButton);
        jPanel.add(removeLastMessageButton);
        jPanel.add(removeallMessageButton);
        jPanel.add(Box.createVerticalStrut(20));
        jPanel.add(new JScrollPane(messagePanel));

    }

    private void addMessage (String message){
        messagePanel.add(new JLabel(message));
        updateUI();
    }

    private void removeLastMessage (){
        int componentCount = messagePanel.getComponentCount();
        if(componentCount>0){
            messagePanel.remove(componentCount-1);
        }
        updateUI();
    }

    private void removeAll(){
        messagePanel.removeAll();
        updateUI();
    }

    private void updateUI(){
        messagePanel.revalidate();
        messagePanel.repaint();
    }

}
