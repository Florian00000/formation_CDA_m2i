package org.example.layout;

import lombok.Getter;
import org.example.entitie.User;
import org.example.service.UserService;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.List;

public class SelectUserLayout {

    @Getter
    private JDialog selectFrame;

    public void getSelectFrame(JPanel window, UserService userService) {


        String[] columnNames = {"id", "Nom", "Téléphone"};

        DefaultTableModel tableModel = new DefaultTableModel(columnNames,0);
        List<User> users = userService.findAll();

        JTable table = new JTable(tableModel);
        for (User user : users) {
            tableModel.addRow(new Object[]{user.getId(), user.getName(), user.getNumber()});
        }

        JOptionPane.showMessageDialog(window, new JScrollPane(table));

    }
}
