package com.example;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Ejercicio2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ManejoFicheros hello = new ManejoFicheros();

        // Prueba creaciones
        System.out.println("Creaciones");
        hello.crearFichero("/etc/hola.txt");
        hello.crearFichero("exito.txt");
        hello.crearDirectorio("/etc/carpeta");
        hello.crearDirectorio("temporal");

        // Prueba borrado basica
        System.out.println("\nBorrado");
        hello.borrarFichero("/etc/xattr.conf");
        hello.borrarFichero("exito.txt");
        hello.borrarDirectorio("/etc");
        hello.borrarDirectorio("temporal");

        // Prueba borrado tocha
        hello.borrarDirectorio("tocho");

        System.out.println("\nListar");
        hello.listarDirectorios(".");

        sc.close();
        
    }
}
class ManejoFicheros {

    public void crearFichero(String fichero){
        try {
            File crearFichero = new File(fichero);
            boolean exito = crearFichero.createNewFile();
            if (exito) {
                System.out.println("Creado con exito");
            }
            else {
                System.out.println("Me temo que ya existe");
            }
            
        }
        catch (IOException e) {
            System.out.println("No se ha podido crear el fichero. Error conocido no tiene suficientes permisos");
        }
        catch (Exception e){
            System.out.println("Causa desconocida");
        }
    }
    public void borrarFichero(String fichero){
        try {
            File crearFichero = new File(fichero);
            boolean exito = crearFichero.delete();
            if (exito) {
                System.out.println("Borrado con exito");
            }
            else {
                System.out.println("No se ha podido borrar o no existe o no tiene permisos suficientes");
            }
        }
        catch (SecurityException e) {
            System.out.println("No se ha podido crear el fichero. Error conocido no tiene suficientes permisos");
        }
        catch (Exception e){
            System.out.println("Causa desconocida");
        }
    }
    public void crearDirectorio(String ruta){
        try {
            File crearDirectorio = new File(ruta);
            boolean exito = crearDirectorio.mkdir();
            if (exito) {
                System.out.println("Creado con exito");
            }
            else {
                System.out.println("Existe o no tiene suficientes permisos");
            }
        }
        catch (SecurityException e) {
            System.out.println("No se ha podido crear la carpeta. Error conocido no tiene suficientes permisos");
        }
        catch (Exception e){
            System.out.println("Causa desconocida");
        }
    }
    public void borrarDirectorio(String ruta){
        File borrarDirectorio = new File(ruta);
        borrarDirectorioR(borrarDirectorio);
    }
    private boolean borrarDirectorioR(File carpeta){
        boolean devolver;
        try {
            if (carpeta.isDirectory()) {
                String[] listado = carpeta.list();
                for (int i = 0; i < listado.length; i++) {
                    borrarDirectorio(carpeta.getPath()+"/"+listado[i]);
                }
            }
            devolver = carpeta.delete();
        }
        catch (SecurityException e) {
            devolver = false;
            System.out.println("No ha tenido suficientes permisos para borrar: "+carpeta.getName());
        }
        catch (Exception e){
            devolver=false;
            System.out.println("Ha habido algun tipo de error desconocido al intentar borrar "+carpeta.getName());
        }
        return devolver;

    }
    public void listarDirectorios(String ruta){
        try {
            File listarDirectorios = new File(ruta);
            String[] list = listarDirectorios.list();
            list = listarDirectorios.list();
            File modificable;
            for (int i=0; i<list.length;i++){
                modificable = new File(ruta+"/"+list[i]);
                if (modificable.isDirectory()) {
                    System.out.println(list[i]+" es directorio");
                }
                else {
                    System.out.println(list[i]+" es file");
                }
            }

        }
        catch (SecurityException e) {
            System.out.println("No se ha podido listar la carpeta. Error conocido no tiene suficientes permisos");
        }
        catch (Exception e){
            System.out.println("Causa desconocida");
        }
    }
}