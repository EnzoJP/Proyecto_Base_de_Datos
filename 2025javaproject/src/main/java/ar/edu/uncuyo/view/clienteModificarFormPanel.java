package ar.edu.uncuyo.view;

import ar.edu.uncuyo.controller.clienteController;
import ar.edu.uncuyo.dao.clienteDAO;
import ar.edu.uncuyo.dao.generoDAO;
import ar.edu.uncuyo.model.cliente;
import ar.edu.uncuyo.model.genero;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class clienteModificarFormPanel extends JFrame {

    private JTextField idClienteField;
    private JTextField nombreField, apellidoField, dniField, telefonoField, emailField, cpField, idGeneroField;
    private JButton buscarButton, modificarButton, volverButton;
    private cliente clienteActual;

    public clienteModificarFormPanel() {
        initComponents();
        setTitle("Modificar Cliente");
    }

    private void initComponents() {
        setTitle("Modificar Cliente");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        setSize(600, 500);
        setLocationRelativeTo(null);

        JLabel idLabel = new JLabel("ID Cliente:");
        idLabel.setBounds(50, 20, 100, 30);
        add(idLabel);

        idClienteField = new JTextField();
        idClienteField.setBounds(160, 20, 300, 30);
        add(idClienteField);

        buscarButton = new JButton("Buscar");
        buscarButton.setBounds(470, 20, 90, 30);
        buscarButton.addActionListener(this::buscarCliente);
        add(buscarButton);

        String[] labels = {"Nombre", "Apellido", "DNI", "Teléfono", "Email", "Código Postal", "ID de Género"};
        JTextField[] fields = new JTextField[labels.length];
        int y = 70;

        for (int i = 0; i < labels.length; i++) {
            JLabel lbl = new JLabel(labels[i] + ":");
            lbl.setBounds(50, y, 100, 30);
            add(lbl);

            JTextField field = new JTextField();
            field.setBounds(160, y, 300, 30);
            add(field);
            fields[i] = field;

            y += 40;
        }

        nombreField = fields[0];
        apellidoField = fields[1];
        dniField = fields[2];
        telefonoField = fields[3];
        emailField = fields[4];
        cpField = fields[5];
        idGeneroField = fields[6];

        modificarButton = new JButton("Modificar");
        modificarButton.setBounds(160, y, 130, 40);
        modificarButton.setEnabled(false);
        modificarButton.addActionListener(this::modificarCliente);
        add(modificarButton);

        volverButton = new JButton("Volver");
        volverButton.setBounds(330, y, 130, 40);
        volverButton.addActionListener(e -> {
            new clienteJFrame().setVisible(true);
            this.dispose();
        });
        add(volverButton);
    }

    private void buscarCliente(ActionEvent e) {
        String idTexto = idClienteField.getText();
        if (idTexto.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ingrese el ID del cliente.");
            return;
        }

        long id;
        try {
            id = Long.parseLong(idTexto);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "ID inválido.");
            return;
        }

        clienteDAO dao = new clienteDAO();
        clienteActual = dao.getAllClientes().stream()
                .filter(c -> c.getId() == id)
                .findFirst()
                .orElse(null);

        if (clienteActual == null) {
            JOptionPane.showMessageDialog(this, "No se encontró un cliente con ese ID.");
            return;
        }

        // Llenar campos
        nombreField.setText(clienteActual.getNombre());
        apellidoField.setText(clienteActual.getApellido());
        dniField.setText(clienteActual.getDni());
        telefonoField.setText(clienteActual.getTelefono());
        emailField.setText(clienteActual.getEmail());
        cpField.setText(clienteActual.getCodPostal());
        idGeneroField.setText(clienteActual.getGenero().getID_genero().toString());

        modificarButton.setEnabled(true);
    }

    private void modificarCliente(ActionEvent e) {
        if (clienteActual == null) return;

        clienteActual.setNombre(nombreField.getText());
        clienteActual.setApellido(apellidoField.getText());
        clienteActual.setDni(dniField.getText());
        clienteActual.setTelefono(telefonoField.getText());
        clienteActual.setEmail(emailField.getText());
        clienteActual.setCodPostal(cpField.getText());

        Long idGenero;
        try {
            idGenero = Long.parseLong(idGeneroField.getText());
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "ID de género inválido.");
            return;
        }

        genero generoSeleccionado = new generoDAO().getAllGeneros().stream()
                .filter(g -> g.getID_genero().equals(idGenero))
                .findFirst()
                .orElse(null);

        if (generoSeleccionado == null) {
            JOptionPane.showMessageDialog(this, "No se encontró ese género.");
            return;
        }

        //confirmar

        int confirmacion = JOptionPane.showConfirmDialog(this, 
                "¿Está seguro que desea modificar el cliente con ID: " + clienteActual.getId() + "?",
                "Confirmar Modificación", JOptionPane.YES_NO_OPTION);
        if (confirmacion != JOptionPane.YES_OPTION) {
            return;
        }else{
            clienteActual.setIdObjeto(generoSeleccionado);
            new clienteController().modificarCliente(clienteActual);
            JOptionPane.showMessageDialog(this, "Cliente modificado con éxito.");
            modificarButton.setEnabled(false);}
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new clienteModificarFormPanel().setVisible(true));
    }
}
