/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utilidades;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author Yesica
 */
public class Encriptacion {
    public class Encriptar {}
   
    public static String getMD5(String input) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] messageDigest = md.digest(input.getBytes());//aplica el algoritmo de encriptacion al string que recibe
            BigInteger number = new BigInteger(1, messageDigest);
           
            String hashtext = number.toString(16);
            while (hashtext.length() < 32) {//quiero que la contraseña ya encriptada tenga 32 caracteres
                hashtext = "0" + hashtext;//lo rellena con 0 hasta los 32
            }
            return hashtext;
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

}


