/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utilidades;


import java.util.Scanner;
import java.lang.NumberFormatException;
import java.util.InputMismatchException;



/**
 *
 * @author Yesica
 */
public class Numeros {

    /**
     * Método para pedir double. Método para pedir un número con decimales superior a 0
     * @param mensaje texto a mostrar
     * @param limiteInf límite inferior
     * @return número decimal
     */
    public static double pedirDouble(String mensaje, float limiteInf) {
        double dato = 0;
        String inf = "";
        boolean correcto = false;
        Scanner entrada;
        entrada = new Scanner(System.in);
        while (!correcto) {
            System.out.println(mensaje);
            try {
                inf = entrada.nextLine();
                dato = Double.parseDouble(inf);
                if (dato < limiteInf) {
                    System.out.println("Error. El numero debe ser mayor de " + limiteInf);

                } else {
                    correcto = true;
                }
            } catch(NumberFormatException ex){
                System.out.println(inf + " no es un número válido");
            }
        }

        return dato;
    }
  
/**
 * Metodo pedir Float. Método para pedir un número con decimales superior a 0
 * @param mensaje
 * @param limiteInf
 * @return numero decimal
 */
    public static float pedirFloat(String mensaje, float limiteInf) {
        float dato = 0;
        String inf = "";
        boolean correcto = false;
        Scanner entrada;
        entrada = new Scanner(System.in);
        while (!correcto) {
            System.out.println(mensaje);
            try {
                inf = entrada.nextLine();
                dato = Float.parseFloat(inf);
                if (dato < limiteInf) {
                    System.out.println("Error. El numero debe ser mayor de " + limiteInf);

                } else {
                    correcto = true;
                }
            } catch(NumberFormatException ex){
                System.out.println(inf + " no es un número válido");
            }
        }

        return dato;
    }

    /**
     * Método para pedir numero entero. sin ningun tipo de limite inferior o
     * superior
     *
     * @param mensaje
     * @return número
     */
    public static int pedirInt(String mensaje) {
        int dato = 0;
        String inf = "";
        boolean correcto = false;
        Scanner entrada;
        entrada = new Scanner(System.in);
        while (!correcto) {
            System.out.println(mensaje);
            try {
                inf = entrada.nextLine();
                dato = Integer.parseInt(inf);
                correcto = true;
            } catch (NumberFormatException ex) {
                System.out.println(inf + " no es un número entero");
            }
        }

        return dato;
    }

    /**
     * Método para pedir número entero con límite inferior.
     *
     * @param mensaje mensaje a mostrar
     * @param limiteInf límite inferior
     * @return devuelve dato mayor al limite inferior marcado
     */
    public static int pedirInt(String mensaje, int limiteInf) {
        int dato = 0;
        String inf = "";
        boolean correcto = false;
        Scanner entrada;
        entrada = new Scanner(System.in);
        while (!correcto) {
            System.out.println(mensaje);
            try {
                inf = entrada.nextLine();
                dato = Integer.parseInt(inf);
                if (dato < limiteInf) {
                    System.out.println("Error. El numero debe ser mayor de " + limiteInf);

                } else {
                    correcto = true;
                }
            } catch (NumberFormatException ex) {
                System.out.println(inf + " no es un número entero");
            }
        }

        return dato;
    }

    /**
     * Método para pedir número entero entre dos límites.
     *
     * @param mensaje texto a mostrar
     * @param limiteInf límite inferior
     * @param limiteSup límite superior
     * @return devuelve número entero
     */
    public static int pedirInt(String mensaje, int limiteInf, int limiteSup) {
        int dato = 0;
        String inf = "";
        boolean correcto = false;
        Scanner entrada;
        entrada = new Scanner(System.in);
        while (!correcto) {
            System.out.println(mensaje);
            try {
                inf = entrada.nextLine();
                dato = Integer.parseInt(inf);
                if ((dato < limiteInf) || (dato > limiteSup)) {
                    System.out.println("Error. El numero debe ser mayor de " + limiteInf + " y menor de " + limiteSup);

                } else {
                    correcto = true;
                }
            } catch (NumberFormatException ex) {
                System.out.println(inf + " no es un número entero");
            }
        }

        return dato;
    }

    /**
     * Main pruebas.
     * Para comprobar que los métodos funcionan
     * @param args 
     */
    public static void main(String[] args) {
        float num;
        num = Numeros.pedirInt("numero", 0,5);
    }
}
