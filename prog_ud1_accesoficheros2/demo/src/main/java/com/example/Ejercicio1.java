package com.example;

import java.io.File;
import java.io.FilenameFilter;

/**
 * Hello world!
 *
 */
public class Ejercicio1
{
    public static void main( String[] args )
    {
        String ruta = ".";
        String extension = "xml";
        Filtrar filtro1= new Filtrar();
        filtro1.filtrar(ruta, extension);

    }

}


class Filtrar {
    public void filtrar(String ruta, String extension){
        try {
            // En teoria evita el nulo
            File filtrada = new File(ruta);
            if (filtrada.isDirectory()) {
                String[] lista = filtrada.list();
                FiltrarNombre filtro = new FiltrarNombre();
                for (int i = 0; i<lista.length;i++){
                    if (filtro.accept(new File(ruta+"/"+lista[i]), extension)) {
                        System.out.println(lista[i]);
                    }
                }
            }
        }
        catch (SecurityException e) {
            System.out.println("Presuntamente usted no tiene permisos suficientes");
        }
        catch (Exception e) {
            System.out.println("Error desconocido");
        }

    }
}

class FiltrarNombre implements FilenameFilter{

    @Override
    public boolean accept(File ruta, String extension) {
        boolean devolver;
        if (ruta.getName().endsWith(extension)) {
            devolver = true;
        }
        else {
            devolver = false;
        }
        return devolver;
    }

}