package org.example.layout;

import lombok.Data;


import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;


@Data
public class MainLayout {

    private JPanel panel;
    private JPanel form;
    private JPanel table;
    //private String[][] datas;
    private JTable tableUsers;
    private JDialog modal;


    public MainLayout() {
        panel = new JPanel();
        //datas = new String[][] {{"Pierre", "pierre@gmail.com", "Homme"}};
        panel.setLayout(new BorderLayout());
        panel.add(getPanelForm(), BorderLayout.NORTH);
        panel.add(getPanelTable(), BorderLayout.CENTER);
    }

    public JPanel getPanelForm() {
        form = new JPanel();
        form.setLayout(new BoxLayout(form, BoxLayout.Y_AXIS));
        form.setBorder(BorderFactory.createTitledBorder("Formulaire d'ajout"));


        JPanel nameLabel = new JPanel();
        nameLabel.add(new JLabel("Nom:"));
        JTextField nameField = new JTextField(20);
        nameLabel.add(nameField);

        JPanel emailLabel = new JPanel();
        emailLabel.add(new JLabel("Email:"));
        JTextField emailField = new JTextField(20);
        emailLabel.add(emailField);

        JPanel genderLabel = new JPanel();
        genderLabel.add(new JLabel("Genre:"));

        ButtonGroup group = new ButtonGroup();
        JRadioButton radioButtonH = new JRadioButton("Homme");
        JRadioButton radioButtonF = new JRadioButton("Femme");
        group.add(radioButtonH);
        group.add(radioButtonF);
        genderLabel.add(radioButtonH);
        genderLabel.add(radioButtonF);

        JPanel buttonLabel = new JPanel();
        JButton addButton = new JButton("Ajouter");
        addButton.addActionListener(e -> {
            addUser(nameField.getText(), emailField.getText(), radioButtonH, radioButtonF);
            nameField.setText("");
            emailField.setText("");
        });
        buttonLabel.add(addButton);



        form.add(nameLabel);
        form.add(emailLabel);
        form.add(genderLabel);
        form.add(buttonLabel);
        return form;
    }

    public JPanel getPanelTable() {
        table = new JPanel();
        table.setLayout(new BoxLayout(table, BoxLayout.Y_AXIS));
        table.setBorder(BorderFactory.createTitledBorder("Tableau des données"));

        String[] columnNames = { "Nom", "Email", "Genre" };
        DefaultTableModel model = new DefaultTableModel(columnNames,0);
        tableUsers = new JTable(model);
        //tableUsers.setModel(new DefaultTableModel(datas, columnNames));

        //table.add(tableUsers);
        table.add(new JScrollPane(tableUsers));
        JButton detailsButton = new JButton("Détails");
        detailsButton.addActionListener(e -> showDetails());
        table.add(detailsButton);
        return table;
    }

    private void addUser(String name, String email, JRadioButton genreH, JRadioButton genreF) {
        if (genreH.isSelected()) {
            DefaultTableModel model = (DefaultTableModel) tableUsers.getModel();
            String[] rowData = new String[] {name, email, "Homme" };
            model.addRow(rowData);
            updateTable();
        }
        if (genreF.isSelected()) {
            DefaultTableModel model = (DefaultTableModel) tableUsers.getModel();
            model.addRow(new String[] {name, email, "Femme" });
            updateTable();
        }
    }

    private void updateTable(){
        table.revalidate();
        table.repaint();
    }

    private void getModalDetail(String name, String email, String genre) {
        modal = new JDialog();
        modal.setModal(true);
        modal.setTitle("Details");

        JPanel modalPanel = new JPanel();
        modalPanel.setLayout(new BoxLayout(modalPanel, BoxLayout.Y_AXIS));

        JPanel panelName = new JPanel(new FlowLayout(FlowLayout.LEFT, 20 , 5));
        panelName.add(new JLabel("Nom:"));
        panelName.add(new JLabel(name));
        modalPanel.add(panelName);

        JPanel panelEmail = new JPanel(new FlowLayout(FlowLayout.LEFT, 20 , 5));
        panelEmail.add(new JLabel("Email:"));
        panelEmail.add(new JLabel(email));
        modalPanel.add(panelEmail);

        JPanel panelGenre = new JPanel(new FlowLayout(FlowLayout.LEFT, 20 , 5));
        panelGenre.add(new JLabel("Genre:"));
        panelGenre.add(new JLabel(genre));
        modalPanel.add(panelGenre);

        modal.add(modalPanel);


        modal.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
        //modal.setSize(300, 200);
        modal.setLocationRelativeTo(panel);
        modal.pack();
        modal.setVisible(true);
    }

    private void showDetails(){

        DefaultTableModel model = (DefaultTableModel) tableUsers.getModel();
        String name = (String) model.getValueAt(tableUsers.getSelectedRow(), 0);
        String email = (String) model.getValueAt(tableUsers.getSelectedRow(), 1);
        String genre = (String) model.getValueAt(tableUsers.getSelectedRow(), 2);
        getModalDetail(name, email, genre);
    }
}
