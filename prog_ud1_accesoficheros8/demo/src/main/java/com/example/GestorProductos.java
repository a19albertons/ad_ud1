package com.example;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class GestorProductos {
    // Creamos el gson bonito
    Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public void guardarProductos(ArrayList<Productos> productos){
        // Guardamos el contenido como json
        String contenido  = gson.toJson(productos);
        FileWriter fichero;
        // Controlamos las operaciones en el fichero
        try {
            fichero = new FileWriter("productos.json");
            fichero.write(contenido);
            fichero.close();
        } catch (IOException e) {
            System.out.println("No se ha podido guardar el archivo productos.json actualizado revise si se puede escribir en el disco o si ya tiene el fichero este sea escribible (permisos)");
        }
    }

    public void leerProductosPantalla(){
            // Manejamos las operaciones en el fichero
        try {
            FileReader fichero = new FileReader("productos.json");
            Productos[] producto = gson.fromJson(fichero, Productos[].class);
            Productos p;
            for (int i= 0; i< producto.length; i++){
                // Acortamos el asunto
                p = producto[i];
                // Creamos la primera parte hasta el array de String de categorias
                System.out.print("nombre: "+p.getNombre()+" prezo: "+p.getPrezo()+" disponible: "+p.isDisponible()+" categorias: ");
                // Manejamos el array de categorias
                for (int j=0; j<p.getCategorias().length;j++) {
                    System.out.print(p.getCategorias()[j]+" ");
                }
                // Continuamos con el resto de campos obligatorios
                System.out.print(" stock:"+p.getStock()+" descripcion: "+p.getDescripcion());
                // Controlamos el campo que puede no estar definido
                if (p.getProveedor()!=null){
                    System.out.print(" proveedor: "+p.getProveedor().getNombre()+" telefono: "+p.getProveedor().getTelefono());
                }
                // Forzamos el salto de linea
                System.out.println();
            }

            fichero.close();

        // Manejo de errores
        } catch (FileNotFoundException e) {
            System.out.println("No se ha podido encontrar el archivo productos.json. La lista se devuelve vacia");
        } catch (IOException e) {
            System.out.println("Sucedio algún error al intentar cerrar el fichero abierto productos.json. Se devuelve la lista de productos vacia preventivamente");
        }
    }
    public ArrayList<Productos> leerProductos(){
        // Arraylist que devolvemos
        ArrayList<Productos> listaProductos = new ArrayList<>();
        // Manejamos las operaciones en el fichero
        try {
        FileReader fichero = new FileReader("productos.json");
        Productos[] producto = gson.fromJson(fichero, Productos[].class);
        Productos p;
        for (int i= 0; i< producto.length; i++){
            // Acortamos el asunto
            p = producto[i];
            listaProductos.add(p);
        }

        fichero.close();

        // Manejo de errores
        } catch (FileNotFoundException e) {
            System.out.println("No se ha podido encontrar el archivo productos.json. La lista se devuelve vacia");
            listaProductos = new ArrayList<>();
        } catch (IOException e) {
            System.out.println("Sucedio algún error al intentar cerrar el fichero abierto productos.json. Se devuelve la lista de productos vacia preventivamente");
            listaProductos = new ArrayList<>();
        }
        // Devolvemos la lista
        return listaProductos;
    }
}
