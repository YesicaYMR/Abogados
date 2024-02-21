/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author Yesica
 */
public class Caso {

    String codigo;
    String titulo;
    String descripcion;
    String dni;
    String situacion;

    public Caso(String codigo, String titulo, String descripcion) {
        this.codigo = codigo;
        // this.dni = dni;
        this.titulo = titulo;
        this.descripcion = descripcion;
        //this.situacion = situacion;
    }

    public Caso(String codigo, String dni, String titulo, String descripcion, String situacion) {
        this.codigo = codigo;
        this.dni = dni;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.situacion = situacion;

    }

    @Override
    public String toString() {
        return codigo;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getDni() {
        return dni;
    }

    public String getSituacion() {
        return situacion;
    }

}
