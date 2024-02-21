/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package vista;

import baseDatos.Conexion;
import baseDatos.OperacionesTabla;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import modelo.Accion;
import modelo.Caso;
import modelo.MiModeloTabla;
import modelo.Usuario;
import utilidades.Fecha;

/**
 *
 * @author Yesica
 */
public class PnlNuevasAcciones extends javax.swing.JPanel {

    DefaultComboBoxModel modeloCombo;
    Conexion conexion;
    OperacionesTabla operaciones;
    Usuario usuario;
    MiModeloTabla modeloTablaAcciones;

    /**
     * Creates new form PnlNuevasAcciones
     */
    public PnlNuevasAcciones(Usuario usuario) {
        initComponents();
        conexion = new Conexion();
        this.usuario = usuario;

        if (conexion.establecer("jdbc:mysql://localhost:3306/bufetemachor") == -1) {
            JOptionPane.showMessageDialog(null, "Errores en la base de datos");
            System.exit(-1);
        } else {
            operaciones = new OperacionesTabla(conexion);
        }
        modeloCombo = new DefaultComboBoxModel();//creamos el modeloCombo de los datos
        cmbCasos.setModel(modeloCombo);//insertamos los datos
        cargarInfoCombo();
        modeloTablaAcciones = new MiModeloTabla();
        String[] titulosAcciones = {"Código acción", "Fecha", "Descripción"};
        modeloTablaAcciones.setColumnIdentifiers(titulosAcciones);//inserta los titulos escritos 
        tblAcciones.setModel(modeloTablaAcciones);
    }

    private void cargarInfoCombo() {
        modeloCombo.addElement("Seleccione una opción");//sale como primera opcion la frase
        ArrayList<Caso> casos = operaciones.buscarCasos(usuario.getDni());
        modeloCombo.addAll(casos);

    }

    private void cargarTablaAcciones(String codCaso) {
        limpiarTablaAcciones();
        ArrayList<Accion> acciones = operaciones.buscarAcciones(codCaso);
        for (Accion a : acciones) {
            Vector v = new Vector();
            v.add(a.getCodAccion());
            v.add(a.getFecha());
            v.add(a.getDescripcion());
            modeloTablaAcciones.addRow(v);
        }
    }

    private void limpiarTablaAcciones() {
        int nFilas = modeloTablaAcciones.getRowCount();
        for (int pos = 0; pos < nFilas; pos++) {
            modeloTablaAcciones.removeRow(0);
        }
    }

    private void limpiar() {
        limpiarTablaAcciones();
        cmbCasos.setSelectedIndex(0);
        lblTitulo.setText("");
        txtCodAccion.setText("");
        txtDescripcion.setText("");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cmbCasos = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblAcciones = new javax.swing.JTable();
        btnAceptar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        txtDescripcion = new javax.swing.JTextField();
        txtCodAccion = new javax.swing.JTextField();
        lblTitulo = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        fondo = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        cmbCasos.setFont(new java.awt.Font("Bell MT", 0, 18)); // NOI18N
        cmbCasos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbCasos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbCasosActionPerformed(evt);
            }
        });
        add(cmbCasos, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 70, 240, 40));

        tblAcciones.setFont(new java.awt.Font("Bell MT", 0, 18)); // NOI18N
        tblAcciones.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tblAcciones);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, -1, 90));

        btnAceptar.setFont(new java.awt.Font("Bell MT", 0, 14)); // NOI18N
        btnAceptar.setText("Aceptar");
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });
        add(btnAceptar, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 350, -1, -1));

        btnCancelar.setFont(new java.awt.Font("Bell MT", 0, 14)); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 350, -1, -1));

        txtDescripcion.setFont(new java.awt.Font("Bell MT", 0, 18)); // NOI18N
        add(txtDescripcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 280, 210, 30));

        txtCodAccion.setFont(new java.awt.Font("Bell MT", 0, 18)); // NOI18N
        txtCodAccion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCodAccionKeyTyped(evt);
            }
        });
        add(txtCodAccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(87, 279, 70, 30));

        lblTitulo.setFont(new java.awt.Font("Bell MT", 0, 18)); // NOI18N
        lblTitulo.setForeground(new java.awt.Color(255, 255, 255));
        add(lblTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 120, 220, 30));

        jLabel2.setFont(new java.awt.Font("Bell MT", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Caso:");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 120, -1, 30));

        jLabel3.setFont(new java.awt.Font("Bell MT", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Descripción:");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 280, -1, 30));

        jLabel4.setFont(new java.awt.Font("Bell MT", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Código:");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 280, -1, 30));

        jLabel1.setFont(new java.awt.Font("Bell MT", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Nuevas Acciones");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 20, -1, -1));

        fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/fondo.png"))); // NOI18N
        add(fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void cmbCasosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbCasosActionPerformed
        int pos = cmbCasos.getSelectedIndex();//dame el seleccionado
        if (pos != 0) {
            Caso c = (Caso) modeloCombo.getElementAt(pos);
            lblTitulo.setText(c.getTitulo());
            cargarTablaAcciones(c.getCodigo());
            btnAceptar.setEnabled(true);

        } else {
            btnAceptar.setEnabled(false);
            try {
                limpiar();
            } catch (Exception ex) {

            }
        }
    }//GEN-LAST:event_cmbCasosActionPerformed

    private void txtCodAccionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodAccionKeyTyped
        //Limita a escribir un máximo de 3 caracteres        
        if (txtCodAccion.getText().length() >= 3) {
            evt.consume();
        }
    }//GEN-LAST:event_txtCodAccionKeyTyped

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        Caso c = (Caso) modeloCombo.getElementAt(cmbCasos.getSelectedIndex());
        String codCaso = c.getCodigo();
        String codAccion = txtCodAccion.getText();
       
        if(!operaciones.existeAccion(codCaso,codAccion)){
        String descripcion = txtDescripcion.getText();
        String fecha = Fecha.fechaActualNumero();
        operaciones.crearAccion(codCaso, codAccion, fecha, descripcion);
        JOptionPane.showMessageDialog(this, "Caso actualizado", "Información", JOptionPane.INFORMATION_MESSAGE);
        txtCodAccion.setText("");
        txtDescripcion.setText("");
        limpiarTablaAcciones();
        cargarTablaAcciones(codCaso); 
            
        }
        else{
            JOptionPane.showMessageDialog(this, "Ya existe esta acción en este caso", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnAceptarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        limpiar();
    }//GEN-LAST:event_btnCancelarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JComboBox<String> cmbCasos;
    private javax.swing.JLabel fondo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JTable tblAcciones;
    private javax.swing.JTextField txtCodAccion;
    private javax.swing.JTextField txtDescripcion;
    // End of variables declaration//GEN-END:variables
}