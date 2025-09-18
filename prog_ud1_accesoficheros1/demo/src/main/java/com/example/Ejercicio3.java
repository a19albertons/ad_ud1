package com.example;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Ejercicio3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Indique una ruta");
        infoFichero mostrarInfo=new infoFichero(sc.next());
        mostrarInfo.mostrarInfo();

        sc.close();

        ManejoFicheros hello = new ManejoFicheros();

        // Prueba creaciones
        System.out.println("Creaciones");
        hello.crearFichero("/etc/hola.txt");
        hello.crearFichero("exito.txt");
        hello.crearDirectorio("/etc/carpeta");
        hello.crearDirectorio("temporal");

        // Prueba borrado
        System.out.println("\nBorrado");
        hello.borrarFichero("/etc/xattr.conf");
        hello.borrarFichero("exito.txt");
        hello.borrarDirectorio("/etc");
        hello.borrarDirectorio("temporal");

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
        try {
            File crearDirectorio = new File(ruta);
            boolean exito = crearDirectorio.delete();
            if (exito) {
                System.out.println("Borrado con exito");
            }
            else {
                System.out.println("No se ha podido borrar puede tener contenido o insuficientes permisos");
            }
        }
        catch (SecurityException e) {
            System.out.println("No se ha podido crear el carpeta. Error conocido no tiene suficientes permisos");
        }
        catch (Exception e){
            System.out.println("Causa desconocida");
        }
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