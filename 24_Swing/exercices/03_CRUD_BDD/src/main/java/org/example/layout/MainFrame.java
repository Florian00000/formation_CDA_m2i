package org.example.layout;

import lombok.Getter;
import org.example.service.UserService;

import javax.swing.*;
import java.awt.event.ActionListener;


public class MainFrame {

    @Getter
    private JPanel mainFrame;
    private UserService userService;

    public MainFrame() {
        userService = new UserService();
        mainFrame = new JPanel();
        JButton insertButton = new JButton("Insert");
        insertButton.addActionListener(e -> new InsertUserLayout().getInsertFrame(mainFrame, userService) );

        JButton UpdateButton = new JButton("Update");

        JButton deleteButton = new JButton("Delete");

        JButton selectButton = new JButton("Select");
        selectButton.addActionListener(e -> new SelectUserLayout().getSelectFrame(mainFrame, userService) );

        mainFrame.add(insertButton);
        mainFrame.add(UpdateButton);
        mainFrame.add(deleteButton);
        mainFrame.add(selectButton);
    }
}
