package com.example;

import java.io.IOException;
import java.net.URI;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Ejercicio4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Indica un fichero zip");
        String zip = sc.next();
        System.out.println("Indique un fichero a añadir");
        String fichero = sc.next();
        try {
            Map<String, String> env = new HashMap<>();
            env.put("create", "true");
            Path path = Paths.get(zip);
            URI uri = URI.create("jar:" + path.toUri());
            
            try (FileSystem fs = FileSystems.newFileSystem(uri, env)) {
                Path file = Paths.get(fichero);//Fichero a incluir
                /************
                “/" + file.getFileName() ----> asegura que siempre escribes el fichero en
                la raíz del ZIP.
                ************/
                //fichero ZIP: me quedo con el nombre del fichero sin la ruta
                Path nf = fs.getPath("/" +file.getFileName());
                Files.write(nf, Files.readAllBytes(file), StandardOpenOption.CREATE);
                sc.close();
            }
        } catch(IOException e) {
            e.printStackTrace();
            sc.close();
        }
    }
}
