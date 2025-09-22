package com.example;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class ManejoFicheroTexto
{
    public static void main( String[] args )
    {
        // No se le aplica excepción la cagada potencial depende del programador especificamente
        File destino = new File("destino.txt");
        FicheroTexto fichero = new FicheroTexto(destino);
        Scanner sc = new Scanner(System.in);
        //Para entrar
        int opcion = 1;
        while (opcion!=3) {
            try {
                System.out.println("1. Escribir en el fichero.\n" + //
                                    "2. Leer fichero.\n" + //
                                    "3. Salir. ");
                opcion = sc.nextInt();
                switch (opcion) {
                    case 1:
                        System.out.println("Que quiere escribir.");
                        fichero.escribir(sc.next());
                        break;
                    
                    case 2:
                        if (destino.exists()) {
                            fichero.leer();
                        }
                        else {
                            System.out.println("El fichero no existe por lo tanto primero use la opcion 1. Gracias");
                        }
                        break;
                    case 3:
                        break;
                    default:
                        System.out.println("Numero valido le recuerdo que son del 1 al 3");
                        break;
                }
            } 
            catch (SecurityException e) {
                System.out.println("Ha habido algun problema con el fichero al verificar si existe");
            }
            catch (Exception e) {
                System.out.println("Error no previsto");
            }
        }
        sc.close();
    }
}

class FicheroTexto {
    File temporal;

    public FicheroTexto(File temporal) {
        this.temporal = temporal;
    }

    public File getTemporal() {
        return temporal;
    }

    public void escribir(String texto){
        try {
            FileWriter escribir = new FileWriter(this.temporal,true);
            escribir.append(texto);
            escribir.close();
        } catch (IOException e) {
            System.out.println("No se ha podido escribir en el fichero. Lo más probable es que se tengan insuficientes permisos");
        }
        catch (Exception e) {
            System.out.println("Error no previsto");
        }
        
    }
    public void leer(){
        FileReader leer;
        try {
            leer = new FileReader(this.temporal);
            BufferedReader buffer = new BufferedReader(leer);
            System.out.println(buffer.readLine());
            buffer.close();
        } catch (FileNotFoundException e) {
            System.out.println("Fichero no encontrado. Use la opcion 2");
        }
        catch (IOException e) {
            System.out.println("Ha habido algun problema al leer el fichero");
        }
        catch (Exception e){
            System.out.println("Error no previsto");
        }
        
    }
}

