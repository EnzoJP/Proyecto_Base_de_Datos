package ar.edu.uncuyo.view;


import java.awt.event.ActionEvent;

import javax.swing.JOptionPane;
import ar.edu.uncuyo.model.*;
import ar.edu.uncuyo.controller.clienteController;
import ar.edu.uncuyo.dao.*;

public class clienteFormPanel extends javax.swing.JFrame {

    public clienteFormPanel() {
        initComponents();
        setTitle("Cargar Cliente");
    }

    private void initComponents() {

        cargarButton = new javax.swing.JButton();
        VolverButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jTextFieldnombre = new javax.swing.JTextField();
        jTextFieldapellido = new javax.swing.JTextField();
        jTextFieldDNI = new javax.swing.JTextField();
        jTextFieldtelefono = new javax.swing.JTextField();
        jTextFieldemail = new javax.swing.JTextField();
        jTextFieldCP = new javax.swing.JTextField(); // Renombrado
        jTextFieldIDgenero = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        cargarButton.setFont(new java.awt.Font("Arial", 0, 18));
        cargarButton.setText("CARGAR");
        cargarButton.addActionListener(this::cargarButtonActionPerformed);

        VolverButton2.setFont(new java.awt.Font("Arial", 0, 18));
        VolverButton2.setText("VOLVER");
        VolverButton2.addActionListener(this::VolverButton2ActionPerformed);

        jLabel1.setText("Nombre");
        jLabel2.setText("Apellido");
        jLabel3.setText("DNI");
        jLabel4.setText("Teléfono");
        jLabel5.setText("E-MAIL");
        jLabel6.setText("Código Postal");
        jLabel7.setText("ID de género");


        // Layout generado
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);

        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextFieldnombre, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldapellido, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldDNI, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldtelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldemail, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldCP, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldIDgenero, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(50, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(200, 200, 200)
                .addComponent(cargarButton, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(VolverButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(200, Short.MAX_VALUE))
    );

    layout.setVerticalGroup(
        layout.createSequentialGroup()
        .addGap(20, 20, 20)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
            .addComponent(jLabel1)
            .addComponent(jTextFieldnombre, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addGap(10, 10, 10)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
            .addComponent(jLabel2)
            .addComponent(jTextFieldapellido, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addGap(10, 10, 10)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
            .addComponent(jLabel3)
            .addComponent(jTextFieldDNI, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addGap(10, 10, 10)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
            .addComponent(jLabel4)
            .addComponent(jTextFieldtelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addGap(10, 10, 10)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
            .addComponent(jLabel5)
            .addComponent(jTextFieldemail, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addGap(10, 10, 10)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
            .addComponent(jLabel6)
            .addComponent(jTextFieldCP, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addGap(10, 10, 10)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
            .addComponent(jLabel7)
            .addComponent(jTextFieldIDgenero, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addGap(20, 20, 20)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
            .addComponent(cargarButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(VolverButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addContainerGap(20, Short.MAX_VALUE)
    );

        pack();
    }


    private void VolverButton2ActionPerformed(ActionEvent evt) {
        new clienteJFrame().setVisible(true);
        this.dispose(); // Cierra este formulario
    }

    private void cargarButtonActionPerformed(ActionEvent evt) {
        // Obtenemos los valores ingresados
        String nombre = jTextFieldnombre.getText();
        String apellido = jTextFieldapellido.getText();
        String dni = jTextFieldDNI.getText();
        String telefono = jTextFieldtelefono.getText();
        String email = jTextFieldemail.getText();
        String cp = jTextFieldCP.getText();
        String idGenero = jTextFieldIDgenero.getText();

        if (nombre.isEmpty() || apellido.isEmpty() || dni.isEmpty() || telefono.isEmpty() || email.isEmpty() || cp.isEmpty() || idGenero.isEmpty()) {
            javax.swing.JOptionPane.showMessageDialog(this, "Por favor, complete todos los campos.");
            return;
        }

        if (new clienteDAO().getAllClientes().stream()
                .anyMatch(g -> g.getDni().equalsIgnoreCase(dni)
                        || g.getEmail().equalsIgnoreCase(email))){
            JOptionPane.showMessageDialog(this, "Ya existe ese cliente.");
            return;
        }

        cliente nuevoCliente = new cliente();
        nuevoCliente.setNombre(nombre);
        nuevoCliente.setApellido(apellido);
        nuevoCliente.setDni(dni);
        nuevoCliente.setTelefono(telefono);
        nuevoCliente.setEmail(email);
        nuevoCliente.setCodPostal(cp);

        //caso de que el idGenero exista en los generos cargados

        Long idGeneroLong;
        try {
            idGeneroLong = Long.parseLong(idGenero);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "El ID de género debe ser un número válido.");
            return;
        }

        if (new generoDAO().getAllGeneros().stream()
                .anyMatch(g -> g.getID_genero().equals(idGeneroLong))) {
            //como el constructor de cliente recibe un objeto genero tengo que buscar ese objeto con el id
            genero generoSeleccionado = new generoDAO().getAllGeneros().stream()
                    .filter(g -> g.getID_genero().equals(idGeneroLong))
                    .findFirst()
                    .orElse(null);
            if (generoSeleccionado != null) {
                nuevoCliente.setIdObjeto(generoSeleccionado);
            } else {
                JOptionPane.showMessageDialog(this, "El género seleccionado no existe.");
                return;
            }
            clienteController controller = new clienteController();
            controller.guardar(nuevoCliente);
            JOptionPane.showMessageDialog(this, "Cliente cargado exitosamente.");
        } else {
            JOptionPane.showMessageDialog(this, "El ID de género no existe.");
            return;
        }
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> new clienteFormPanel().setVisible(true));
    }

    // Variables declaration
    private javax.swing.JButton VolverButton2;
    private javax.swing.JButton cargarButton;
    private javax.swing.JLabel jLabel1, jLabel2, jLabel3, jLabel4, jLabel5, jLabel6, jLabel7;
    private javax.swing.JTextField jTextFieldnombre;
    private javax.swing.JTextField jTextFieldapellido;
    private javax.swing.JTextField jTextFieldDNI;
    private javax.swing.JTextField jTextFieldtelefono;
    private javax.swing.JTextField jTextFieldemail;
    private javax.swing.JTextField jTextFieldCP;
    private javax.swing.JTextField jTextFieldIDgenero;
    // End of variables declaration
}
