package com.example;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class CrearZip {
    public void comprimirDirectorio(File ruta) throws FileNotFoundException,IOException {
        String[] ficheros=ruta.list();
        FileOutputStream fichero = new FileOutputStream(ruta+"/directorio.zip");
        ZipOutputStream ficheroZip = new ZipOutputStream(fichero);
        
        for (int i = 0; i < ficheros.length; i++) {
            añadirFichero(ruta.getPath()+"/"+ficheros[i], ficheroZip);
        }
        ficheroZip.close();
        fichero.close();
    }

    public void comprimir(String ruta, List<String> ficheros) throws FileNotFoundException,IOException{
        FileOutputStream fichero = new FileOutputStream(ruta);
        ZipOutputStream ficheroZip = new ZipOutputStream(fichero);
        
        for (int i = 0; i<ficheros.size();i++) {
            añadirFichero(ficheros.get(i),ficheroZip);

        }
        ficheroZip.close();
        fichero.close();

    }
    private void añadirFichero(String fichero, ZipOutputStream ficheroZip) throws FileNotFoundException,IOException{
        File ficheroFile= new File(fichero);
        FileInputStream ficheroInput = new FileInputStream(ficheroFile);
        
        ZipEntry zipEntry = new ZipEntry(ficheroFile.getName());
        ficheroZip.putNextEntry(zipEntry);

        byte[] buffer = new byte[1024];
        int bytesLeidos;
        while((bytesLeidos = ficheroInput.read(buffer)) >= 0) {
            ficheroZip.write(buffer, 0, bytesLeidos);
        }
        ficheroInput.close();
            
    }

}