package Boletin1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class Ej2 {
    public static void main(String[] args) {

       /* Con Java IO:
       File archivoNuevo = new File(".\\src\\Boletin1\\FicheroNuevo.txt");
        try(BufferedReader br = new BufferedReader(new FileReader(archivoNuevo))){
            String linea;
            StringBuilder acum = new StringBuilder();
            while ((linea = br.readLine()) != null){
               acum.append(linea);
            }
            System.out.println("El contenido del fichero es " + acum);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Con Java NIO:*/

        Path path = Paths.get(".\\src\\Boletin1\\FicheroNuevo.txt");
        try{
            Stream<String> =
        }

    }
}

