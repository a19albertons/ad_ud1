package com.example;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;


public class Ejercicio3 {
    
}

class FicheroBinario {
    File fichero;

    FicheroBinario(File fichero){
        this.fichero = fichero;
    }

    public File getFichero() {
        return fichero;
    }
    
    public void escribir(String texto){
        try {
            FileOutputStream escribir = new FileOutputStream(fichero);
            char[] textoCaracter = texto.toCharArray();
            for (int i = 0; i<textoCaracter.length; i++){
                escribir.write((byte) textoCaracter[i]);
            }
            escribir.close();
        } catch (Exception e) {
            System.out.println("Error no esperado");
        }

    }
    public void leer(){
        try {
            FileInputStream leer = new FileInputStream(fichero);
            // System.out.println(fichero.length());
            for (int i=0;i<fichero.length();i++){
                char j = (char) leer.read();
                System.out.print(j);
            }
            System.out.println("");
            leer.close();
        } catch (Exception e) {
            System.out.println("Error no esperado");
        }

    }
    public void copiar(FicheroBinario FicheroDestino){
        FicheroBinario origen =  new FicheroBinario(fichero);
        File origenFile = origen.fichero;
        File destinoFile = FicheroDestino.fichero;
        try {
            FileInputStream leer = new FileInputStream(origenFile);
            FileOutputStream escribir = new FileOutputStream(destinoFile);
            // System.out.println(fichero.length());
            for (int i=0;i<origenFile.length();i++){
                char j = (char) leer.read();
                escribir.write((byte) j);
            }
            System.out.println("");
            leer.close();
        } catch (Exception e) {
            System.out.println("Error no esperado");
        }
    }
}

class ManejoFicherosBinarios {
    public static void main(String[] args) {
            FicheroBinario origen = new FicheroBinario(new File("origen.bin"));
        FicheroBinario destino = new FicheroBinario(new File("destino.bin"));

        origen.escribir("ESTE ES EL TEXTO ORIGEN");
        origen.leer();
        origen.copiar(destino);
    }


}