package com.example;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import java.util.Scanner;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class Ejercicio2 {
    public static void main( String[] args )
    {
        try {
            // Pedir toda la mierda y procesada basica
            Scanner sc = new Scanner(System.in);
            System.out.println("Nombre del fichero zip a descomprimir");
            String ficheroZip= sc.next();
            System.out.println("Donde quiere extraer su zip?");
            String ruta = sc.next();

            // Checamos la salida y zip
            File chequeosalida=new File(ruta);
            if (!chequeosalida.exists()) {
                chequeosalida.mkdir();
            }
            File chequeozip = new File(ficheroZip);
            if (!chequeozip.exists()) {
                System.out.println("El fichero no existe se sale por seguridad del programa");
                System.exit(0);
            }

            // descompresion fichero zip
            ExtraerZip creacion = new ExtraerZip();
            creacion.descomprimir(chequeozip, ruta);

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

class ExtraerZip {
    public void descomprimir(File zip, String ruta) throws FileNotFoundException,IOException{
        FileInputStream entradaZip = new FileInputStream(zip);
        ZipInputStream elPropioZip = new ZipInputStream(entradaZip);

        ZipEntry entrada;

        while ((entrada = elPropioZip.getNextEntry())!= null) {
            System.out.println("Extrayendo: "+entrada.getName());

            File nuevoFichero= new File(ruta, entrada.getName());
            File nuevaCarpeta= nuevoFichero.getParentFile();
            if (!nuevaCarpeta.exists()) {
                nuevaCarpeta.mkdir();
            }

            FileOutputStream salida = new FileOutputStream(nuevoFichero);
            byte[] buffer = new byte[1024];
            int bytesLeidos;
            while ((bytesLeidos = elPropioZip.read(buffer)) > 0) {
                salida.write(buffer,0,bytesLeidos);
            }
            salida.close();
        }
        elPropioZip.close();
        
    }
}
