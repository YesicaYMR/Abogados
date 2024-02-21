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

/**
 *
 * @author Yesica
 */
public class PnlConsultaCasosAsignados extends javax.swing.JPanel {

    Usuario usuario;
    DefaultComboBoxModel modeloCombo;
    Conexion conexion;
    OperacionesTabla operaciones;
    MiModeloTabla modeloTablaAcciones;

    /**
     * Creates new form PnlConsultaCasosAsignados
     */
    public PnlConsultaCasosAsignados(Usuario usuario) {
        initComponents();
        this.usuario = usuario;
        conexion = new Conexion();

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

    /**
     * carga los casos asignados al usuario logueado
     */
    private void cargarInfoCombo() {
        modeloCombo.addElement("Seleccione una opción");//sale como primera opcion la frase
        ArrayList<Caso> casos = operaciones.buscarTodosCasosAbogado(usuario.getDni());
        modeloCombo.addAll(casos);

    }

    /**
     * carga la información a la tabla de acciones del caso seleccionado
     * @param codCaso 
     */
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

    /**
     * borra los cargados de la tabla acciones
     */
    private void limpiarTablaAcciones() {
        int nFilas = modeloTablaAcciones.getRowCount();
        for (int pos = 0; pos < nFilas; pos++) {
            modeloTablaAcciones.removeRow(0);
        }
    }

    /**
     * establece la pantalla a su estado inicial
     */
    private void limpiar() {
        limpiarTablaAcciones();
        cmbCasos.setSelectedIndex(0);
        lblTitulo.setText("");
        txtDescripcion.setText("");
        lblSituacion.setText("");
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
        txtDescripcion = new javax.swing.JTextArea();
        lblTitulo = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblAcciones = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        lblSituacion = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
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
        add(cmbCasos, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 60, 220, 30));

        txtDescripcion.setEditable(false);
        txtDescripcion.setColumns(20);
        txtDescripcion.setFont(new java.awt.Font("Bell MT", 0, 18)); // NOI18N
        txtDescripcion.setRows(5);
        jScrollPane1.setViewportView(txtDescripcion);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, 420, 100));

        lblTitulo.setFont(new java.awt.Font("Bell MT", 0, 18)); // NOI18N
        lblTitulo.setForeground(new java.awt.Color(255, 255, 255));
        add(lblTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 110, 100, 20));

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
        jScrollPane2.setViewportView(tblAcciones);

        add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 290, -1, 110));

        jLabel2.setFont(new java.awt.Font("Bell MT", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Caso:");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 110, -1, 20));

        lblSituacion.setFont(new java.awt.Font("Bell MT", 0, 18)); // NOI18N
        lblSituacion.setForeground(new java.awt.Color(255, 255, 255));
        add(lblSituacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 110, 160, 20));

        jLabel3.setFont(new java.awt.Font("Bell MT", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Estado:");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 110, -1, 20));

        jLabel1.setFont(new java.awt.Font("Bell MT", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Consulta casos asignados");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 20, -1, -1));

        fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/fondo.png"))); // NOI18N
        add(fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void cmbCasosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbCasosActionPerformed
        int pos = cmbCasos.getSelectedIndex();//dame el seleccionado
        if (pos != 0) {
            Caso c = (Caso) modeloCombo.getElementAt(pos);
            lblTitulo.setText(c.getTitulo());
            txtDescripcion.setText(c.getDescripcion());
            if (c.getSituacion().equals("a")) {
                lblSituacion.setText("Caso abierto");
            } else {
                lblSituacion.setText("Caso cerrado");
            }
            cargarTablaAcciones(c.getCodigo());

        } else {

            try {
                limpiar();
            } catch (Exception ex) {

            }
        }
    }//GEN-LAST:event_cmbCasosActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cmbCasos;
    private javax.swing.JLabel fondo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblSituacion;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JTable tblAcciones;
    private javax.swing.JTextArea txtDescripcion;
    // End of variables declaration//GEN-END:variables
}
