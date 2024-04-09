package Boletin1;

import java.io.*;


public class Ej1 {

    public static void main(String[] args)  {

        File archivoNuevo = new File(".\\src\\Boletin1\\FicheroNuevo.txt");
        try(BufferedReader br = new BufferedReader(new FileReader(archivoNuevo))){
            int cont = 0;
            while ((br.readLine()) != null){
                cont++;
            }
            System.out.println("El fichero tiene " + cont + " lineas");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
