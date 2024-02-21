/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utilidades;

import java.util.Scanner;

/**
 *
 * @author Yesica
 */
public class Texto {
    /**
     * Método para pedir texto
     * @param mensaje texto para mostrar al usuario
     * @return devuelve el texto introducido por el usuario
     */
    public static String pedirString(String mensaje){
        String dato;
        Scanner entrada;
        entrada=new Scanner (System.in);
        System.out.println(mensaje);
        dato= entrada.nextLine();
        while (dato.trim().equalsIgnoreCase("")){
            System.out.println("Error. No has introducido texto"); 
            System.out.println(mensaje);
            dato=entrada.nextLine();
        }
        return dato;
    }
    
    public static String pedirString(){
        String dato;
        Scanner entrada;
        entrada=new Scanner (System.in);
        
        dato= entrada.nextLine();
        while (dato.trim().equalsIgnoreCase("")){
            System.out.println("Error. No has introducido texto"); 
        
            dato=entrada.nextLine();
        }
        return dato;
    }
}
