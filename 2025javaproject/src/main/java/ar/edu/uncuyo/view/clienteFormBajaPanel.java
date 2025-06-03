package ar.edu.uncuyo.view;

import ar.edu.uncuyo.controller.clienteController;
import ar.edu.uncuyo.dao.clienteDAO;
import ar.edu.uncuyo.model.cliente;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class clienteFormBajaPanel extends JPanel {

    private JTextField idField;
    private JButton volverButton;
    private JButton confirmarButton;
    private JFrame framePadre;
    private JLabel resultadoLabel;

    public clienteFormBajaPanel(JFrame framePadre) {
        this.framePadre = framePadre;
        setLayout(new BorderLayout());

        // Panel central con formulario
        JPanel formPanel = new JPanel(new GridLayout(2, 2, 10, 10));
        formPanel.setBorder(BorderFactory.createEmptyBorder(60, 50, 60, 50));

        JLabel idLabel = new JLabel("ID del Cliente a eliminar:");
        idLabel.setFont(new Font("Arial", Font.BOLD, 16));
        formPanel.add(idLabel);

        idField = new JTextField();
        idField.setPreferredSize(new Dimension(10, 10));
        formPanel.add(idField);

        resultadoLabel = new JLabel("");
        resultadoLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        resultadoLabel.setForeground(Color.RED);
        formPanel.add(resultadoLabel);

        // Panel inferior con botones
        JPanel botonesPanel = new JPanel();
        volverButton = new JButton("Volver");
        volverButton.setPreferredSize(new Dimension(300, 50));
        confirmarButton = new JButton("Confirmar Baja");
        confirmarButton.setPreferredSize(new Dimension(300, 50));
        botonesPanel.add(volverButton);
        botonesPanel.add(confirmarButton);

        add(formPanel, BorderLayout.CENTER);
        add(botonesPanel, BorderLayout.SOUTH);

        // Acciones
        volverButton.addActionListener(this::volver);
        confirmarButton.addActionListener(this::eliminarCliente);
    }

    private void volver(ActionEvent e) {
        if (framePadre != null) {
            framePadre.dispose();
            new clienteJFrame().setVisible(true);
        }
    }

    private void eliminarCliente(ActionEvent e) {
        try {
            long id = Long.parseLong(idField.getText().trim());

            // Verificar si el cliente existe
            clienteDAO dao = new clienteDAO();
            cliente clienteAEliminar = dao.getIdCliente(id);

            if (clienteAEliminar == null) {
                resultadoLabel.setText("No existe un cliente con ese ID.");
                return;
            }

            // Confirmación antes de eliminar
            int confirmacion = JOptionPane.showConfirmDialog(
                this,
                "¿Está seguro que desea eliminar al cliente: " + clienteAEliminar.getNombre() + " " + clienteAEliminar.getApellido() + "?",
                "Confirmar Baja",
                JOptionPane.YES_NO_OPTION
            );

            if (confirmacion == JOptionPane.YES_OPTION) {
                new clienteController().eliminarCliente(clienteAEliminar);
                resultadoLabel.setText("Cliente eliminado correctamente.");
                idField.setText("");
            }

        } catch (NumberFormatException ex) {
            resultadoLabel.setText("El ID debe ser un número válido.");
        } catch (Exception ex) {
            resultadoLabel.setText("Error al eliminar el cliente: " + ex.getMessage());
        }
    }
}
