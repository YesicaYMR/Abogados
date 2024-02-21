/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import javax.swing.table.DefaultTableModel;

/**
 * creamos una clase que es una especializacion de default table model xa
 * modificar que se puedan editar ciertas celdas
 *
 * @author Yesica
 */
public class MiModeloTabla extends DefaultTableModel {

    @Override// boton derecho, insertar codigo, override. salen todos los métodos de la clase padre
    public boolean isCellEditable(int row, int column) {//esta linea no se puede cambiar
        // return super.isCellEditable(row, column); //super. significa q va a ejecutar el metodo del padre// hay que borrarla
        boolean editable = true;
        if (column == 0 || column ==1 || column==2) {//si la columna es la 0 no dejamos modificarla
            editable = false;
         
        }
        return editable;
    }

}
