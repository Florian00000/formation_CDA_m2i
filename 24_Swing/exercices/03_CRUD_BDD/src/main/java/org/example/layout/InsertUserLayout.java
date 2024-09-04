package org.example.layout;

import lombok.Getter;
import org.example.entitie.User;
import org.example.service.UserService;

import javax.swing.*;

public class InsertUserLayout {

    @Getter
    private JDialog insertFrame;
    private UserService userService;

    public void getInsertFrame( JPanel window, UserService userService ) {

        this.userService = userService;

        JPanel panelForm = new JPanel();
        panelForm.setLayout(new BoxLayout(panelForm, BoxLayout.Y_AXIS));

        JPanel panelName = new JPanel();
        panelName.add(new JLabel("Name"));
        JTextField nameField = new JTextField(15);
        panelName.add(nameField);
        panelForm.add(panelName);

        JPanel panelNumber = new JPanel();
        panelNumber.add(new JLabel("Number"));
        JTextField numberField = new JTextField(15);
        panelNumber.add(numberField);
        panelForm.add(panelNumber);

        JButton btnInsert = new JButton("OK");
        btnInsert.addActionListener(e -> insertUser(User.builder().name(nameField.getText()).number(numberField.getText()).build()));
        panelForm.add(btnInsert);

        insertFrame = new JDialog();
        insertFrame.setTitle("Insert Contact Details");
        insertFrame.add(panelForm);
        insertFrame.setModal(true);
        insertFrame.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        insertFrame.setLocationRelativeTo(window);
        insertFrame.pack();
        insertFrame.setVisible(true);

    }

    private void insertUser(User user){
        userService.create(user);
        insertFrame.dispose();
    }
}
