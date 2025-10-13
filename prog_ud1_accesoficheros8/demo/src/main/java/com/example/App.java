package com.example;

import java.util.ArrayList;

/**
 * Hello world!
 *
 */
public class App
{
    public static void main( String[] args )
    {
        // Contenedor
        ArrayList<Productos> listaProductos = new ArrayList<>();
        // Los 2 componentes el segundo sin el proveedor lo definimos como campo no obligatorio
        listaProductos.add(new Productos("Ordenador gama media", 1000, true, new String[] {"Informatica", "Sobremesa","gama media"}, 10, "PC gama media con un i5 10º gen y gtx 1630", new Proveedor("Intel", "555665548")));
        listaProductos.add(new Productos("gpu 4GB vram", 400, false, new String[] {"gpu","AMD", "gaming"}, 0, "gpu amd 4GB de vram pensada para el juego en 2025"));

        // Creamos las operaciones en Gestor Productos
        GestorProductos gestion= new GestorProductos();
        gestion.guardarProductos(listaProductos);

        gestion.leerProductosPantalla();

        ArrayList<Productos> productosLeidos = gestion.leerProductos();
        System.out.println("Tienes "+productosLeidos.size()+" productos leidos del fichero JSON");


    }
}
