package com.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

/**
 * Hello world!
 *
 */
public class Ejercicio1
{
    public static void main( String[] args )
    {
        CopiaFichero ejecutar = new CopiaFichero();
        try {
            ejecutar.copiar();
        } catch (IOException e) {
            System.out.println("Ha habido algun problema al procesar el fichero bien al leer el origen o bien al leer el destino");
        }
    }
}

class CopiaFichero {
    public void copiar() throws IOException{
        Path rutaOrigen = Paths.get("dir/origen.txt");
        Path rutaDestino = Paths.get("dir/copia.txt");
        Files.copy(rutaOrigen, rutaDestino, StandardCopyOption.REPLACE_EXISTING);

        Path backup = Paths.get("dir/backup");
        Path destinoBackup = Paths.get("dir/backup/copia.txt");
        if (Files.notExists(backup)) {
            Files.createDirectories(backup);
        }

        Files.move(rutaDestino, destinoBackup);
    }
}