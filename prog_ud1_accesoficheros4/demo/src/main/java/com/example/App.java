package com.example;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        try {
            // Unos tester
            // manejoCifrado codificador = new manejoCifrado();
            // codificador.valorEncriptado('i');
            // codificador.valorEncriptado('b');
            // codificador.valorEncriptado('m');
            // codificador.encriptar("convertir.txt");
            // codificador.valorDesencriptado('h');
            // codificador.valorDesencriptado('a');
            // codificador.valorDesencriptado('l');
            // codificador.desencriptar("convertir_codificacion.txt");

            Scanner sc = new Scanner(System.in);
            manejoCifrado variable = new manejoCifrado();
            int opcion = 0;
            while (opcion!=5) {
                System.out.println("Menu opciones");
                System.out.println("1. Valor encriptado");
                System.out.println("2. Valor desencriptado");
                System.out.println("3. Encriptar");
                System.out.println("4. Desenciptar");
                System.out.println("5. Exit");
                opcion = sc.nextInt();

                switch (opcion) {
                    case 1:
                        variable.valorEncriptado(sc.next().charAt(0));
                        break;
                    case 2:
                        variable.valorDesencriptado(sc.next().charAt(0));
                        break;
                    case 3:
                        System.out.println("Inqique una ruta a un fichero para encriptar");
                        variable.encriptar(sc.next());
                        break;
                    case 4:
                        System.out.println("Inqique una ruta a un fichero para desencriptar");
                        variable.desencriptar(sc.next());
                        break;
                    default:
                        break;
                }
                
                
            }
            

        } catch (Exception e) {
            System.out.println("Error en tiempo de ejecución no previsto. Habra una incidencia e indique los pasos del error");
        }

        
    }
}
class manejoCifrado {
    File cifrado=new File("codec.txt");
    FileReader leido;
    Map<Character, Character> decodeEnconde;
    Map<Character, Character> encodeDecode;
    public manejoCifrado(){
        try {
            this.leido=new FileReader(cifrado);
        } catch (FileNotFoundException e) {
            System.out.println("el fichero basico requerido codec.txt no existe");
        }
        BufferedReader linea1=new BufferedReader(leido);
        Map<Character, Character> temporal = new HashMap<>();
        Map<Character, Character> temporalReverse = new HashMap<>();
        try {
            String primera= linea1.readLine();
            String segunda = linea1.readLine();
            

            for (int i = 0; i<primera.length();i++) {
                char caracter1 = primera.charAt(i);
                char caracter2 = segunda.charAt(i);
                temporal.put(caracter1, caracter2);
                temporalReverse.put(caracter2, caracter1);
            }

        } catch (IOException e) {
            System.out.println("Revise el codec.txt ha habido problemas para procesar alguna linea");
        }
        catch (Exception e){
            System.out.println("Error no previsto. Habra incidencia indicando que pasos ha realizado para poder reproducir el error");
        }
        this.decodeEnconde=temporal;
        this.encodeDecode=temporalReverse;
    }

    public void valorEncriptado(Character caracter){
        if (!decodeEnconde.containsKey(caracter)) {
            System.out.println("El caracter indicado no tiene codificante");
        }
        else {
            char codificado = decodeEnconde.get(caracter);
            System.out.println(codificado);
        }
        
    }
    public void valorDesencriptado(Character caracter){
        if (!encodeDecode.containsKey(caracter)) {
            System.out.println("El caracter indicado no tiene decodificante");
        }
        else {
            char decodificado = encodeDecode.get(caracter);
            System.out.println(decodificado);
        }
        
    }
    public void encriptar(String ruta){
        try {
            File fichero = new File(ruta);
            FileReader leido= new FileReader(fichero);
            BufferedReader linea=new BufferedReader(leido);
            String lineaProcesar;
            String nombreBase=fichero.getName().split("\\.")[0];
            File ficheroEscribir=new File(nombreBase+"_codificacion.txt");
            FileWriter escribir = new FileWriter(ficheroEscribir,true);
            while ((lineaProcesar = linea.readLine()) != null ) {
                for (int i = 0; i<lineaProcesar.length();i++){
                    if (decodeEnconde.containsKey(lineaProcesar.charAt(i))) {
                        escribir.append(decodeEnconde.get(lineaProcesar.charAt(i)));
                    }
                    else {
                        escribir.append(lineaProcesar.charAt(i));
                    }
                }
            }
            linea.close();
            escribir.close();
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("Error no contemplado. Habra una incidencia con los pasos para reproducirla");
        }
    }
    public void desencriptar(String ruta){
        try {
            File fichero = new File(ruta);
            FileReader leido= new FileReader(fichero);
            BufferedReader linea=new BufferedReader(leido);
            String lineaProcesar;
            String nombreBase=fichero.getName().split("\\.")[0];
            File ficheroEscribir=new File(nombreBase+"_descodificacion.txt");
            FileWriter escribir = new FileWriter(ficheroEscribir,true);
            while ((lineaProcesar = linea.readLine()) != null ) {
                for (int i = 0; i<lineaProcesar.length();i++){
                    if (encodeDecode.containsKey(lineaProcesar.charAt(i))) {
                        escribir.append(encodeDecode.get(lineaProcesar.charAt(i)));
                    }
                    else {
                        escribir.append(lineaProcesar.charAt(i));
                    }
                }
            }
            linea.close();
            escribir.close();
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("Error no contemplado. Habra una incidencia con los pasos para reproducirla");
        }
    }
}