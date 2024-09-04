package org.example.layout;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Formulaire {
    private JFrame mainFrame;
    private JTable table;
    private JPanel mainPanel;
    private JPanel contentPanel;

    public Formulaire (){
        createAndShowUI();
    }

    private void createAndShowUI(){
        mainFrame = new JFrame("Formulaire");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setBounds(500,100,500,500);

        mainPanel = new JPanel(new BorderLayout());

        JSeparator separator = new JSeparator(JSeparator.HORIZONTAL);
        mainPanel.add(createFormPanel(),BorderLayout.NORTH);
        mainPanel.add(separator,BorderLayout.CENTER);
        mainPanel.add(createTablePanel(),BorderLayout.SOUTH);

        mainFrame.add(mainPanel);
        mainFrame.pack();
        mainFrame.setVisible(true);
    }

    private JPanel createFormPanel (){
        JPanel formPanel = new JPanel(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets = new Insets(5,5,5,5);

        JLabel nameLabel = new JLabel("Nom :");
        JTextField nameTextField = new JTextField(20);

        JLabel emailLabel = new JLabel("Email :");
        JTextField emailTextField = new JTextField(30);

        JRadioButton maleRadioButton = new JRadioButton("Homme");
        JRadioButton femaleRadioButton = new JRadioButton("Femme");
        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(maleRadioButton);
        genderGroup.add(femaleRadioButton);

        JButton addButton = new JButton("Ajouter");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameTextField.getText();
                String email = emailTextField.getText();
                String gender = maleRadioButton.isSelected() ? "Homme" : "Femme";

                addToTable(name,email,gender);

                nameTextField.setText("");
                emailTextField.setText("");
                genderGroup.clearSelection();
            }
        });

        constraints.gridx = 0;
        constraints.gridy = 0;
        formPanel.add(nameLabel,constraints);

        constraints.gridx = 1;
        formPanel.add(nameTextField,constraints);

        constraints.gridx = 0;
        constraints.gridy = 1;
        formPanel.add(emailLabel,constraints);

        constraints.gridx = 1;
        formPanel.add(emailTextField,constraints);

        constraints.gridx = 0;
        constraints.gridy = 2;
        formPanel.add(new JLabel("Genre :"),constraints);

        constraints.gridx = 1;
        formPanel.add(maleRadioButton,constraints);

        constraints.gridx = 2;
        formPanel.add(femaleRadioButton,constraints);

        constraints.gridx = 0;
        constraints.gridy = 3;
        constraints.gridwidth = 3;
        formPanel.add(addButton,constraints);

        TitledBorder formBorder = BorderFactory.createTitledBorder("Formulaire d'ajout");
        formPanel.setBorder(formBorder);

        return formPanel;
    }

    private JPanel createTablePanel (){
        JPanel tablePanel = new JPanel(new BorderLayout());

        String[] columnName = {"Nom","Email","Genre"};
        DefaultTableModel tableModel = new DefaultTableModel(columnName,0);
        table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);

        JButton detailButton = new JButton("Détails");
        detailButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = table.getSelectedRow();
                if(selectedRow >= 0){
                    showDialog(selectedRow);
                }else
                    JOptionPane.showMessageDialog(tablePanel,"Selectionnez une ligne pour voir les details");
                }
        });

        tablePanel.add(detailButton,BorderLayout.SOUTH);
        tablePanel.add(scrollPane,BorderLayout.CENTER);

        TitledBorder tableBorder = BorderFactory.createTitledBorder("Tableau des données");
        tablePanel.setBorder(tableBorder);

        return tablePanel;
    }

    private void showDialog (int index){
        DefaultTableModel tableModel = (DefaultTableModel) table.getModel();

        String name = (String) tableModel.getValueAt(index,0);
        String email = (String) tableModel.getValueAt(index,1);
        String gender = (String) tableModel.getValueAt(index,2);

        JDialog dialog = new JDialog();
        dialog.setTitle("Details");
        dialog.setModal(true);

        JPanel detailPanel = new JPanel(new GridLayout(3,2,10,10));
        detailPanel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));

        detailPanel.add(new JLabel("Nom :"));
        detailPanel.add(new JLabel(name));
        detailPanel.add(new JLabel("Email :"));
        detailPanel.add(new JLabel(email));
        detailPanel.add(new JLabel("Genre :"));
        detailPanel.add(new JLabel(gender));

        dialog.add(detailPanel);
        dialog.pack();
        dialog.setLocationRelativeTo(table);
        dialog.setVisible(true);
    }

    private void addToTable (String name,String email,String gender){
        DefaultTableModel tableModel = (DefaultTableModel) table.getModel();

        tableModel.addRow(new Object[]{name,email,gender});
    }
}
