package com.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;


public class Ejercicio3 {
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);
            System.out.println("Indicame la carpeta a comprimir");
            String ruta = sc.next();

            File chequeoRuta= new File(ruta);
            if (!chequeoRuta.exists() || chequeoRuta.isFile() ) {
                System.out.println("Es un fichero o no existe");
                System.out.println("Se sale del programa de forma controlada");
                System.exit(0);
            }
            CrearZip comprimir = new CrearZip();
            comprimir.comprimirDirectorio(chequeoRuta);


            sc.close();
        }
        catch (FileNotFoundException e) {
            // TODO: handle exception
            System.out.println("Error critico el fichero no ha sido encontrado");
        } 
        catch (IOException e) {
            // TODO: handle exception
            System.out.println("Error en entrada y salida");
        }   
        catch (Exception e) {
            // TODO: handle exception
            System.out.println("Error en tiempo de ejecución no esperado");
            System.out.println("Indique a soporte esta excepción: "+e.getMessage());
        }
    }
}


