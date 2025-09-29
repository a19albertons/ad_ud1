package com.example;

import java.io.FileNotFoundException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


/**
 * Hello world!
 *
 */
public class Ejercicio1
{
    public static void main( String[] args )
    {
        try {
            // Pedir toda la mierda y procesada basica
            Scanner sc = new Scanner(System.in);
            System.out.println("nombre del zip a crear (no olvide el .zip): ");
            String ruta = "./almacen/"+sc.next();
            System.out.println("Cuantos fichero quiere añadir debe ser un entero");
            int cantidad = sc.nextInt();
            List<String> ficheros = new ArrayList<>();
            for (int i = 0; i<cantidad;i++) {
                System.out.println("nombre fichero: "+(i+1));
                ficheros.add("./almacen/"+sc.next());
            }

            // Creacion fichero zip
            CrearZip creacion = new CrearZip();
            creacion.comprimir(ruta, ficheros);

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

