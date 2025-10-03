package com.example;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Clasificacion implements Serializable{
    Equipo[] equipos = new Equipo[18];

    public void addEquipo(Equipo nuevo) {
        for (int i = 0; i < equipos.length; i++) {
            if (equipos[i] == null) {
                equipos[i] = nuevo;
                break;
            }
        }
    }
    public void removeEquipo(Equipo eliminar) {
        for (int i = 0; i < equipos.length; i++) {
            if (equipos[i].equals(eliminar)) {
                equipos[i] = null;
                break;
            }
        }
    }
    @Override
    public String toString() {
        System.out.println("Clasificacion:");
        List<Equipo> listaEquiposReal = new ArrayList<>();
        for (int i = 0; i < equipos.length; i++) {
            if (equipos[i] != null) {
                listaEquiposReal.add(equipos[i]);
            }
        }
        listaEquiposReal.sort((e1, e2) -> e2.compareTo(e1));
        Equipo equipo;
        for (int i = 0; i < listaEquiposReal.size(); i++) {
            equipo = listaEquiposReal.get(i);
            System.out.println(""+equipo.nombre+" "+equipo.victorias+" "+equipo.derrotas+" "+equipo.puntosFavor+" "+equipo.puntosContra+" "+equipo.getPartidosJugados()+" "+equipo.getPuntos()+" "+equipo.getDiferenciaPuntos());
        }
        return "";
    }
    public Clasificacion(Equipo[] equipos) {
        this.equipos = equipos;
    }
    
    public void saveClasificacion() throws IOException{
        FileOutputStream stream = new FileOutputStream("clasificacion.dat");
        ObjectOutputStream out = new ObjectOutputStream(stream);
        for (int i = 0; i < equipos.length; i++) {
            if (equipos[i]!=null) {
                out.writeObject(equipos[i]);
            }
        }
        out.flush();
        out.close();   
    }
    public void loadClasificacion() {
        try (ObjectInputStream in = new ObjectInputStream(new
        FileInputStream("clasificacion.dat"))) {
        Equipo equipo;
        int contador=0;
        // Leer objetos Persona hasta que se alcance el final del archivo
        while ((equipo = leerEquipo(in)) != null) {
            System.out.println(equipo);
            equipos[contador]=equipo;
            contador++;
        }
        System.out.println("Final de archivo!");
        } catch (IOException e) {
        throw new RuntimeException(e);
        }
    }
    private static Equipo leerEquipo(ObjectInputStream in) {
        try {
            return (Equipo) in.readObject();
        } catch (EOFException e) {
            return null; //Se alcanzó el final del fichero
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
