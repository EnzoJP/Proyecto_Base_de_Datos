package ar.edu.uncuyo.view;

import ar.edu.uncuyo.dao.generoDAO;
import ar.edu.uncuyo.model.genero;
import ar.edu.uncuyo.controller.generoController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class generoMPanel extends JPanel {

    private JTextField idField;
    private JTextField nuevaDescripcionField;
    private JButton volverButton;
    private JButton buscarButton;
    private JButton confirmarButton;
    private JFrame framePadre;
    private JLabel estadoLabel;
    private genero generoActual;

    public generoMPanel(JFrame framePadre) {
        this.framePadre = framePadre;
        this.generoActual = null;
        setLayout(new BorderLayout());

        // Panel central con formulario
        JPanel formPanel = new JPanel(new GridLayout(3, 2, 10, 10));
        formPanel.setBorder(BorderFactory.createEmptyBorder(20, 50, 20, 50));

        // Campo para ID
        JLabel idLabel = new JLabel("ID del Género a modificar:");
        idLabel.setFont(new Font("Arial", Font.BOLD, 16));
        formPanel.add(idLabel);
        
        idField = new JTextField();
        idField.setPreferredSize(new Dimension(10, 25));
        formPanel.add(idField);

        // Botón de búsqueda
        formPanel.add(new JLabel()); // Espacio vacío
        buscarButton = new JButton("Buscar Género");
        buscarButton.setPreferredSize(new Dimension(150, 25));
        formPanel.add(buscarButton);

        // Campo para nueva descripción
        JLabel descLabel = new JLabel("Nueva Descripción:");
        descLabel.setFont(new Font("Arial", Font.BOLD, 16));
        formPanel.add(descLabel);
        
        nuevaDescripcionField = new JTextField();
        nuevaDescripcionField.setPreferredSize(new Dimension(10, 25));
        nuevaDescripcionField.setEnabled(false); // Se habilita al encontrar un género
        formPanel.add(nuevaDescripcionField);

        // Panel de estado
        estadoLabel = new JLabel("Ingrese el ID del género a modificar");
        estadoLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        estadoLabel.setForeground(Color.BLUE);

        // Panel inferior con botones
        JPanel botonesPanel = new JPanel();
        volverButton = new JButton("Volver");
        volverButton.setPreferredSize(new Dimension(200, 40));
        confirmarButton = new JButton("Confirmar Modificación");
        confirmarButton.setPreferredSize(new Dimension(200, 40));
        confirmarButton.setEnabled(false); // Se habilita al tener datos válidos
        
        botonesPanel.add(volverButton);
        botonesPanel.add(confirmarButton);

        add(formPanel, BorderLayout.CENTER);
        add(estadoLabel, BorderLayout.NORTH);
        add(botonesPanel, BorderLayout.SOUTH);

        // Acciones
        volverButton.addActionListener(this::volver);
        buscarButton.addActionListener(this::buscarGenero);
        confirmarButton.addActionListener(this::modificarGenero);
    }

    private void volver(ActionEvent e) {
        if (framePadre != null) {
            framePadre.dispose();
            new generoJFrame().setVisible(true);
        }
    }

    private void buscarGenero(ActionEvent e) {
        try {
            long id = Long.parseLong(idField.getText().trim());
            generoDAO dao = new generoDAO();
            generoActual = dao.getIdGenero(id);
            
            if (generoActual == null) {
                estadoLabel.setText("No existe un género con ese ID.");
                nuevaDescripcionField.setText("");
                nuevaDescripcionField.setEnabled(false);
                confirmarButton.setEnabled(false);
            } else {
                estadoLabel.setText("Modificando género: " + generoActual.getdescripcion());
                nuevaDescripcionField.setText(generoActual.getdescripcion());
                nuevaDescripcionField.setEnabled(true);
                confirmarButton.setEnabled(true);
            }
        } catch (NumberFormatException ex) {
            estadoLabel.setText("El ID debe ser un número válido.");
            nuevaDescripcionField.setText("");
            nuevaDescripcionField.setEnabled(false);
            confirmarButton.setEnabled(false);
        }
    }

    private void modificarGenero(ActionEvent e) {
        String nuevaDescripcion = nuevaDescripcionField.getText().trim();
        
        if (nuevaDescripcion.isEmpty()) {
            estadoLabel.setText("La descripción no puede estar vacía.");
            return;
        }
        
        // Verificar si la descripción ya existe (excepto para el género actual)
        generoDAO dao = new generoDAO();
        boolean descripcionExiste = dao.getAllGeneros().stream()
            .anyMatch(g -> g.getdescripcion().equalsIgnoreCase(nuevaDescripcion) 
                && !g.getID_genero().equals(generoActual.getID_genero()));
 
            
        if (descripcionExiste) {
            estadoLabel.setText("Ya existe otro género con esa descripción.");
            return;
        }
        
        // Confirmar modificación
        int confirmacion = JOptionPane.showConfirmDialog(
            this, 
            "¿Está seguro que desea modificar el género?",
            "Confirmar Modificación",
            JOptionPane.YES_NO_OPTION);
        
        if (confirmacion == JOptionPane.YES_OPTION) {
            generoActual.setDescripcion(nuevaDescripcion);
            new generoController().modificarGenero(
                generoActual.getID_genero(), 
                nuevaDescripcion);
            estadoLabel.setText("Género modificado correctamente!");
            
            // Resetear campos
            idField.setText("");
            nuevaDescripcionField.setText("");
            nuevaDescripcionField.setEnabled(false);
            confirmarButton.setEnabled(false);
            generoActual = null;
        }
    }
}