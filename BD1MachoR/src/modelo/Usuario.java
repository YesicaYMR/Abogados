/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author Yesica
 */
public class Usuario {

    String dni;
    String nombre;
    String login;
    String contra;
    int perfil;

    public Usuario(String dni, int perfil) {
        this.dni = dni;
        this.perfil = perfil;

    }

    public Usuario(String dni, String nombre) {
        this.dni = dni;
        this.nombre = nombre;
    }

    public String getDni() {
        return dni;
    }

    public String getNombre() {
        return nombre;
    }

    public int getPerfil() {
        return perfil;
    }

    @Override
    public String toString() {
        return nombre;
    }

}
