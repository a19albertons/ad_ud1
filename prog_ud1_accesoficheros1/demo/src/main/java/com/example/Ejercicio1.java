package com.example;

import java.io.File;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class Ejercicio1
{
    public static void main( String[] args )
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Indique una ruta");
        infoFichero mostrarInfo=new infoFichero(sc.next());
        mostrarInfo.mostrarInfo();

        sc.close();
    }
}
class infoFichero {
    String fichero;

    infoFichero(String ruta){
        this.fichero=ruta;
    }
    
    public void mostrarInfo(){
        File test = new File(fichero);
        try {
            System.out.println("");
            System.out.println("-------------------");
            System.out.println("");

            if (test.exists()) {
                System.out.println("Información sobre la ruta nombre, ruta levativa y absoluta, permisos lectura/escritura, tamaño y si es directorio/fichero");
                System.out.println();
                System.out.println(test.getName());
                System.out.println(test.getPath());
                System.out.println(test.getAbsolutePath());
                System.out.println(test.canRead());
                System.out.println(test.canWrite());
                System.out.println(test.length());
                System.out.println(test.isDirectory());
                System.out.println(test.isFile());
            }
            else {
                System.out.println("La ruta indicada no existe.");
            }
        } catch (SecurityException e) {
            System.out.println("Insuficientes permisos");
        }
    }
}
