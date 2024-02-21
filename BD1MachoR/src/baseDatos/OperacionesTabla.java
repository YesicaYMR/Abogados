/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package baseDatos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Accion;
import modelo.Caso;
import modelo.Usuario;
import utilidades.Encriptacion;

/**
 *
 * @author Yesica
 */
public class OperacionesTabla {

    Conexion bd;

    public OperacionesTabla(Conexion bd) {
        this.bd = bd;
    }

    /*public boolean existeUsuario(String login) {
        boolean resultado = false;
        String sql = "select * from personal where login='" + login + "'";
        PreparedStatement sentencia;

        try {
            sentencia = bd.getConexion().prepareStatement(sql);
            ResultSet registros = sentencia.executeQuery();
            if (registros.next()) {
                resultado = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(OperacionesTabla.class.getName()).log(Level.SEVERE, null, ex);
        }

        return resultado;
    }*/
    public boolean contraCorrecta(String login, String contra) {
        boolean resultado = false;
        contra = Encriptacion.getMD5(contra);
        String sql = "select  * from personal where login='" + login + "' and contra='" + contra + "'";
        PreparedStatement sentencia;

        try {
            sentencia = bd.getConexion().prepareStatement(sql);
            ResultSet registros = sentencia.executeQuery();
            if (registros.next()) {
                resultado = true;
                // Datos dato=new Datos(registros.getString("perfil"),registros.getString("dni"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(OperacionesTabla.class.getName()).log(Level.SEVERE, null, ex);
        }

        return resultado;
    }

    public Usuario buscarUsuario(String login) {
        int perfil;
        String dni;
        Usuario usuario = null;
        String sql = "select * from personal where login='" + login + "'";
        PreparedStatement sentencia;

        try {
            sentencia = bd.getConexion().prepareStatement(sql);
            ResultSet registros = sentencia.executeQuery();
            registros.next();

            if (registros.getString("perfil").equals("abogado")) {
                perfil = 0;
            } else {
                perfil = 1;
            }
            dni = registros.getString("dni");
            usuario = new Usuario(dni, perfil);
        } catch (SQLException ex) {
            Logger.getLogger(OperacionesTabla.class.getName()).log(Level.SEVERE, null, ex);
        }

        return usuario;
    }

    public ArrayList<Usuario> todosUsuarios() {

        ArrayList<Usuario> usuarios = new ArrayList<>();
        String sql = "select * from personal where perfil='abogado'";
        PreparedStatement sentencia;
        try {
            sentencia = bd.getConexion().prepareStatement(sql);
            ResultSet registros = sentencia.executeQuery();
            while (registros.next()) {
                usuarios.add(new Usuario(registros.getString("dni"), registros.getString("nombre")));
            }
            registros.close();

        } catch (SQLException ex) {
            Logger.getLogger(OperacionesTabla.class.getName()).log(Level.SEVERE, null, ex);
        }
        return usuarios;
    }

    public ArrayList<Caso> todosCasos() {

        ArrayList<Caso> casos = new ArrayList<>();
        String sql = "select * from casos where situacion='a'";
        PreparedStatement sentencia;
        try {
            sentencia = bd.getConexion().prepareStatement(sql);
            ResultSet registros = sentencia.executeQuery();
            while (registros.next()) {
                casos.add(new Caso(
                        registros.getString("codigo"),
                        registros.getString("dni"),
                        registros.getString("titulo"),
                        registros.getString("descripcion"),
                        registros.getString("situacion")));
            }
            registros.close();

        } catch (SQLException ex) {
            Logger.getLogger(OperacionesTabla.class.getName()).log(Level.SEVERE, null, ex);
        }
        return casos;
    }

    public boolean existeCodigoCaso(String codigo) {
        boolean resultado = false;
        String sql = "select * from casos where codigo='" + codigo + "'";
        PreparedStatement sentencia;

        try {
            sentencia = bd.getConexion().prepareStatement(sql);
            ResultSet registros = sentencia.executeQuery();
            if (registros.next()) {
                resultado = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(OperacionesTabla.class.getName()).log(Level.SEVERE, null, ex);
        }

        return resultado;
    }

    public int crearCaso(String codigo, String dni, String titulo, String descripcion, String situacion) {
        int resultado = 0;
        PreparedStatement sentencia;
        try {
            String sql = "insert into casos (codigo, dni, titulo, descripcion, situacion) "
                    + "values ('" + codigo + "', '" + dni + "', '" + titulo + "', '" + descripcion + "', '" + situacion + "')";

            //String sql = "INSERT INTO casos VALUES('"+codigo+"',"+dni+"',"+titulo+"',"+descripcion+"',"+situacion+"')";
            sentencia = bd.getConexion().prepareStatement(sql);
            resultado = sentencia.executeUpdate();
            sentencia.close();

        } catch (SQLException ex) {
            Logger.getLogger(OperacionesTabla.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultado;
    }

    public ArrayList<Caso> buscarCasos(String dni) {
        ArrayList<Caso> casos = new ArrayList<>();
        String SQL = "select * from casos where dni='" + dni + "' and situacion='a'";
        Statement sentencia;
        ResultSet resultado;
        try {
            sentencia = bd.getConexion().createStatement();
            resultado = sentencia.executeQuery(SQL);
            while (resultado.next()) {
                String codigo = resultado.getString("codigo");
                String titulo = resultado.getString("titulo");
                String descripcion = resultado.getString("descripcion");
                casos.add(new Caso(codigo, titulo, descripcion));
            }
        } catch (SQLException ex) {
            Logger.getLogger(OperacionesTabla.class.getName()).log(Level.SEVERE, null, ex);
        }
        return casos;
    }

    public ArrayList<Caso> buscarTodosCasosAbogado(String dni) {
        ArrayList<Caso> casos = new ArrayList<>();
        String SQL = "select * from casos where dni='" + dni + "'";
        Statement sentencia;
        ResultSet resultado;
        try {
            sentencia = bd.getConexion().createStatement();
            resultado = sentencia.executeQuery(SQL);
            while (resultado.next()) {
                String codigo = resultado.getString("codigo");
                String dniAbog = resultado.getString("dni");
                String titulo = resultado.getString("titulo");

                String descripcion = resultado.getString("descripcion");
                String situacion = resultado.getString("situacion");
                casos.add(new Caso(codigo, dniAbog, titulo, descripcion, situacion));
            }
        } catch (SQLException ex) {
            Logger.getLogger(OperacionesTabla.class.getName()).log(Level.SEVERE, null, ex);
        }
        return casos;
    }

    public ArrayList<Accion> buscarAcciones(String codCaso) {
        ArrayList<Accion> acciones = new ArrayList<>();
        String SQL = "select * from acciones where cod_caso='" + codCaso + "'";
        Statement sentencia;
        ResultSet resultado;
        try {
            sentencia = bd.getConexion().createStatement();
            resultado = sentencia.executeQuery(SQL);
            while (resultado.next()) {
                String codAccion = resultado.getString("cod_accion");
                String fecha = resultado.getString("fecha");
                String descripcion = resultado.getString("descripcion");
                acciones.add(new Accion(codAccion, fecha, descripcion));
            }
        } catch (SQLException ex) {
            Logger.getLogger(OperacionesTabla.class.getName()).log(Level.SEVERE, null, ex);
        }
        return acciones;
    }

    public int crearAccion(String codCaso, String codAccion, String fecha, String descripcion) {
        int resultado = 0;
        PreparedStatement sentencia;
        try {
            String sql = "insert into acciones (cod_caso, cod_accion, fecha, descripcion) "
                    + "values ('" + codCaso + "', '" + codAccion + "', '" + fecha + "', '" + descripcion + "')";

            //String sql = "INSERT INTO casos VALUES('"+codigo+"',"+dni+"',"+titulo+"',"+descripcion+"',"+situacion+"')";
            sentencia = bd.getConexion().prepareStatement(sql);
            resultado = sentencia.executeUpdate();
            sentencia.close();

        } catch (SQLException ex) {
            Logger.getLogger(OperacionesTabla.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultado;
    }

    public int cerrarCaso(String codigo) {
        int resultado = 0;
        PreparedStatement sentencia;
        try {
            String sql = "UPDATE casos SET situacion = 'c' WHERE (codigo = '" + codigo + "')";
            sentencia = bd.getConexion().prepareStatement(sql);
            resultado = sentencia.executeUpdate();
            sentencia.close();

        } catch (SQLException ex) {
            Logger.getLogger(OperacionesTabla.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultado;
    }
    
    public boolean existeAccion(String codCaso, String codAccion) {
        boolean resultado = false;
        String sql = "select cod_caso, cod_accion from acciones where cod_caso='" + codCaso + "' and cod_accion='"+codAccion+"'";
        PreparedStatement sentencia;

        try {
            sentencia = bd.getConexion().prepareStatement(sql);
            ResultSet registros = sentencia.executeQuery();
            if (registros.next()) {
                resultado = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(OperacionesTabla.class.getName()).log(Level.SEVERE, null, ex);
        }

        return resultado;
    }


}
