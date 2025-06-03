package ar.edu.uncuyo.view;

import ar.edu.uncuyo.dao.generoDAO;
import ar.edu.uncuyo.model.genero;
import java.util.List;
import javax.swing.table.DefaultTableModel;



public class generoJFrame extends javax.swing.JFrame {

    public generoJFrame() {
        initComponents();
        cargarTablaGenero();
        //centrar la ventanita
        this.setLocationRelativeTo(null);
        setTitle("Gestión de Géneros");
    }

    private void cargarTablaGenero() {
        String[] columnas = {"ID", "Descripción"};
        DefaultTableModel modelo = new DefaultTableModel(columnas, 0);

        generoDAO dao = new generoDAO();
        List<genero> lista = dao.getAllGeneros();

        for (genero g : lista) {
            Object[] fila = {
                g.getID_genero(),
                g.getdescripcion()
            };
            modelo.addRow(fila);
        }

        jTable2.setModel(modelo);
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        modificaGeneroButton = new javax.swing.JButton();
        CargarGeneroButton = new javax.swing.JButton();
        EliminarGeneroButton = new javax.swing.JButton();
        volverButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {},
            new String [] {"ID", "Descripción"}
        ));
        jScrollPane2.setViewportView(jTable2);

        modificaGeneroButton.setFont(new java.awt.Font("sansserif", 0, 18));
        modificaGeneroButton.setText("Modificar Género");
        modificaGeneroButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modificaGeneroButtonActionPerformed(evt);
            }
        });

        CargarGeneroButton.setFont(new java.awt.Font("sansserif", 0, 18));
        CargarGeneroButton.setText("Cargar Género");
        CargarGeneroButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CargarGeneroButtonActionPerformed(evt);
            }
        });

        EliminarGeneroButton.setFont(new java.awt.Font("sansserif", 0, 18));
        EliminarGeneroButton.setText("Eliminar Género");
        EliminarGeneroButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EliminarGeneroButtonActionPerformed(evt);
            }
        });

        volverButton2.setFont(new java.awt.Font("sansserif", 0, 18));
        volverButton2.setText("VOLVER");
        volverButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                volverButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(CargarGeneroButton, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addComponent(modificaGeneroButton, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(64, 64, 64)
                .addComponent(EliminarGeneroButton, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(133, 133, 133)
                .addComponent(volverButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(49, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 456, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(71, 71, 71)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(modificaGeneroButton, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(EliminarGeneroButton, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CargarGeneroButton, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(volverButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(171, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>

    private void modificaGeneroButtonActionPerformed(java.awt.event.ActionEvent evt) {
        this.setContentPane(new generoMPanel(this));
        this.revalidate();
    }

    private void CargarGeneroButtonActionPerformed(java.awt.event.ActionEvent evt) {
        this.setContentPane(new generoFormPanel(this));
        this.revalidate();

    }

    private void volverButton2ActionPerformed(java.awt.event.ActionEvent evt) {
        this.dispose();
    }

    public void EliminarGeneroButtonActionPerformed(java.awt.event.ActionEvent evt) {
        this.setContentPane(new generoFormBajaPanel(this));
        this.revalidate();
    }
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> new generoJFrame().setVisible(true));
    }

    // Variables declaration
    private javax.swing.JButton CargarGeneroButton;
    private javax.swing.JButton EliminarGeneroButton;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable2;
    private javax.swing.JButton modificaGeneroButton;
    private javax.swing.JButton volverButton2;
    // End of variables declaration.
}
