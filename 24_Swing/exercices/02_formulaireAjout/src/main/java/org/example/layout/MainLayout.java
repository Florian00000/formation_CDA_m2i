package org.example.layout;

import lombok.Data;

import javax.swing.*;
import java.awt.*;

@Data
public class MainLayout {

    private JPanel panel;
    private JPanel form;
    private JPanel table;

    public MainLayout() {
        panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.add(getPanelForm(), BorderLayout.NORTH);
        panel.add(getPanelTable(), BorderLayout.CENTER);
    }

    public JPanel getPanelForm() {
        form = new JPanel();
        form.setLayout(new BoxLayout(form, BoxLayout.Y_AXIS));


        form.add(new JLabel("Formulaire d'ajout"));

        JPanel nameLabel = new JPanel();
        nameLabel.add(new JLabel("Nom:"));
        nameLabel.add(new JTextField(20));

        JPanel emailLabel = new JPanel();
        emailLabel.add(new JLabel("Email:"));
        emailLabel.add(new JTextField(20));

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
        buttonLabel.add(new JButton("Ajouter"));


        form.add(nameLabel);
        form.add(emailLabel);
        form.add(genderLabel);
        form.add(buttonLabel);
        return form;
    }

    public JPanel getPanelTable() {
        table = new JPanel();
        table.add(new JLabel("Table"));
        return table;
    }
}
