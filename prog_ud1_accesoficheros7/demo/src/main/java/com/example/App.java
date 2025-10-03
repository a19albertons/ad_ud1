package com.example;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        try {
            Scanner sc = new Scanner(System.in);
            int opcion = 6;
            Equipo[] equipo = new Equipo[18];
            Clasificacion clasificacion = new Clasificacion(equipo);
            String nombre;
            int victorias;
            int derrotas;
            int puntosFavor;
            int puntosContra;
            while (opcion!=5) {
                System.out.println("-----------Menu---------");
                System.out.println("1- Añadir equipo");
                System.out.println("2- Mostrar clasificación");
                System.out.println("3- Guardar clasificación");
                System.out.println("4- Cargar clasificación");
                System.out.println("5- Salir");

                opcion = sc.nextInt();

                switch (opcion) {
                    case 1:
                        System.out.println("Ingrese los datos del equipo:");
                        System.out.println("Nombre: (sin espacios)");
                        nombre=sc.next();
                        System.out.println("victorias: (numero)");
                        victorias=sc.nextInt();
                        System.out.println("derrotas: (numero)");
                        derrotas=sc.nextInt();
                        System.out.println("puntos favor: (numero)");
                        puntosFavor=sc.nextInt();
                        System.out.println("puntos contra: (numero)");
                        puntosContra=sc.nextInt();
                        clasificacion.addEquipo(new Equipo(nombre, victorias, derrotas, puntosFavor, puntosContra));
                        break;
                    
                    case 2:
                        // System.out.println("entro aqui");
                        clasificacion.toString();
                        break;
                    
                    case 3:
                        try {
                            clasificacion.saveClasificacion();
                        } catch (IOException e) {
                            System.out.println("Ha habido algun error inesperado al intentar guardar el fichero");
                        }
                    
                    case 4:
                        clasificacion.loadClasificacion();
                    default:
                        break;
                }
            }
            sc.close();
        } catch (InputMismatchException e) {
            System.out.println("Error: Tipo de dato incorrecto. Por favor, ingrese el tipo de dato indicado.");
        } catch (Exception e) {
            System.out.println("Error inesperado indique este codigo de error a soporte: "+e.getMessage());
            
        }

    }
}
