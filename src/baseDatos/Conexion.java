package baseDatos;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author Yesica
 */
public class Conexion {

    Connection conexion;

    /**
     * Método para asegurarse de que tengo el driver
     *
     * @return
     */
    public int registrarDriver() {
        int resultado;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            resultado = 0;
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Conexion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            resultado = -1;
        }
        return resultado;
    }

    /**
     * conectar con mysql
     *
     * @param url
     * @return
     */
    public int conectar(String url) {
        int resultado;

        try {
            conexion = DriverManager.getConnection(url, "root", "Aa123456789.");//usuario y contraseña que tengo en mysql
            resultado = 0;
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
            resultado = -1;
        }
        return resultado;
    }

    /**
     * busca el driver y conecta
     *
     * @param url
     * @return
     */
    public int establecer(String url) {
        int resultado;
        resultado = registrarDriver();
        if (resultado != -1) {
            resultado = conectar(url);
        }
        return resultado;
    }

    /**
     * cierra la conexion con la base de datos
     */
    public void cerrar() {
        try {
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public Connection getConexion() {
        return conexion;
    }

}
