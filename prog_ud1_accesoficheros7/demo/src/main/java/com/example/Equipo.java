package com.example;

import java.io.Serializable;

public class Equipo implements Comparable<Equipo>, Serializable  {
    String nombre;
    int victorias;
    int derrotas;
    int puntosFavor;
    int puntosContra;
    public int getPartidosJugados() {
        return victorias+derrotas;
    }
    public int getPuntos() {
        return victorias*2+derrotas*1;
    }
    public int getDiferenciaPuntos() {
        return puntosFavor-puntosContra;
    }
    public Equipo(String nombre, int victorias, int derrotas, int puntosFavor, int puntosContra) {
        this.nombre = nombre;
        this.victorias = victorias;
        this.derrotas = derrotas;
        this.puntosFavor = puntosFavor;
        this.puntosContra = puntosContra;
    }
    @Override
    public int compareTo(Equipo otroEquipo) {
        int devolver;
       
        if (this.getPuntos() > otroEquipo.getPuntos()) {
            devolver = 1;
        }
        else if (this.getPuntos() == otroEquipo.getPuntos()) {
            if (this.getDiferenciaPuntos()>otroEquipo.getDiferenciaPuntos()) {
                devolver = 1;
            }
            else if (this.getDiferenciaPuntos()==otroEquipo.getDiferenciaPuntos()) {
                devolver=0;
            }
            else {
                devolver=-1;
            }
        }
        else {
            devolver=-1;
        }
        
        return devolver;
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
        return result;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Equipo other = (Equipo) obj;
        if (nombre == null) {
            if (other.nombre != null)
                return false;
        } else if (!nombre.toUpperCase().equals(other.nombre.toUpperCase()))
            return false;
        return true;
    }
    
    
    
}
