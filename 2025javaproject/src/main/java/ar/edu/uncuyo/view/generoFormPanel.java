package ar.edu.uncuyo.view;

import ar.edu.uncuyo.dao.generoDAO;
import ar.edu.uncuyo.model.genero;
import ar.edu.uncuyo.controller.generoController;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class generoFormPanel extends JPanel {

    private JTextField descripcionField;
    private JButton volverButton;
    private JButton confirmarButton;
    private JFrame framePadre; // para cerrar ventana si está en un JFrame

    public generoFormPanel(JFrame framePadre) {
        this.framePadre = framePadre;
;
        setLayout(new BorderLayout());

        // Panel central con formulario
        JPanel formPanel = new JPanel(new GridLayout(1, 2, 10, 10));
        formPanel.setBorder(BorderFactory.createEmptyBorder(60, 50, 600, 50));

        JLabel descripcionLabel = new JLabel("Descripción:");
        descripcionLabel.setFont(new Font("Arial", Font.BOLD, 16));
        formPanel.add(descripcionLabel);
        descripcionField = new JTextField();
        descripcionField.setPreferredSize(new Dimension(10, 25));
        formPanel.add(descripcionField);

        // Panel inferior con botones
        JPanel botonesPanel = new JPanel();
        volverButton = new JButton("Volver");
        volverButton.setPreferredSize(new Dimension(300, 50));
        confirmarButton = new JButton("Confirmar");
        confirmarButton.setPreferredSize(new Dimension(300, 50));
        botonesPanel.add(volverButton);
        botonesPanel.add(confirmarButton);

        botonesPanel.add(volverButton);
        botonesPanel.add(confirmarButton);

        add(formPanel, BorderLayout.CENTER);
        add(botonesPanel, BorderLayout.SOUTH);

        // Acciones
        volverButton.addActionListener(this::volver);
        confirmarButton.addActionListener(this::guardarGenero);
    }

    private void volver(ActionEvent e) {
        if (framePadre != null) {
            framePadre.dispose();
            new generoJFrame().setVisible(true);
        }
    }

    private void guardarGenero(ActionEvent e) {
        String descripcion = descripcionField.getText().trim();
        if (descripcion.isEmpty()) {
            JOptionPane.showMessageDialog(this, "La descripción no puede estar vacía.");
            return;
        }
        //ver si ya existe un género con la misma descripción

        if (new generoDAO().getAllGeneros().stream()
                .anyMatch(g -> g.getdescripcion().equalsIgnoreCase(descripcion))) {
            JOptionPane.showMessageDialog(this, "Ya existe un género con esa descripción.");
            return;
        }

        genero g = new genero();
        g.setDescripcion(descripcion);
        new generoController().guardar(descripcion);
        JOptionPane.showMessageDialog(this, "Género guardado correctamente.");
        descripcionField.setText("");
    }
}
