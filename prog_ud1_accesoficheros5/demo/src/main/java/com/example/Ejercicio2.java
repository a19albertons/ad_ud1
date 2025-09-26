package com.example;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Ejercicio2 {
    public static void main(String[] args) {
        // Guardar mierda
        Persona caso1 = new Persona("persona", "hola");
        Persona caso2 = new Persona("persona2", "hola2");
        
        
        Almacenamiento gestion = new Almacenamiento("Persona.bin");
        Persona[] guardar = {caso1, caso2};
        try {
            gestion.guardar(guardar);
        }
        catch (FileNotFoundException e) {
            System.out.println("Fichero no encontrado");
        }
        catch (IOException e) {
            System.out.println("Algun error al leer el fichero");
        }
        catch (Exception e) {
            // TODO: handle exception
        }
        


        // Sacar mierda
        List<Persona> leido ;
        try {
            leido = gestion.leer();
            Persona p;
            for (int i=0;i<leido.size();i++){
                p=leido.get(i);
            System.out.println(p.nombre+" "+p.contrasena);
            }
        }
        catch (FileNotFoundException e) {
            System.out.println("Fichero no encontrado");
        }
        catch (IOException e) {
            System.out.println("Algun error al leer el fichero");
        }
        catch (Exception e) {
            // TODO: handle exception
        }



    }
}
class Almacenamiento {
        String fichero;

        public Almacenamiento(String fichero) {
            this.fichero = fichero;
        }

        public void guardar(Persona[] p) throws FileNotFoundException, IOException{
            
            FileOutputStream stream = new FileOutputStream(fichero);
            ObjectOutputStream out = new ObjectOutputStream(stream);

            for (int i=0; i<p.length;i++){
                out.writeObject(p[i]);
            }
            

            out.flush();
            out.close();

        }

        public List<Persona> leer() throws FileNotFoundException, IOException{
            
            
            FileInputStream stream = new FileInputStream(fichero);
            ObjectInputStream in = new ObjectInputStream(stream);

            Persona p; 
            List<Persona> devolver = new ArrayList<>();
            // Persona[] devolver = new Persona[2];
            while ((p = leerPersona(in)) != null) {
                devolver.add(p);
            }
            return devolver;

        }
        private Persona leerPersona(ObjectInputStream in){
            try {
                return (Persona) in.readObject();
            } catch (EOFException e) {
                return null; //Se alcanzó el final del fichero
            } catch (IOException | ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
        

}
class Persona implements Serializable {
    String nombre;
    String contrasena;
    public Persona(String nombre, String contrasena) {
        this.nombre = nombre;
        this.contrasena = contrasena;
    }

    
}
