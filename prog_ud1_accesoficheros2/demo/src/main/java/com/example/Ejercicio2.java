package com.example;

import java.io.File;

public class Ejercicio2 {
    public static void main(String[] args) {
        ClasificaDirectorio organizador=new ClasificaDirectorio();
        organizador.segunExtension("/home/sanclemente.local/a19albertons/Descargas/test");
    }
    
}
class ClasificaDirectorio{
    public void segunExtension(String Dir){
        try{
            File Directorio = new File(Dir);
            String[] lista = Directorio.list();
            String extension;
            for (int i = 0; i< lista.length;i++) {
                // System.out.println(i);
                File src = new File(Dir+"/"+lista[i]);
                if (src.isFile()) {
                    extension = lista[i].split("\\.")[1];
                }
                else {
                    continue;
                }
                // Control carpeta
                if (!new File(Dir+"/"+extension.toUpperCase()).isDirectory()) {
                    new File(Dir+"/"+extension.toUpperCase()).mkdir();
                }
                // Ficheros
                File dst = new File(Dir+"/"+extension.toUpperCase()+"/"+lista[i]);
                src.renameTo(dst);
                
            }
        }
        catch (Exception e){
            System.out.println("Error desconocido/no cotemplado hasta la fecha");
            // System.out.println(e);
        }
    }
}