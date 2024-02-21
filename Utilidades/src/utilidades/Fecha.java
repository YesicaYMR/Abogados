/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utilidades;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

/**
 *
 * @author Yesica
 */
public class Fecha {

    int dia;
    int mes;
    int anno;
    static int[] diasMes = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    /**
     * constructor con la fecha actual
     */
    public Fecha() {
        Calendar c = new GregorianCalendar();
        dia = c.get(Calendar.DAY_OF_MONTH);
        mes = c.get(Calendar.MONTH) + 1;
        anno = c.get(Calendar.YEAR);
    }

    public Fecha(int dia, int mes, int anno) {
        this.dia = dia;
        this.mes = mes;
        this.anno = anno;
    }

    public int getDia() {
        return dia;
    }

    public int getMes() {
        return mes;
    }

    public int getAnno() {
        return anno;
    }

    /**
     *
     * @param mensaje
     * @return
     */
    public static Fecha pedirFecha(String mensaje) {
        String fecha;//El texto que escribe el usuario
        Fecha miFecha = new Fecha();//instancia un objeto de la clase fecha
        Scanner entrada = new Scanner(System.in);
        System.out.println(mensaje);
        fecha = entrada.nextLine();
        while (!(miFecha.comprobarFecha(fecha))) {//desde el objeto miFecha, llamo al método y le mando el String fecha
            System.out.println("fecha incorrecta");
            System.out.println("Introduce una fecha");
            fecha = entrada.nextLine();
        }
        return miFecha;
    }

    /**
     *
     * @param fecha
     * @return
     */
    public boolean comprobarFecha(String fecha) {
        String[] resultado;
        resultado = fecha.split("/");
        boolean correcto = true;

        if (resultado.length != 3) {// xq tiene que tener 3 espacios(dias, mes y año)
            correcto = false;
        } else {
            try {
                //comprobar primero el año
                dia = Integer.parseInt(resultado[0]);
                mes = Integer.parseInt(resultado[1]);
                anno = Integer.parseInt(resultado[2]);
                //preguntar antes x el mes que el dia
                if (mes < 1 || mes > 12) {
                    correcto = false;
                } else if (dia < 1 || dia > diasMes[mes - 1])//-1 xq empieza a contar desde 0 Enero=0
                {
                    correcto = false;
                }

            } catch (NumberFormatException ex) {
                correcto = false;
            } catch (Exception ex) {
                correcto = false;
            }
        }
        return correcto;
    }

    /**
     *
     */
    private void bisiesto() {
        if (anno % 4 == 0 && anno % 100 != 0 || anno % 400 == 0) {
            diasMes[1] = 29;
        } else {
            diasMes[1] = 28;
        }
    }

    /**
     * calcula el numero de dias transcurridos desde el 1 de enero
     *
     * @return
     */
    public int calcularOrden() {
        int orden = 0;
        for (int mesAnterior = 0; mesAnterior < mes - 1; mesAnterior++) {
            orden = orden + diasMes[mesAnterior];
        }
        orden = orden + dia;
        return orden;
    }

    /**
     * calcula el numero de dias que quedan hasta final de año
     *
     * @return
     */
    public int calcularFinAnno() {
        int finAnno = numeroDiasAnno() - calcularOrden();
        return finAnno;
    }

    /**
     * Calcular el número de dias del año, comprobando los bisiestos
     *
     * @return
     */
    private int numeroDiasAnno() {
        int numDias;
        if (anno % 4 == 0 && anno % 100 != 0 || anno % 400 == 0) {
            numDias = 366;
        } else {
            numDias = 365;
        }
        return numDias;
    }

    /**
     * Obtiene la fecha actual
     *
     * @return
     */
    public static String fechaActual() {
        Date fecha = new Date();
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MMMM/YYYY");//cuatro M significan mes en letra
        return formatoFecha.format(fecha);
    }
   
 public static String fechaActualNumero() {
        Date fecha = new Date();
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/YYYY");//cuatro M significan mes en letra
        return formatoFecha.format(fecha);
    }
    
    /**
     * calcula la diferencia entre una fecha y la actual
     * @return 
     */
    public int calcularAnnos() {

        Fecha fhoy = new Fecha();
        int annos;
        annos = fhoy.getAnno() - anno;
        if (fhoy.getMes() < this.getMes()
                || fhoy.getMes() == this.mes
                && fhoy.getDia() < getDia()) {
            annos--;
        }
        return annos;
    }

    /**
     * calcula la diferencia entre dos años
     * @param f
     * @return 
     */
    public int calcularAnnos(Fecha f) {
        int annos;
        annos = f.getAnno() - anno;
        if (f.getMes() < this.getMes()
                || f.getMes() == this.mes
                && f.getDia() < getDia()) {
            annos--;
        }
        return annos;
    }

    /**
     * comprueba si la fecha introducida es menor.
     * @param miFecha
     * @return 
     */
    public boolean comprobarFechaMenor(Fecha miFecha) {
        boolean correcto = false;
        if ((anno < miFecha.anno) || (anno == miFecha.anno && mes < miFecha.mes)
                || (anno == miFecha.anno && mes == miFecha.mes && dia < miFecha.dia)) {
            correcto = true;
        }
        return correcto;
    }

    /**
     * Comprobar si la fecha introducida es mayor 
     * @param miFecha
     * @return 
     */
    public boolean comprobarFechaMayor(Fecha miFecha) {
        boolean correcto = false;
        if ((anno > miFecha.anno) || (anno == miFecha.anno && mes > miFecha.mes)
                || (anno == miFecha.anno && mes == miFecha.mes && dia > miFecha.dia)) {
            correcto = true;
        }
        return correcto;
    }

    /**
     * Metodo para comparar fechas. devuelve -1 si la fecha es menor. 1 si la
     * fecha es mayor. 0 si es igual
     *
     * @param miFecha
     * @return
     */
    public int compararFechas(Fecha miFecha) {
        int resultado;
        if ((anno < miFecha.anno) || (anno == miFecha.anno && mes < miFecha.mes)
                || (anno == miFecha.anno && mes == miFecha.mes && dia < miFecha.dia)) {
            resultado = -1;// fecha actual mayor a la fecha introducida
        } else {
            if ((anno > miFecha.anno) || (anno == miFecha.anno && mes > miFecha.mes)
                    || (anno == miFecha.anno && mes == miFecha.mes && dia > miFecha.dia)) {
                resultado = 1;
            }//fecha actual menor que la introducida
            else {
                resultado = 0;//son iguales
            }
        }
        return resultado;
    }
}
