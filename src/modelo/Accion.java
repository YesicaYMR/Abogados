/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author Yesica
 */
public class Accion {

    String codCaso;
    String codAccion;
    String fecha;
    String descripcion;

    public Accion(String codAccion, String fecha, String descripcion) {

        this.codAccion = codAccion;
        this.fecha = fecha;
        this.descripcion = descripcion;
    }

    public String getCodCaso() {
        return codCaso;
    }

    public String getCodAccion() {
        return codAccion;
    }

    public String getFecha() {
        return fecha;
    }

    public String getDescripcion() {
        return descripcion;
    }

}
